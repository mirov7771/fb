package ru.foodbooking.foodws.gencheck;

import java.io.IOException;

public interface GenerateAndCheck {

    int generateCode(String phone) throws IOException;
    int checkCode(String phone, String code);

}
