package com.laptrinhjavaweb.builder;

import java.io.Serializable;

public class BuildingSearchBuilder implements Serializable {

    private static final long serialVersionUID = -2824718183437317125L;

    private String name;
    private String managerName;
    private String managerPhone;
    private String district;
    private Integer floorArea;
    private String street;
    private String ward;
    private String level;
    private Integer numberOfBasement;
    private String[] buildingTypes;
    private Integer rentCostFrom;
    private Integer rentCostTo;
    private Integer rentAreaFrom;
    private Integer rentAreaTo;
    private Long staffId;

    public String getLevel() {
        return level;
    }
    public String getManagerName() {
        return managerName;
    }
    public String getManagerPhone() {
        return managerPhone;
    }
    public String getName() {
        return name;
    }
    public String getDistrict() {
        return district;
    }
    public Integer getFloorArea() {
        return floorArea;
    }
    public String getStreet() {
        return street;
    }
    public String getWard() {
        return ward;
    }
    public Integer getNumberOfBasement() {
        return numberOfBasement;
    }
    public String[] getBuildingTypes() {
        return buildingTypes;
    }
    public Integer getRentCostFrom() {
        return rentCostFrom;
    }
    public Integer getRentCostTo() {
        return rentCostTo;
    }
    public Integer getRentAreaFrom() {
        return rentAreaFrom;
    }
    public Integer getRentAreaTo() {
        return rentAreaTo;
    }
    public Long getStaffId() {
        return staffId;
    }


    private BuildingSearchBuilder(Builder builder) {

        this.managerName = builder.managerName;
        this.managerPhone = builder.managerPhone;
        this.name = builder.name;
        this.level = builder.level;
        this.district = builder.district;
        this.floorArea = builder.floorArea;
        this.street = builder.street;
        this.ward = builder.ward;
        this.numberOfBasement = builder.numberOfBasement;
        this.buildingTypes = builder.buildingTypes;
        this.rentCostFrom = builder.rentCostFrom;
        this.rentCostTo = builder.rentCostTo;
        this.rentAreaFrom = builder.rentAreaFrom;
        this.rentAreaTo = builder.rentAreaTo;
        this.staffId = builder.staffId;
    }

    public static class Builder{

        private String managerName;
        private String managerPhone;
        private String name;
        private String level;
        private String district;
        private Integer floorArea;
        private String street;
        private String ward;
        private Integer numberOfBasement;
        private String[] buildingTypes = new String[] {};
        private Integer rentCostFrom;
        private Integer rentCostTo;
        private Integer rentAreaFrom;
        private Integer rentAreaTo;
        private Long staffId;

        public Builder setManagerName(String managerName) {
            this.managerName = managerName;
            return this;
        }

        public Builder setLevel(String level) {
            this.level = level;
            return this;
        }

        public Builder setManagerPhone(String managerPhone) {
            this.managerPhone = managerPhone;
            return this;
        }
        public Builder setName(String name) {
            this.name = name;
            return this;
        }
        public Builder setDistrict(String district) {
            this.district = district;
            return this;
        }
        public Builder setFloorArea(Integer floorArea) {
            this.floorArea = floorArea;
            return this;
        }
        public Builder setStreet(String street) {
            this.street = street;
            return this;
        }
        public Builder setWard(String ward) {
            this.ward = ward;
            return this;
        }
        public Builder setNumberOfBasement(Integer numberOfBasement) {
            this.numberOfBasement = numberOfBasement;
            return this;
        }
        public Builder setBuildingTypes(String[] buildingTypes) {
            this.buildingTypes = buildingTypes;
            return this;
        }
        public Builder setRentCostFrom(Integer rentCostFrom) {
            this.rentCostFrom = rentCostFrom;
            return this;
        }
        public Builder setRentCostTo(Integer rentCostTo) {
            this.rentCostTo = rentCostTo;
            return this;
        }
        public Builder setRentAreaFrom(Integer rentAreaFrom) {
            this.rentAreaFrom = rentAreaFrom;
            return this;
        }
        public Builder setRentAreaTo(Integer rentAreaTo) {
            this.rentAreaTo = rentAreaTo;
            return this;
        }
        public Builder setStaffId(Long staffId) {
            this.staffId = staffId;
            return this;
        }
        // build method in the end of class builder
        public BuildingSearchBuilder build() {
            return new BuildingSearchBuilder(this);
        }
    }
}
