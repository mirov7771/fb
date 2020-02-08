package ru.foodbooking.foodws.services.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import ru.foodbooking.foodws.FBException;
import ru.foodbooking.foodws.dao.impl.OrderInsert;
import ru.foodbooking.foodws.dao.model.Orders;
import ru.foodbooking.foodws.dao.model.OrdersAttribute;
import ru.foodbooking.foodws.support.request.PostRequest;
import ru.foodbooking.foodws.support.response.PostResponse;

import java.util.ArrayList;
import java.util.List;

@Component("draft")
public class AddToDraftSevices implements PostServices {

    @Autowired
    private OrderInsert orderInsert;

    @Override
    public PostResponse execute(PostRequest request) throws FBException {
        Orders order = new Orders();
        order.setTotalCost(request.getTotalCost());
        order.setPointId(request.getPointId());
        order.setOrderState("");
        order.setOrderDate(request.getDate());
        order.setClientPhone(request.getClientPhone());
        order.setClientName(request.getClientName());

        List<OrdersAttribute> attrs = new ArrayList<>();
        List<PostRequest.TAttr> reqAttrs = request.getAttrs();
        if (!CollectionUtils.isEmpty(reqAttrs)){
            reqAttrs.forEach(item -> {
                OrdersAttribute attr = new OrdersAttribute();
                attr.setCnt(item.getCnt());
                attr.setPrCost(item.getPrCost());
                attr.setProductId(item.getProductId());
                attr.setProductName(item.getProductName());
                attrs.add(attr);
            });
        }

        int status = orderInsert.insert(order, attrs, request.getDeviceId());
        PostResponse response = new PostResponse();
        response.setStatus(status);
        return response;
    }
}
