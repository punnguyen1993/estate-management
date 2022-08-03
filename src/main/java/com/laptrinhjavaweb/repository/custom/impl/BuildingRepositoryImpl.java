package com.laptrinhjavaweb.repository.custom.impl;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.custom.BuildingRepositoryCustom;
import com.laptrinhjavaweb.utils.SqlUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BuildingRepositoryImpl implements BuildingRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public List<BuildingEntity> findByDetail(BuildingSearchBuilder builder, Integer firstResult, Integer maxResult) {
        StringBuilder sql = new StringBuilder("SELECT * ")
                            .append(buildFromOfSearchingQuery(builder));
        Query query = entityManager.createNativeQuery(sql.toString(), BuildingEntity.class);
        query.setFirstResult(firstResult);
        query.setMaxResults(maxResult);
        return query.getResultList();
    }

    @Override
    public int countTotalDetailItems(BuildingSearchBuilder builder) {
        StringBuilder sql = new StringBuilder("SELECT COUNT(x.id) FROM (SELECT b.id ")
                            .append(buildFromOfSearchingQuery(builder))
                            .append(") as x");
        Query queryTotal = entityManager.createNativeQuery(sql.toString());
        int countResult = ((BigInteger)queryTotal.getSingleResult()).intValue();
        return countResult;
    }


    private StringBuilder buildFromOfSearchingQuery(BuildingSearchBuilder builder){
        StringBuilder sql = new StringBuilder("from building b");
        buildJoinQueryWithBuilder(builder, sql);
        sql.append(SystemConstant.WHERE_ONE_EQUAL_ONE);

        buildWhereClauseWithBuilderPart1(builder, sql);
        buildWhereClauseWithBuilderPart2(builder, sql);
        sql.append(" group by b.id");

        return sql;
    }

    private void buildJoinQueryWithBuilder(BuildingSearchBuilder builder, StringBuilder query) {
        if (builder.getStaffId() != null) {
            query.append(" inner join assignmentbuilding asb on b.id = asb.buildingid")
                    .append(" inner join user u on asb.staffid = u.id");
        }
        if (builder.getRentAreaFrom() != null || builder.getRentAreaTo() != null) {
            query.append(" inner join rentarea ra on b.id = ra.buildingid");
        }
    }

    private void buildWhereClauseWithBuilderPart1(BuildingSearchBuilder builder, StringBuilder query) {
        try {
            Field[] fields = BuildingSearchBuilder.class.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                String fieldName = field.getName();
                if (!fieldName.equals("buildingTypes") && !fieldName.startsWith("rentCost")
                        && !fieldName.startsWith("rentArea")) {
                    Object objValue = field.get(builder);
                    if (objValue != null) {
                        if (field.getType().getName().equals("java.lang.String")) {
                            if (fieldName.equals("name")) {
                                query.append(" and b.name like '%" + objValue + "%'");
                            } else {
                                query.append(" and " + fieldName.toLowerCase() + " like '%" + objValue + "%'");
                            }
                        } else if (field.getType().getName().equals("java.lang.Integer")
                                || field.getType().getName().equals("java.lang.Long")) {
                            query.append(" and " + fieldName.toLowerCase() + " = " + objValue + "");
                        }
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void buildWhereClauseWithBuilderPart2(BuildingSearchBuilder builder, StringBuilder query) {
        if (builder.getRentCostFrom() != null) {
            query.append(" and rentcost >= " + builder.getRentCostFrom());
        }
        if (builder.getRentCostTo() != null) {
            query.append(" and rentcost <= " + builder.getRentCostTo());
        }
        Integer rAFrom = builder.getRentAreaFrom();
        Integer rATo = builder.getRentAreaTo();
        if (rAFrom != null || rATo != null) {
            query.append(" and exists (select * from rentarea ra where b.id = ra.buildingid");
            if (rAFrom != null) {
                query.append(" and value >= " + rAFrom);
            }
            if (rATo != null) {
                query.append(" and value <= " + rATo);
            }
            query.append(")");
        }
        //java 8
        if (builder.getBuildingTypes() != null && builder.getBuildingTypes().length > 0) {

            query.append(" and (");
            String sqlType = Arrays.stream(builder.getBuildingTypes()).map(item -> "b.type like '%" + item + "%'")
                    .collect(Collectors.joining(" or "));
            query.append(sqlType);
            query.append(")");
        }
    }

    public void update(BuildingEntity buildingEntity) {
        Connection conn = null;
        PreparedStatement stmt = null;
        StringBuilder sql = createUpdateSql(buildingEntity);
        try {
            conn = SqlUtils.getConnection();
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement(sql.toString());

            Field[] fields = buildingEntity.getClass().getDeclaredFields();
            int index = 1;
            for (Field field : fields) {
                field.setAccessible(true);
                if (isFieldNull_Empty_NotAnnotation(field, buildingEntity)) continue;
                // xem run neu error co the sai cho index++
                stmt.setObject(index++, field.get(buildingEntity));
            }
            // parent
            Class parentClass = BuildingEntity.class.getSuperclass();
            int parentIndex = index;
            while (parentClass != null && parentClass.isAnnotationPresent(Entity.class)) {
                Field[] parentFields = parentClass.getDeclaredFields();
                for (Field field : parentFields) {
                    field.setAccessible(true);
                    if (isFieldNull_Empty_NotAnnotation(field, buildingEntity)) continue;
                    stmt.setObject(parentIndex++, field.get(buildingEntity));
                }
                parentClass = parentClass.getSuperclass();
            }
            stmt.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void removeAssociation(Long buildingId) {
        BuildingEntity buildingEntity = entityManager.find(BuildingEntity.class, buildingId);
        for (UserEntity userEntity : buildingEntity.getUsers()) {
            if (userEntity.getBuildings().size() == 1) {
                entityManager.remove(userEntity);
            } else {
                userEntity.getBuildings().remove(buildingEntity);
            }
        }
    }

    private StringBuilder createUpdateSql(BuildingEntity buildingEntity) {
        String tableName = null;
        if (BuildingEntity.class.isAnnotationPresent(Table.class)) {
            Table table = BuildingEntity.class.getAnnotation(Table.class);
            tableName = table.name();
        }
        StringBuilder fieldsOfInsertQuery = new StringBuilder();
        for (Field field : BuildingEntity.class.getDeclaredFields()) {
            field.setAccessible(true);
            if (isFieldNull_Empty_NotAnnotation(field, buildingEntity)) continue;
            if (fieldsOfInsertQuery.length() > 1) {
                fieldsOfInsertQuery.append(",");
            }
            Column column = field.getAnnotation(Column.class);
            fieldsOfInsertQuery.append(column.name() + " = ?");
        }
        StringBuilder sql = new StringBuilder("UPDATE " + tableName + " SET " + fieldsOfInsertQuery + " where id = " + buildingEntity.getId());

        return sql;
    }


    private boolean isFieldNull_Empty_NotAnnotation(Field field, BuildingEntity buildingEntity) {
        if (!field.isAnnotationPresent(Column.class)) return true;
        try {
            if (field.get(buildingEntity) == null) return true;
            if (field.get(buildingEntity).equals("")) return true;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return false;
    }

}
