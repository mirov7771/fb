package ru.foodbooking.foodws.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.foodbooking.foodws.dao.model.Users;

@Repository
public interface UsersRepository extends CrudRepository<Users, String> {

    Users findByUserPhoneAndDeviceId(String userPhone, String deviceId);

}
