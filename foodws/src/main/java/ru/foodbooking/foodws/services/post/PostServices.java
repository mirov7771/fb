package ru.foodbooking.foodws.services.post;

import ru.foodbooking.foodws.FBException;
import ru.foodbooking.foodws.support.request.PostRequest;
import ru.foodbooking.foodws.support.response.PostResponse;

public interface PostServices {

    PostResponse execute(PostRequest request) throws FBException;

}
