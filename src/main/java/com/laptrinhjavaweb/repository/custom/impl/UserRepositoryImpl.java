package com.laptrinhjavaweb.repository.custom.impl;

import com.laptrinhjavaweb.converter.UserConverter;
import com.laptrinhjavaweb.entity.BuildingAssignmentEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.custom.UserRepositoryCustom;
import com.laptrinhjavaweb.utils.SqlUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    //dùng hàm khác rồi(spring data jpa)
    @Override
    public List<UserEntity> findByStatusAndRole(Integer status, String role) {
        UserConverter converter = new UserConverter();
        StringBuilder sql = new StringBuilder("select u.id, u.username, u.password, u.fullname, u.phone, u.email, u.status,")
                .append(" u.createdby, u.createddate, u.modifiedby, u.modifieddate from user u")
                .append(" inner join user_role ur on u.id = ur.userid")
                .append(" inner join role r on r.id = ur.roleid")
                .append(" where r.code = '" + role + "' and u.status = " + status);
        try (Connection conn = SqlUtils.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql.toString());) {

            return converter.convertToEntityFromResultSet(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    //cho nay hoi kythuat sau, tạm thời lỗi nên chưa dùng, dùng spring data jpa
    @Override
    public List<UserEntity> findByBuildingId(Long buildingId) {
        //FROM BuildingAssignmentEntity AS bae WHERE bae.building.id =
        String sql = "FROM UserEntity AS ue WHERE ue.buildingAssignment.building.id = " + buildingId;
        Query query = entityManager.createQuery(sql, UserEntity.class);
        List<UserEntity> ues = query.getResultList();
        return ues;
    }
}
