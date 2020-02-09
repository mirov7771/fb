package ru.foodbooking.foodws.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.foodbooking.foodws.dao.model.Codes;

@Repository
public interface CodesRepository extends CrudRepository<Codes, String> {

    Codes findByClientPhone(String clientPhone);

}
