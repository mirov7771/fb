package ru.foodbooking.foodws.services;

import org.springframework.stereotype.Component;
import ru.foodbooking.foodws.FBException;

@Component("products")
public class ProductsService implements FBServices {

    @Override
    public String execute(String request) throws FBException {
        return null;
    }
}
