package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.request.AssignStaffsOfBuildingRequest;
import com.laptrinhjavaweb.dto.request.BuildingSearchRequest;
import com.laptrinhjavaweb.dto.request.DeleteRequest;
import com.laptrinhjavaweb.dto.response.BuildingSearchRespone;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.enums.DistrictsEnum;
import com.laptrinhjavaweb.enums.TypesEnum;
import com.laptrinhjavaweb.repository.BuildingRepository;
import com.laptrinhjavaweb.repository.RentAreaRepository;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.security.utils.SecurityUtils;
import com.laptrinhjavaweb.service.IBuildingService;
import com.laptrinhjavaweb.utils.ValidateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
public class BuildingService implements IBuildingService {
    //Field injection is not recommended less
    //Inspection info: Spring Team recommends: "Always use constructor based dependency injection in your beans. Always use assertions for mandatory dependencies"
    @Autowired
    private BuildingConverter buildingConverter;
    @Autowired
    private RentAreaRepository rentAreaRepository;
    @Autowired
    private BuildingRepository buildingRepository;
    @Autowired
    private RentAreaService rentAreaService;
    @Autowired
    private UserRepository userRepository;


    @Override
    @Transactional
    public void assignStaffsForBuilding(AssignStaffsOfBuildingRequest buildingRequest) {
        if (validateStaffAssignmentRequest(buildingRequest)) {
            Optional<BuildingEntity> buildingEntity = buildingRepository.findById(buildingRequest.getBuildingId());
            if (buildingEntity.isPresent()) {
                buildingEntity.get().setUsers(new HashSet<>(userRepository.findAllById(Arrays.asList(buildingRequest.getStaffIds()))));
                buildingRepository.save(buildingEntity.get());
            }
        }
    }

    @Override
    public List<BuildingSearchRespone> findAll(Pageable pageable) {
        List<BuildingSearchRespone> result = new ArrayList<>();
        Page<BuildingEntity> pageableEntities;
        if (userHasRoleStaff()) {
            Long staffId = SecurityUtils.getPrincipal().getId();
            pageableEntities = buildingRepository.findByUsers_Id(staffId, pageable);
        } else {
            pageableEntities = buildingRepository.findAll(pageable);
        }

        List<BuildingEntity> buildingEntities = pageableEntities.getContent();
        BuildingSearchRespone buildingSearchRespone;
        for (BuildingEntity buildingEntity : buildingEntities) {
            buildingSearchRespone = buildingConverter.convertEntityToResponse(buildingEntity);
            result.add(buildingSearchRespone);
        }
        return result;
    }

    @Override
    public int countAll(){
        int totalItems;
        if (userHasRoleStaff()) {
            Long staffId = SecurityUtils.getPrincipal().getId();
            totalItems = buildingRepository.countByUsers_Id(staffId);
        }else{
            totalItems = (int) buildingRepository.count();
        }
        return totalItems;
    }


    @Override
    public List<BuildingSearchRespone> findAll() {
        return null;
    }


    @Override
    @Transactional //commit rollback
    public BuildingDTO save(BuildingDTO buildingDTO) {
        Long buildingId = buildingDTO.getId();
        BuildingEntity buildingEntity = buildingConverter.convertToEntity(buildingDTO);
        if (buildingId != null) {
            rentAreaRepository.deleteByBuildingId(buildingId);
            buildingEntity.setUsers(new HashSet<>(userRepository.findByBuildings(buildingEntity)));
        }
        BuildingDTO savedBuilding = buildingConverter.convertToDto(buildingRepository.save(buildingEntity));

        return buildingDTO.getId() == null ? savedBuilding : buildingDTO;

    }

    @Override
    public List<BuildingSearchRespone> findByDetail(BuildingSearchRequest buildingDTO, Pageable pageable) {
        if (userHasRoleStaff()) {
            buildingDTO.setStaffId(SecurityUtils.getPrincipal().getId());
        }
        List<BuildingSearchRespone> results = new ArrayList<>();
        BuildingSearchBuilder builder = buildingConverter.convertDTOToBuilder(buildingDTO);


        Integer firstResult = (int) pageable.getOffset();
        Integer maxResult = pageable.getPageSize();

        List<BuildingEntity> buildingEntities = buildingRepository.findByDetail(builder, firstResult, maxResult);

        for (BuildingEntity buildingEntity : buildingEntities) {
            BuildingSearchRespone result = buildingConverter.convertEntityToResponse(buildingEntity);
            results.add(result);
        }
        return results;
    }

    @Override
    @Transactional
    public void deleteBuildingAndReferences(DeleteRequest request) {
        if (ValidateUtils.isValid(Arrays.asList(request.getBuildingIds()))) {
            buildingRepository.deleteById_In(request.getBuildingIds());
        }
    }

    @Override
    public BuildingDTO findById(Long buidingId)/* throws BuildingNotFoundException */ {
        BuildingEntity existBuilding = buildingRepository.findById(buidingId).orElse(null);

        if(existBuilding != null){
            BuildingDTO result = buildingConverter.convertToDto(existBuilding);
            result.setRentAreas(rentAreaService.findByBuildingId(buidingId));
            return result;
        }
        return null;
    }

    @Override
    public Map<String, String> getTypes() {
        Map<String, String> types = new HashMap<>();
        for (TypesEnum item : TypesEnum.values()) {
            types.put(item.toString(), item.getTypeValue());
        }
        return types;
    }

    @Override
    public Map<String, String> getDistricts() {
        Map<String, String> districts = new HashMap<>();
        for (DistrictsEnum item : DistrictsEnum.values()) {
            districts.put(item.toString(), item.getDistrictValue());
        }
        return districts;
    }

    private boolean userHasRoleStaff() {
        return SecurityUtils.getAuthorities().contains("ROLE_staff");
    }

    private boolean validateStaffAssignmentRequest(AssignStaffsOfBuildingRequest buildingRequest) {
        return ValidateUtils.isValid(buildingRequest.getBuildingId())
                /*&& ValidateUtils.isValid(Arrays.asList((buildingRequest.getStaffIds())))*/;
    }

    @Override
    public List<BuildingEntity> findAllBuildings() {

        return buildingRepository.findAllBuildings(Sort.by("name"));
    }

    @Override
    public int countAllSearchBuilding(BuildingSearchRequest buildingDTO) {
        return buildingRepository.countTotalDetailItems(buildingConverter.convertDTOToBuilder(buildingDTO));
    }
}
