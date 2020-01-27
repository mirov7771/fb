package ru.foodbooking.foodws.services;

import org.springframework.stereotype.Component;
import ru.foodbooking.foodws.FBException;

@Component("categories")
public class CategoriesService implements FBServices{

    @Override
    public String execute(String request) throws FBException {
        return null;
    }
}
