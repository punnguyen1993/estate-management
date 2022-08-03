package com.laptrinhjavaweb.enums;

public enum TypesEnum {
    TANG_TRET("Tầng trệt"),
    NGUYEN_CAN("Nguyên căn"),
    NOI_THAT("Nội thất");
    private final String typeValue;

    TypesEnum(String typeValue){
        this.typeValue = typeValue;
    }
    public String getTypeValue(){
        return typeValue;
    }

}
