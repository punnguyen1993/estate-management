package com.laptrinhjavaweb.repository;

//import com.laptrinhjavaweb.entity.BuildingAssignmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BuildingAssginmentRepository{
    void deleteByBuildingId(Long buildingId);
    void deleteByBuildingId_In(Long[] buildingIds);

    void deleteByBuildingIdAndUserId_NotIn(Long buildingId, Long[] staffIds);

}
