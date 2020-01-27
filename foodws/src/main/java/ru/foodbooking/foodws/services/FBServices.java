package ru.foodbooking.foodws.services;

import ru.foodbooking.foodws.FBException;

public interface FBServices {

    String execute(String request) throws FBException;

}
