package ru.foodbooking.foodws.services;

import org.springframework.stereotype.Component;
import ru.foodbooking.foodws.FBException;
import ru.foodbooking.foodws.support.request.FBServicesReq;
import ru.foodbooking.foodws.support.response.FBServicesRes;

@Component("products")
public class ProductsService implements FBServices {

    @Override
    public FBServicesRes execute(FBServicesReq request) throws FBException {
        return null;
    }
}
