package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.request.BuildingSearchRequest;
import com.laptrinhjavaweb.dto.response.BuildingSearchRespone;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.RentAreaEntity;
import com.laptrinhjavaweb.enums.DistrictsEnum;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BuildingConverter {

    @Autowired
    private ModelMapper modelMapper;

    public BuildingSearchBuilder convertDTOToBuilder(BuildingSearchRequest buildingDTO) {
        BuildingSearchBuilder builder = new BuildingSearchBuilder.Builder()
                            .setName(buildingDTO.getName())
                            .setRentAreaFrom(buildingDTO.getRentAreaFrom())
                            .setManagerName(buildingDTO.getManagerName())
                            .setManagerPhone(buildingDTO.getManagerPhone())
                            .setWard(buildingDTO.getWard())
                            .setLevel(buildingDTO.getLevel())
                            .setNumberOfBasement(buildingDTO.getNumberOfBasement())
                            .setStreet(buildingDTO.getStreet())
                            .setBuildingTypes(buildingDTO.getBuildingTypes())
                            .setDistrict(buildingDTO.getDistrict())
                            .setFloorArea(buildingDTO.getFloorArea())
                            .setRentAreaTo(buildingDTO.getRentAreaTo())
                            .setRentCostFrom(buildingDTO.getRentCostFrom())
                            .setRentCostTo(buildingDTO.getRentCostTo())
                            .setStaffId(buildingDTO.getStaffId())
                            .build();

        return builder;
    }

    public BuildingDTO convertToDto(BuildingEntity entity) {
        BuildingDTO result = modelMapper.map(entity, BuildingDTO.class);
        if (entity.getType() != null) {
            String[] buildingTypes = entity.getType().split(",");
            result.setBuildingTypes(buildingTypes);
        }
        return result;
    }


    public BuildingEntity convertToEntity(BuildingDTO buildingDTO) {
        BuildingEntity buildingEntity = modelMapper.map(buildingDTO, BuildingEntity.class);
        String rentAreaValues = buildingDTO.getRentAreas();
        buildingEntity.setRentAreaEntities(getRentAreas(buildingEntity, rentAreaValues));
        String types = String.join(",", buildingDTO.getBuildingTypes());
        buildingEntity.setType(types);
        return buildingEntity;
    }

    private List<RentAreaEntity> getRentAreas(BuildingEntity buildingEntity, String rentAreaValues) {
        if (!rentAreaValues.equals("")) {
            List<String> rentAreaValueList = Arrays.asList(rentAreaValues.split(","));
            List<RentAreaEntity> rentAreas = rentAreaValueList.stream().map((String value) -> {
                RentAreaEntity rentAreaEntity = new RentAreaEntity();
                rentAreaEntity.setValue(Integer.parseInt(value));
                rentAreaEntity.setBuilding(buildingEntity);
                return rentAreaEntity;
            }).collect(Collectors.toList());
            return rentAreas;
        }
        return null;
    }

    public BuildingSearchRespone convertEntityToResponse(BuildingEntity entity) {
        BuildingSearchRespone result = new BuildingSearchRespone();
        result.setId(entity.getId());
        result.setName(entity.getName());
        result.setAddress(buildAddress(entity));
        result.setBrokerageFee(entity.getBrokerageFee());
        result.setFloorArea(entity.getFloorArea());
        result.setManagerName(entity.getManagerName());
        result.setManagerPhone(entity.getManagerPhone());
        result.setRentCost(entity.getRentCost());
        result.setServiceFee(entity.getServiceFee());
        result.setBrokerageFee(entity.getBrokerageFee());
        result.setModifieddate(entity.getModifiedDate());
        return result;
    }

    private String buildAddress(BuildingEntity entity) {
        StringBuilder result = new StringBuilder();
        boolean hasPreviousSubAddress = false;
        if (!entity.getStreet().equals(SystemConstant.EMPTY_STRING)) {
            result.append(entity.getStreet());
            hasPreviousSubAddress = true;
        }
        if (!entity.getWard().equals(SystemConstant.EMPTY_STRING)) {
            if (hasPreviousSubAddress) {
                result.append(", ");
            }
            result.append(entity.getWard());
            hasPreviousSubAddress = true;
        }
        if (!entity.getDistrict().equals(SystemConstant.EMPTY_STRING)) {
            if (hasPreviousSubAddress) {
                result.append(", ");
            }
            result.append(getAddressName(entity));
        }
        return result.toString();
    }

    private String getAddressName(BuildingEntity entity) {
        String districtName = null;
        String districtCode = entity.getDistrict();
        for (DistrictsEnum item : DistrictsEnum.values()) {
            if (item.toString().equals(districtCode)) {
                districtName = item.getDistrictValue();
            }
        }
        return districtName;
    }
}
