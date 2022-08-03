package com.laptrinhjavaweb.repository.custom;

import com.laptrinhjavaweb.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepositoryCustom {
    @Deprecated
    List<UserEntity> findByStatusAndRole(Integer status, String role);

    @Deprecated
    List<UserEntity> findByBuildingId(Long id);

}
