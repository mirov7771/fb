package ru.foodbooking.foodws.support.response;

import lombok.Getter;

@Getter
public class SmsResponse {

    private String error;

    public SmsResponse(String error){
        this.error = error;
    }

}
