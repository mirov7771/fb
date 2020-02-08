package ru.foodbooking.foodws.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.foodbooking.foodws.FBException;
import ru.foodbooking.foodws.dao.OrdersAttributeRepository;
import ru.foodbooking.foodws.dao.OrdersRepository;
import ru.foodbooking.foodws.dao.model.Orders;
import ru.foodbooking.foodws.dao.model.OrdersAttribute;

import java.util.List;

@Component
public class OrderInsert {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private OrdersAttributeRepository ordersAttributeRepository;

    public int insert(Orders order, List<OrdersAttribute> attrs)
    {
        int retVal = 1;
        if (order != null && (attrs != null && attrs.size() > 0)){
            Orders newOrder = ordersRepository.save(order);
            if (newOrder != null){
                for(OrdersAttribute attr : attrs){
                    attr.setOrderId(newOrder.getOrderId());
                    ordersAttributeRepository.save(attr);
                }
                retVal = 0;
            }
        }
        return retVal;
    }

}
