package ru.foodbooking.foodws.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class OrderDelete {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public OrderDelete(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public int delete(Long orderId){
        String delOrder = "DELETE FROM FB_ORDER WHERE ORDERID = ?";
        String delOrderAttr = "DELETE FROM FB_ORDERSATTRIBUTE WHERE ORDERID = ?";
        try {
            jdbcTemplate.update(delOrder, orderId);
            jdbcTemplate.update(delOrderAttr, orderId);
            return 0;
        } catch (DataAccessException e){
            e.printStackTrace();
            return 1;
        }
    }

}
