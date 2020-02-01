package ru.foodbooking.foodws.services;

import ru.foodbooking.foodws.FBException;
import ru.foodbooking.foodws.support.request.FBServicesReq;
import ru.foodbooking.foodws.support.response.FBServicesRes;

import java.util.List;

public interface FBServices {

    List<FBServicesRes> execute(FBServicesReq request) throws FBException;

}
