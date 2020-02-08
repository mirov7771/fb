package ru.foodbooking.foodws.services.get;

import ru.foodbooking.foodws.FBException;
import ru.foodbooking.foodws.support.request.GetRequest;
import ru.foodbooking.foodws.support.response.GetResponse;

import java.util.List;

public interface GetServices {

    List<GetResponse> execute(GetRequest request) throws FBException;

}
