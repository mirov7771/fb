package ru.foodbooking.foodws.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.foodbooking.foodws.dao.OrdersAttributeRepository;
import ru.foodbooking.foodws.dao.OrdersRepository;
import ru.foodbooking.foodws.dao.UsersRepository;
import ru.foodbooking.foodws.dao.model.Orders;
import ru.foodbooking.foodws.dao.model.OrdersAttribute;
import ru.foodbooking.foodws.dao.model.Users;
import ru.foodbooking.foodws.gencheck.Sms;
import ru.foodbooking.foodws.support.enums.Fields;
import ru.foodbooking.foodws.support.enums.OrderStates;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class OrderInsert {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private OrdersAttributeRepository ordersAttributeRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private Sms sms;

    public Map<String, Object> insert(Orders order, List<OrdersAttribute> attrs, String deviceId, Long orderId, String code) {
        Map<String,Object> res = new HashMap<>();
        res.put(Fields.PROPERTY_STATUS.getFieldName(),1);
        if ((order != null && (attrs != null && attrs.size() > 0)) || orderId != null){
            if (orderId != null){
                res.put(Fields.PROPERTY_STATUS.getFieldName(), confirmed(orderId, deviceId, code));
            } else {
                res.put(Fields.PROPERTY_ORDER_ID.getFieldName(), draft(order, attrs));
                res.put(Fields.PROPERTY_STATUS.getFieldName(), 0);
            }
        }
        return res;
    }

    private Long draft(Orders order, List<OrdersAttribute> attrs){
        Orders newOrder = ordersRepository.save(order);
        Long orderId = null;
        if (newOrder != null) {
            orderId = newOrder.getOrderId();
            for (OrdersAttribute attr : attrs) {
                attr.setOrderId(orderId);
                ordersAttributeRepository.save(attr);
            }
            sms.generateCode(order.getClientPhone());
        }
        return orderId;
    }

    private int confirmed(Long orderId, String deviceId, String code){
        int retVal = 1;
        Orders order = ordersRepository.findByOrderId(orderId);
        String phone = order.getClientPhone();
        int validCode = sms.checkCode(phone, code);
        if (validCode > 0)
            return 2;
        Users user = usersRepository.findByUserPhoneAndDeviceId(phone, deviceId);
        Long userId;
        if (user == null){
            Users newUser = new Users();
            newUser.setDeviceId(deviceId);
            newUser.setUserName(order.getClientName());
            newUser.setUserPhone(phone);
            Users createdUser = usersRepository.save(newUser);
            userId = createdUser.getUserId();
        } else {
            userId = user.getUserId();
        }

        if (userId != null) {
            order.setUserId(userId);
            order.setOrderState(OrderStates.CONFIRMED.getStateName());
            ordersRepository.save(order);
            retVal = 0;
        }
        return retVal;
    }

}
