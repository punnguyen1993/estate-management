package com.laptrinhjavaweb.repository.custom.impl;

import com.laptrinhjavaweb.builder.CustomerSearchBuilder;
import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.entity.CustomerEntity;
import com.laptrinhjavaweb.repository.custom.CustomerRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<CustomerEntity> findByDetail(CustomerSearchBuilder builder, int firstResult, int maxResult) {
        StringBuilder sql = new StringBuilder("SELECT * ")
                            .append(buildFromOfSearchingQuery(builder));

        Query query = entityManager.createNativeQuery(sql.toString(), CustomerEntity.class);
        query.setFirstResult(firstResult);
        query.setMaxResults(maxResult);

        return query.getResultList();
    }

    @Override
    public int countTotalDetailItems(CustomerSearchBuilder builder) {
        StringBuilder sql = new StringBuilder("SELECT COUNT(x.id) FROM (SELECT c.id ")
                .append(buildFromOfSearchingQuery(builder))
                .append(") as x");
        Query queryTotal = entityManager.createNativeQuery(sql.toString());
        int countResult = ((BigInteger)queryTotal.getSingleResult()).intValue();

        return countResult;
    }

    private StringBuilder buildFromOfSearchingQuery(CustomerSearchBuilder builder) {
        StringBuilder sql = new StringBuilder("from customer c");

        buildJoinQueryWithBuilder(builder, sql);
        sql.append(SystemConstant.WHERE_ONE_EQUAL_ONE);
        buildWhereClause(builder, sql);
        sql.append(" group by c.id");

        return sql;
    }

    private void buildWhereClause(CustomerSearchBuilder builder, StringBuilder query) {
        try {
            Field[] fields = CustomerSearchBuilder.class.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                String fieldName = field.getName();
                Object objValue = field.get(builder);
                if (objValue != null) {
                    if (field.getType().getName().equals("java.lang.String")) {
                        if (fieldName.equals("fullName")) {
                            query.append(" and c.fullname like '%" + objValue + "%'");
                        }else if(fieldName.equals("phone")){
                            query.append(" and c.phone like '%" + objValue + "%'");
                        }
                        else if(fieldName.equals("email")){
                            query.append(" and c.email like '%" + objValue + "%'");
                        }
                        else {
                            query.append(" and " + fieldName.toLowerCase() + " like '%" + objValue + "%'");
                        }
                    } else if (field.getType().getName().equals("java.lang.Integer")
                            || field.getType().getName().equals("java.lang.Long")) {
                        query.append(" and " + fieldName.toLowerCase() + " = " + objValue + "");
                    }
                }
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void buildJoinQueryWithBuilder(CustomerSearchBuilder builder, StringBuilder sql) {
        if (builder.getStaffId() != null) {
            sql.append(" inner join assignmentcustomer asmc on c.id = asmc.customerid")
                    .append(" inner join user u on asmc.staffid = u.id");
        }
    }
}
