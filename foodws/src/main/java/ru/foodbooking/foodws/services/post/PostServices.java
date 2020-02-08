package ru.foodbooking.foodws.services.post;

import ru.foodbooking.foodws.FBException;
import ru.foodbooking.foodws.support.response.PostResponse;

public interface PostServices {

    PostResponse execute() throws FBException;

}
