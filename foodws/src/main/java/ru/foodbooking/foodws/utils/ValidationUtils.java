package ru.foodbooking.foodws.utils;

import ru.foodbooking.foodws.FBConstant;
import ru.foodbooking.foodws.FBException;
import ru.foodbooking.foodws.support.request.GetRequest;

public class ValidationUtils {

    public static void validateRequest(GetRequest req) throws FBException{
        if (req == null)
            throw new FBException(FBConstant.CODE_BUSINESS_ERROR, FBConstant.MESSAGE_BUSINESS_ERROR);
    }

}
