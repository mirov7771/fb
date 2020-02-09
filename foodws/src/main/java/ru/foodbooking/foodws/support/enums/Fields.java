package ru.foodbooking.foodws.support.enums;

public enum  Fields {

    PROPERTY_STATUS("status"),
    PROPERTY_ORDER_ID("orderId");

    private String fieldName;

    Fields(String fieldName){
        this.fieldName = fieldName;
    }

    public String getFieldName(){
        return this.fieldName;
    }
}
