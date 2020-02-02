package ru.foodbooking.foodws.services;

import ru.foodbooking.foodws.FBException;
import ru.foodbooking.foodws.support.request.GetRequest;
import ru.foodbooking.foodws.support.response.FBServicesRes;

import java.util.List;

public interface FBServices {

    List<FBServicesRes> execute(GetRequest request) throws FBException;

}
