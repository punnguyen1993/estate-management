package com.laptrinhjavaweb.api.admin;


import com.laptrinhjavaweb.service.iBuildingAssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "buildingAssignmentAPIOfAdmin")
@RequestMapping(value = "/api-user-assignment")
public class BuildingAssignmentAPI {
    @Autowired
    private iBuildingAssignmentService iBuildingAssignmentService;

//    @PostMapping
//    public void assignStaffsForCustomer(@RequestBody BuildingAssignmentDTO buildingAssignmentDTO){
//        iBuildingAssignmentService.assignStaffsForCustomer(buildingAssignmentDTO.getBuildingId(), buildingAssignmentDTO.getStaffIds());
//    }
}
