package ru.foodbooking.foodws.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.foodbooking.foodws.dao.model.Points;

import java.util.List;

@Repository
public interface PointsRepository extends CrudRepository<Points, String> {

    List<Points> findByPointName(String pointName);
    List<Points> findByPointAddress(String pointAddress);
    Points findByPointId(Long pointId);
}
