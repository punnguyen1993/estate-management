package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.service.iBuildingAssignmentService;
import org.springframework.stereotype.Service;

@Service
public class BuildingAssignmentService implements iBuildingAssignmentService {

//    @Autowired
//    private BuildingAssginmentRepository buildingAssignmentRepository;
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Override
//    @Transactional
//    public void assignStaffsForCustomer(Long buildingId, Long[] staffIds) {

//        buildingAssignmentRepository.deleteByBuildingId(buildingId);
//        buildingAssignmentRepository.deleteByBuildingIdAndUserId_NotIn(buildingId, staffIds);
//        if(staffIds.length > 0){
//            buildingAssignmentRepository.saveAll(getBuildingAssignmentEntities(buildingId, staffIds));
//        }


//        List<BuildingAssignmentEntity> buildingAssigmentEntities = buildingAssignmentRepository.findByBuilding_Id(buildingId);
//        List<Long> staffIds = Arrays.asList(staffIds);
//        if (buildingAssigmentEntities != null) {
//            for (BuildingAssignmentEntity item : buildingAssigmentEntities) {
//                if (!staffIds.contains(item.getUser().getId())) {
//                    buildingAssignmentRepository.deleteById(item.getId());
//                }
//            }
//            List<Long> userIds = getUserIdList(buildingAssigmentEntities);
//            for (Long id : staffIds) {
//                if (!userIds.contains(id)) {
//                    BuildingAssignmentEntity newAssignment = new BuildingAssignmentEntity();
//
//                    BuildingEntity building = entityManager.getReference(BuildingEntity.class, buildingId);
//                    UserEntity user = entityManager.getReference(UserEntity.class, id);
//
//                    newAssignment.setUser(user);
//                    newAssignment.setBuilding(building);
//
//                    buildingAssignmentRepository.save(newAssignment);
//                }
//            }
//        }
//    }

//    private List<BuildingAssignmentEntity> getBuildingAssignmentEntities(Long buildingId, Long[] staffIds) {
//        List<BuildingAssignmentEntity> result = new ArrayList<>();
//        BuildingEntity buildingEntity = entityManager.getReference(BuildingEntity.class, buildingId);
//        for(Long item: staffIds){
//            BuildingAssignmentEntity buildingAssignmentEntity = new BuildingAssignmentEntity();
//            buildingAssignmentEntity.setBuilding(buildingEntity);
//            buildingAssignmentEntity.setUser(entityManager.getReference(UserEntity.class, item));
//            result.add(buildingAssignmentEntity);
//        }
//        return result;
//    }
//
//    private List<Long> getUserIdList(List<BuildingAssignmentEntity> buildingAssigmentEntities) {
//        List<Long> items = new ArrayList<>();
//        for (BuildingAssignmentEntity item : buildingAssigmentEntities) {
//            items.add(item.getUser().getId());
//        }
//        return items;
//    }
}
