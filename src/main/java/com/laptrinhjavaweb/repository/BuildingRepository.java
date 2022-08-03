package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.repository.custom.BuildingRepositoryCustom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuildingRepository extends JpaRepository<BuildingEntity, Long>, BuildingRepositoryCustom {
    void deleteById_In(Long[] buildingIds);
    //for test postman
    @Query(value = "SELECT b FROM BuildingEntity b")
    List<BuildingEntity> findAllBuildings(Sort sort);
    @Query(value = "SELECT b FROM BuildingEntity b WHERE b.rentCost = ?1 and b.floorArea = ?2")
    List<BuildingEntity> findByRentCost(Integer rentCost, Integer floorArea);


    @Query(value = "SELECT b FROM BuildingEntity b INNER JOIN b.users u WHERE u.id =?1")
    List<BuildingEntity> findByUsersId(Long id);
    //use method below instead above
    Page<BuildingEntity> findByUsers_Id(Long id, Pageable pageable);
    int countByUsers_Id(Long id);

}
