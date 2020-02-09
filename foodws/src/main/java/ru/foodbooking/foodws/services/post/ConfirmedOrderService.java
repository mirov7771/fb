package ru.foodbooking.foodws.services.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.foodbooking.foodws.FBException;
import ru.foodbooking.foodws.dao.impl.OrderInsert;
import ru.foodbooking.foodws.support.enums.Fields;
import ru.foodbooking.foodws.support.request.PostRequest;
import ru.foodbooking.foodws.support.response.PostResponse;
import ru.foodbooking.foodws.utils.ValidationUtils;

import java.util.Map;

@Component("confirmed")
public class ConfirmedOrderService implements PostServices {

    @Autowired
    private OrderInsert orderInsert;

    @Override
    public PostResponse execute(PostRequest request) throws FBException {
        ValidationUtils.validateRequest(request);
        Map<String, Object> db = orderInsert.insert(null, null, request.getDeviceId(), request.getOrderId());
        PostResponse response = new PostResponse();
        response.setStatus((Integer) db.get(Fields.PROPERTY_STATUS.getFieldName()));
        return response;
    }
}
