package com.laptrinhjavaweb.enums;

public enum DistrictsEnum {
    QUAN_1("Quận 1"),
    QUAN_3("Quận 3"),
    QUAN_4("Quận 4"),
    QUAN_5("Quận 5"),
    QUAN_6("Quận 6"),
    QUAN_7("Quận 7"),
    QUAN_12("Quận 12"),
    QUAN_BINH_THANH("Quận Bình Thạnh"),
    QUAN_TAN_BINH("Quận Tân Bình");
    private final String districtValue;

    DistrictsEnum(String districtValue){
        this.districtValue = districtValue;
    }
    public String getDistrictValue(){
        return districtValue;
    }
}
