package ru.foodbooking.foodws.services;

import org.springframework.stereotype.Component;
import ru.foodbooking.foodws.FBException;

@Component("points")
public class PointsService implements FBServices {

    @Override
    public String execute(String request) throws FBException {
        return null;
    }
}
