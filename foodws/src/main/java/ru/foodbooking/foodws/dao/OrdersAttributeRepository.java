package ru.foodbooking.foodws.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.foodbooking.foodws.dao.model.OrdersAttribute;

import java.util.List;

@Repository
public interface OrdersAttributeRepository extends CrudRepository<OrdersAttribute, String> {

    List<OrdersAttribute> findByOrderId(long orderId);

}
