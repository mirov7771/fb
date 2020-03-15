package ru.foodbooking.foodws.dao.impl;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Component;
import ru.foodbooking.foodws.FBConstant;
import ru.foodbooking.foodws.dao.OrdersAttributeRepository;
import ru.foodbooking.foodws.dao.OrdersRepository;
import ru.foodbooking.foodws.dao.PointsRepository;
import ru.foodbooking.foodws.dao.UsersRepository;
import ru.foodbooking.foodws.dao.model.Orders;
import ru.foodbooking.foodws.dao.model.OrdersAttribute;
import ru.foodbooking.foodws.dao.model.Points;
import ru.foodbooking.foodws.dao.model.Users;
import ru.foodbooking.foodws.gencheck.Sms;
import ru.foodbooking.foodws.services.notification.NotificationService;
import ru.foodbooking.foodws.support.builder.OrderMessageBuilder;
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
    private OrderDelete orderDelete;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private PointsRepository pointsRepository;

    @Autowired
    private Sms sms;

    @Autowired
    private OrderMessageBuilder orderMessageBuilder;

    public Map<String, Object> insert(Orders order, List<OrdersAttribute> attrs, String deviceId, Long orderId, String code){
        Map<String,Object> res = new HashMap<>();
        res.put(Fields.PROPERTY_STATUS.getFieldName(),1);
        if ((order != null && (attrs != null && attrs.size() > 0)) || orderId != null){
            if (orderId != null){
                res.put(Fields.PROPERTY_STATUS.getFieldName(), confirmed(orderId, deviceId, code));
            } else {
                Long dbOrderId = draft(order, attrs);
                int status = dbOrderId == null ? 1 : 0;
                res.put(Fields.PROPERTY_ORDER_ID.getFieldName(), dbOrderId);
                res.put(Fields.PROPERTY_STATUS.getFieldName(), status);
            }
        }
        return res;
    }

    private Long draft(Orders order, List<OrdersAttribute> attrs){
        int i = sms.generateCode(order.getClientPhone());
        Long orderId = null;
        if (i == 0) {
            Orders newOrder = ordersRepository.save(order);
            if (newOrder != null) {
                orderId = newOrder.getOrderId();
                for (OrdersAttribute attr : attrs) {
                    attr.setOrderId(orderId);
                    ordersAttributeRepository.save(attr);
                }
            }
        }
        return orderId;
    }

    private int confirmed(Long orderId, String deviceId, String code){
        int retVal = 1;
        Orders order = ordersRepository.findByOrderId(orderId);
        String phone = order.getClientPhone();
        int validCode = sms.checkCode(phone, code);
        if (validCode > 0) {
            if (validCode == 2)
                orderDelete.delete(orderId);
            return 2;
        }
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
        Long pointId = order.getPointId();
        List<Points> pointList = pointsRepository.findByPointId(pointId);
        if (!CollectionUtils.isEmpty(pointList)){
            Points point = pointList.get(0);
            String email = point.getEmail();
            String subject = String.format(FBConstant.MERCHANT_MESSAGE_SUBJECT, order.getOrderId());
            String text = String.format(FBConstant.MERCHANT_MESSAGE_TEXT, order.getOrderId(),
                    order.getClientName(),
                    order.getClientPhone(),
                    order.getTotalCost());
            List<OrdersAttribute> attrsList = order.getOrdersAttributeList();
            if (!CollectionUtils.isEmpty(attrsList))
                text = orderMessageBuilder.prepareMessage(attrsList, text);
            try {
                notificationService.sendNotification(email, subject, text);
            } catch (MailException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
        return retVal;
    }

}
