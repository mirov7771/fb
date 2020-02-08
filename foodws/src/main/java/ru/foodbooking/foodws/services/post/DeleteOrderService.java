package ru.foodbooking.foodws.services.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.foodbooking.foodws.dao.impl.OrderDelete;
import ru.foodbooking.foodws.support.request.PostRequest;
import ru.foodbooking.foodws.support.response.PostResponse;

@Component("delorder")
public class DeleteOrderService implements PostServices {

    @Autowired
    private OrderDelete orderDelete;

    @Override
    public PostResponse execute(PostRequest request){
        Long orderId = request.getOrderId();
        PostResponse res = new PostResponse();
        res.setStatus(orderDelete.delete(orderId));
        return res;
    }

}
