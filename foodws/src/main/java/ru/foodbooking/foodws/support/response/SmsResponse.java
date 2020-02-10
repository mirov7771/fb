package ru.foodbooking.foodws.support.response;

import lombok.Getter;

@Getter
public class SmsResponse {

    private Integer erroCode;

    public SmsResponse(Integer erroCode){
        this.erroCode = erroCode;
    }

}
