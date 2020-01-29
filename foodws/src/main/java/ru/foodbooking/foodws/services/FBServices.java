package ru.foodbooking.foodws.services;

import ru.foodbooking.foodws.FBException;
import ru.foodbooking.foodws.support.request.FBServicesReq;
import ru.foodbooking.foodws.support.response.FBServicesRes;

public interface FBServices {

    FBServicesRes execute(FBServicesReq request) throws FBException;

}
