package com.laptrinhjavaweb.dto.request;

import com.laptrinhjavaweb.dto.AbstractDTO;


public class BuildingSearchRequest extends AbstractDTO{

    private static final long serialVersionUID = 1231210632650578350L;

    private boolean search;
    private String name;
    private String managerName;
    private String managerPhone;
    private String district;
    private Integer floorArea;
    private String street;
    private String ward;
    private String direction;
    private String level;
    private Integer numberOfBasement;
    private String[] buildingTypes;
    private Integer rentCostFrom;
    private Integer rentCostTo;
    private Integer rentAreaFrom;
    private Integer rentAreaTo;
    private Long staffId;


    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public boolean isSearch() {
        return search;
    }

    public void setSearch(boolean search) {
        this.search = search;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerPhone() {
        return managerPhone;
    }

    public void setManagerPhone(String managerPhone) {
        this.managerPhone = managerPhone;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Integer getFloorArea() {
        return floorArea;
    }

    public void setFloorArea(Integer floorArea) {
        this.floorArea = floorArea;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer getNumberOfBasement() {
        return numberOfBasement;
    }

    public void setNumberOfBasement(Integer numberOfBasement) {
        this.numberOfBasement = numberOfBasement;
    }

    public String[] getBuildingTypes() {
        return buildingTypes;
    }

    public void setBuildingTypes(String[] buildingTypes) {
        this.buildingTypes = buildingTypes;
    }

    public Integer getRentCostFrom() {
        return rentCostFrom;
    }

    public void setRentCostFrom(Integer rentCostFrom) {
        this.rentCostFrom = rentCostFrom;
    }

    public Integer getRentCostTo() {
        return rentCostTo;
    }

    public void setRentCostTo(Integer rentCostTo) {
        this.rentCostTo = rentCostTo;
    }

    public Integer getRentAreaFrom() {
        return rentAreaFrom;
    }

    public void setRentAreaFrom(Integer rentAreaFrom) {
        this.rentAreaFrom = rentAreaFrom;
    }

    public Integer getRentAreaTo() {
        return rentAreaTo;
    }

    public void setRentAreaTo(Integer rentAreaTo) {
        this.rentAreaTo = rentAreaTo;
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }
}
