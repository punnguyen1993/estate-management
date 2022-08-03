package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.RentAreaEntity;
import com.laptrinhjavaweb.repository.RentAreaRepository;
import com.laptrinhjavaweb.service.IRentAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentAreaService implements IRentAreaService {
    @Autowired
    private RentAreaRepository rentAreaRepository;
    @Autowired
    private EntityManager entityManager;

    @Override
    public String findByBuildingId(Long buildingId) {
        List<RentAreaEntity> rentAreaEntities = rentAreaRepository.findByBuilding_Id(buildingId);
        String values = getRentAreaValues(rentAreaEntities);
        return values;
    }

    @Override
    public void save(String value, Long buildingId) {
        List<Integer> newValues = Arrays.stream(value.split(",")).map(Integer::parseInt).collect(Collectors.toList());
        List<RentAreaEntity> rentAreaEntities = rentAreaRepository.findByBuilding_Id(buildingId);

        if (rentAreaEntities != null) {
            for (RentAreaEntity item : rentAreaEntities) {
                if (!newValues.contains(item.getValue())) {
                    rentAreaRepository.deleteById(item.getId());
                }
            }
            List<Integer> existingValues = getValues(rentAreaEntities);
            for (Integer item : newValues) {
                if (!existingValues.contains(item)) {
                    RentAreaEntity newAssignment = new RentAreaEntity();
                    BuildingEntity building = entityManager.getReference(BuildingEntity.class, buildingId);
                    newAssignment.setValue(item);
                    newAssignment.setBuilding(building);

                    rentAreaRepository.save(newAssignment);
                }
            }
        }
    }

    private String getRentAreaValues(List<RentAreaEntity> rentAreaEntities) {
        List<String> result = new ArrayList<>();
        for (RentAreaEntity item : rentAreaEntities) {
            result.add(item.getValue().toString());
        }
        return String.join(",", result);
    }

    private List<Integer> getValues(List<RentAreaEntity> rentAreaEntities) {
        List<Integer> items = new ArrayList<>();
        for (RentAreaEntity item : rentAreaEntities) {
            items.add(item.getValue());
        }
        return items;
    }
}
