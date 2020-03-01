package ru.foodbooking.foodws.support.builder;

import org.springframework.stereotype.Component;
import ru.foodbooking.foodws.dao.model.OrdersAttribute;

import java.util.List;

@Component
public class OrderMessageBuilder {

    public String prepareMessage(List<OrdersAttribute> attrsList, String text){
        StringBuilder sb = new StringBuilder(text).append("\r\n");
        int i = 0;
        for(OrdersAttribute attr : attrsList){
            sb.append(i++).append(".").append(attr.getProductName())
                    .append(" Стоимость: ").append(attr.getPrCost())
                    .append(" Количество:").append(attr.getCnt())
                    .append("\r\n");
        }
        return sb.toString();
    }

}
