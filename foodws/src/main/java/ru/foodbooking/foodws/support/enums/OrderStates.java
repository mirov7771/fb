package ru.foodbooking.foodws.support.enums;

public enum OrderStates {

    DRAFT("draft"),
    CONFIRMED("confirmed"),
    FINISHED("finished"),
    CANCELED("canceled");

    private String stateName;

    OrderStates(String stateName){
        this.stateName = stateName;
    }

    public String getStateName(){
        return this.stateName;
    }

}
