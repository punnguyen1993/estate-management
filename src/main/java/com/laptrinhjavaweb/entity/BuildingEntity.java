package com.laptrinhjavaweb.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="building")
public class BuildingEntity extends BaseEntity {

    @OneToMany(mappedBy = "building",
                cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE},
                fetch = FetchType.LAZY)
    private List<RentAreaEntity> rentAreaEntities = new ArrayList<>();

    @ManyToMany(/*cascade = {CascadeType.MERGE, CascadeType.PERSIST},*/
                fetch = FetchType.LAZY)
    @JoinTable(name = "assignmentbuilding",
            joinColumns = @JoinColumn(name = "buildingid", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "staffid", nullable = false))
    private Set<UserEntity> users = new HashSet<>();


    /*public void addUser(UserEntity user) {
        users.add(user);
        user.getBuildings().add(this);
    }

    public void removeUser(UserEntity user) {
        users.remove(user);
        user.getBuildings().remove(this);
    }*/
    @Transient
    private Integer totalItem;

    @Column(name="floorarea")
    private Integer floorArea;

    @Column(name="street")
    private String street;

    @Column(name="district")
    private String district;

    @Column(name="name")
    private String name;

    @Column(name="ward")
    private String ward;

    @Column(name="managername")
    private String managerName;

    @Column(name="managerphone")
    private String managerPhone;

    @Column(name="type")
    private String type;

    @Column(name="direction")
    private String direction;

    @Column(name="level")
    private String level;

    @Column(name="numberofbasement")
    private Integer numberOfBasement;

    @Column(name="rentcost")
    private Integer rentCost;

    @Column(name="servicefee")
    private String serviceFee;

    @Column(name="structure")
    private String structure;

    @Column(name="rentcostdescription")
    private String rentCostDescription;

    @Column(name="carfee")
    private String carFee;

    @Column(name="motofee")
    private String motoFee;

    @Column(name="waterfee")
    private String waterFee;

    @Column(name="electricityfee")
    private String electricityFee;

    @Column(name="deposit")
    private String deposit;

    @Column(name="payment")
    private String payment;

    @Column(name="renttime")
    private String rentTime;

    @Column(name="decorationtime")
    private String decorationTime;

    @Column(name="brokeragefee")
    private Double brokerageFee;

    @Column(name="note")
    private String note;

    @Column(name="overtimefee")
    private String overTimeFee;

    @Column(name="linkofbuilding")
    private String linkOfBuilding;

    @Column(name="map")
    private String map;

    @Column(name="avatar")
    private String avatar;

    public Integer getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(Integer totalItem) {
        this.totalItem = totalItem;
    }

    public Set<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(Set<UserEntity> users) {
        this.users = users;
    }

    public List<RentAreaEntity> getRentAreaEntities() {
        return rentAreaEntities;
    }

    public void setRentAreaEntities(List<RentAreaEntity> rentAreaEntities) {
        this.rentAreaEntities = rentAreaEntities;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
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

    public String getOverTimeFee() {
        return overTimeFee;
    }

    public void setOverTimeFee(String overTimeFee) {
        this.overTimeFee = overTimeFee;
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

    public String getLinkOfBuilding() {
        return linkOfBuilding;
    }

    public void setLinkOfBuilding(String linkOfBuilding) {
        this.linkOfBuilding = linkOfBuilding;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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

    public Integer getRentCost() {
        return rentCost;
    }

    public void setRentCost(Integer rentCost) {
        this.rentCost = rentCost;
    }

    public String getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(String serviceFee) {
        this.serviceFee = serviceFee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfBasement() {
        return numberOfBasement;
    }

    public void setNumberOfBasement(Integer numberOfBasement) {
        this.numberOfBasement = numberOfBasement;
    }
}
