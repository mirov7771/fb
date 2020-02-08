package ru.foodbooking.foodws.services.post;

import org.springframework.stereotype.Component;
import ru.foodbooking.foodws.FBException;
import ru.foodbooking.foodws.support.response.PostResponse;

@Component("draft")
public class AddToDraftSevices implements PostServices {

    @Override
    public PostResponse execute() throws FBException {
        return null;
    }
}
