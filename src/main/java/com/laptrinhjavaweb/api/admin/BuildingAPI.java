package com.laptrinhjavaweb.api.admin;


import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.request.AssignStaffsOfBuildingRequest;
import com.laptrinhjavaweb.dto.request.DeleteRequest;
import com.laptrinhjavaweb.dto.response.BuildingSearchRespone;
import com.laptrinhjavaweb.dto.response.ResponseDTO;
import com.laptrinhjavaweb.service.IBuildingService;
import com.laptrinhjavaweb.service.IUserService;
import com.laptrinhjavaweb.service.impl.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value="buildingAPIOfAdmin")
@RequestMapping(value = "/api/building")
public class BuildingAPI {

    @Autowired
    private IBuildingService buildingService;
    @Autowired
    private IUserService userService;

    @PostMapping()
    public BuildingDTO createOrUpdateBuilding(@RequestBody BuildingDTO newBuilding) {
        return buildingService.save(newBuilding);
    }

    @DeleteMapping()
    public List<BuildingSearchRespone> deleteBuilding(@RequestBody DeleteRequest request) {
        buildingService.deleteBuildingAndReferences(request);

        return buildingService.findAll();
    }

    @GetMapping("/staffs")
    public ResponseDTO loadStaff(@RequestParam(value = "buildingId") Long id){
        return userService.getAllStaffAndChecked(id, SystemConstant.BUILDING);
    }

    @PutMapping("/assignment")
    public void assignStaffsForBuilding(@RequestBody AssignStaffsOfBuildingRequest buildingRequest){
        buildingService.assignStaffsForBuilding(buildingRequest);
    }
}