package com.laptrinhjavaweb.repository.custom;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.entity.BuildingEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuildingRepositoryCustom {
    List<BuildingEntity> findByDetail(BuildingSearchBuilder builder, Integer firstResult, Integer maxResult);
    void update(BuildingEntity buildingEntity);
    int countTotalDetailItems(BuildingSearchBuilder builder);
    void removeAssociation(Long buildingId);
}
