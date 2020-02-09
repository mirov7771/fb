package ru.foodbooking.foodws.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.foodbooking.foodws.dao.model.Orders;

import java.util.List;

@Repository
public interface OrdersRepository extends CrudRepository<Orders, String> {

    Orders findByOrderId(Long orderId);
    List<Orders> findByClientPhone(String clientPhone);

}
