package ru.foodbooking.foodws.gencheck;

public interface GenerateAndCheck {

    void generateCode(String phone);
    int checkCode(String phone, String code);

}
