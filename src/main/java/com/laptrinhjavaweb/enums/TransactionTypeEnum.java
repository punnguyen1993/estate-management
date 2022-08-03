package com.laptrinhjavaweb.enums;

public enum TransactionTypeEnum {
    QUA_TRINH_CSKH("Quá trình CSKH"),
    DAN_DI_XEM("Dẫn đi xem"),
    DANH_GIA_CUA_KH("Đánh giá của khách hàng");
    private final String typeValue;

    TransactionTypeEnum(String typeValue){
        this.typeValue = typeValue;
    }
    public String getTypeValue(){
        return typeValue;
    }
}
