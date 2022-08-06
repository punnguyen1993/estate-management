package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.request.AssignStaffsOfBuildingRequest;
import com.laptrinhjavaweb.dto.request.BuildingSearchRequest;
import com.laptrinhjavaweb.dto.request.DeleteRequest;
import com.laptrinhjavaweb.dto.response.BuildingSearchRespone;
import com.laptrinhjavaweb.entity.BuildingEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface IBuildingService {
    List<BuildingSearchRespone> findAll(Pageable pageable);
    List<BuildingSearchRespone> findAll();
    int countAll();

    BuildingDTO save(BuildingDTO buildingDTO);
    List<BuildingSearchRespone> findByDetail(BuildingSearchRequest buildingDTO, Pageable pageable);
    void deleteBuildingAndReferences(DeleteRequest request);

    BuildingDTO findById(Long buidingId)/* throws BuildingNotFoundException*/;

    Map<String, String> getTypes();
    Map<String, String> getDistricts();

    void assignStaffsForBuilding(AssignStaffsOfBuildingRequest buildingRequest);

    List<BuildingEntity> findAllBuildings();

    int countAllSearchBuilding(BuildingSearchRequest buildingDTO);
}
