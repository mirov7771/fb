package ru.foodbooking.foodws.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.foodbooking.foodws.dao.OrdersAttributeRepository;
import ru.foodbooking.foodws.dao.OrdersRepository;
import ru.foodbooking.foodws.dao.UsersRepository;
import ru.foodbooking.foodws.dao.model.Orders;
import ru.foodbooking.foodws.dao.model.OrdersAttribute;
import ru.foodbooking.foodws.dao.model.Users;

import java.util.List;

@Component
public class OrderInsert {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private OrdersAttributeRepository ordersAttributeRepository;

    @Autowired
    private UsersRepository usersRepository;

    public int insert(Orders order, List<OrdersAttribute> attrs, String deviceId)
    {
        int retVal = 1;
        if (order != null && (attrs != null && attrs.size() > 0)){

            String phone = order.getClientPhone();
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
                Orders newOrder = ordersRepository.save(order);
                if (newOrder != null) {
                    for (OrdersAttribute attr : attrs) {
                        attr.setOrderId(newOrder.getOrderId());
                        ordersAttributeRepository.save(attr);
                    }
                    retVal = 0;
                }
            }
        }
        return retVal;
    }

}
