package com.laptrinhjavaweb.dto;

public class BuildingDTO extends AbstractDTO{
    private boolean search;

    private String structure;
    private String rentCostDescription;
    private String carFee;
    private String motoFee;
    private String waterFee;
    private String electricityFee;
    private String deposit;
    private String payment;
    private String rentTime;
    private String decorationTime;
    private Double brokerageFee;
    private String note;
    private String overTimeFee;

    private String street, name, ward, managerName, managerPhone, direction, level, serviceFee, district, rentAreas;
    private Integer floorArea, numberOfBasement, rentCost;
    private Long staffId, buildingId;
    private Long[] staffIds, buildingIds;
    private String[] buildingTypes = new String[] {};
    private String type;
    private Integer rentCostFrom;
    private Integer rentCostTo;
    private Integer rentAreaFrom;
    private Integer rentAreaTo;

    public boolean isSearch() {
        return search;
    }

    public void setSearch(boolean search) {
        this.search = search;
    }

    public Long getBuildingId() {
        return buildingId;
    }

    public Long[] getBuildingIds() {
        return buildingIds;
    }

    public void setBuildingIds(Long[] buildingIds) {
        this.buildingIds = buildingIds;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    public String getRentAreas() {
        return rentAreas;
    }

    public void setRentAreas(String rentAreas) {
        this.rentAreas = rentAreas;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public String getRentCostDescription() {
        return rentCostDescription;
    }

    public void setRentCostDescription(String rentCostDescription) {
        this.rentCostDescription = rentCostDescription;
    }

    public String getCarFee() {
        return carFee;
    }

    public void setCarFee(String carFee) {
        this.carFee = carFee;
    }

    public String getMotoFee() {
        return motoFee;
    }

    public void setMotoFee(String motoFee) {
        this.motoFee = motoFee;
    }

    public String getWaterFee() {
        return waterFee;
    }

    public void setWaterFee(String waterFee) {
        this.waterFee = waterFee;
    }

    public String getElectricityFee() {
        return electricityFee;
    }

    public void setElectricityFee(String electricityFee) {
        this.electricityFee = electricityFee;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getRentTime() {
        return rentTime;
    }

    public void setRentTime(String rentTime) {
        this.rentTime = rentTime;
    }

    public String getDecorationTime() {
        return decorationTime;
    }

    public void setDecorationTime(String decorationTime) {
        this.decorationTime = decorationTime;
    }

    public Double getBrokerageFee() {
        return brokerageFee;
    }

    public void setBrokerageFee(Double brokerageFee) {
        this.brokerageFee = brokerageFee;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getOverTimeFee() {
        return overTimeFee;
    }

    public void setOverTimeFee(String overTimeFee) {
        this.overTimeFee = overTimeFee;
    }

    public Long[] getStaffIds() {
        return staffIds;
    }

    public void setStaffIds(Long[] staffIds) {
        this.staffIds = staffIds;
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

    public String[] getBuildingTypes() {
        return buildingTypes;
    }

    public void setBuildingTypes(String[] buildingTypes) {
        this.buildingTypes = buildingTypes;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(String serviceFee) {
        this.serviceFee = serviceFee;
    }

    public Integer getRentCost() {
        return rentCost;
    }

    public void setRentCost(Integer rentCost) {
        this.rentCost = rentCost;
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

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public Integer getNumberOfBasement() {
        return numberOfBasement;
    }

    public void setNumberOfBasement(Integer numberOfBasement) {
        this.numberOfBasement = numberOfBasement;
    }

    public Integer getFloorArea() {
        return floorArea;
    }

    public void setFloorArea(Integer floorArea) {
        this.floorArea = floorArea;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
