package ru.foodbooking.foodws.services.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import ru.foodbooking.foodws.FBException;
import ru.foodbooking.foodws.dao.impl.OrderInsert;
import ru.foodbooking.foodws.dao.model.Orders;
import ru.foodbooking.foodws.dao.model.OrdersAttribute;
import ru.foodbooking.foodws.support.enums.Fields;
import ru.foodbooking.foodws.support.enums.OrderStates;
import ru.foodbooking.foodws.support.request.PostRequest;
import ru.foodbooking.foodws.support.response.PostResponse;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Component("create")
public class CreateOrderService implements PostServices {

    @Autowired
    private OrderInsert orderInsert;

    @Override
    public PostResponse execute(PostRequest request) throws FBException {

        Orders order = new Orders();
        order.setPointId(request.getPointId());
        order.setOrderState(OrderStates.DRAFT.getStateName());
        order.setOrderDate(new Date());
        order.setClientPhone(request.getClientPhone());
        order.setClientName(request.getClientName());

        List<OrdersAttribute> attrs = new ArrayList<>();
        List<PostRequest.TAttr> reqAttrs = request.getAttrs();
        BigDecimal totalCost = BigDecimal.ZERO;
        if (!CollectionUtils.isEmpty(reqAttrs)){
            for(PostRequest.TAttr item : reqAttrs){
                OrdersAttribute attr = new OrdersAttribute();
                BigDecimal cost = item.getPrCost();
                BigDecimal cnt = item.getCnt();
                BigDecimal prCost = cost.multiply(cnt);
                totalCost = totalCost.add(prCost);
                attr.setCnt(cnt);
                attr.setPrCost(cost);
                attr.setProductId(item.getProductId());
                attr.setProductName(item.getProductName());
                attrs.add(attr);
            };
        }
        order.setTotalCost(totalCost);

        Map<String, Object> db = orderInsert.insert(order, attrs, null, null, null);
        PostResponse response = new PostResponse();
        response.setStatus((Integer) db.get(Fields.PROPERTY_STATUS.getFieldName()));
        response.setOrderId((Long) db.get(Fields.PROPERTY_ORDER_ID.getFieldName()));
        return response;
    }
}
