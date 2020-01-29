package ru.foodbooking.foodws.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import ru.foodbooking.foodws.FBException;
import ru.foodbooking.foodws.dao.PointsRepository;
import ru.foodbooking.foodws.dao.model.Points;
import ru.foodbooking.foodws.support.request.FBServicesReq;
import ru.foodbooking.foodws.support.response.FBServicesRes;

import java.util.ArrayList;
import java.util.List;

@Component("points")
public class PointsService implements FBServices {

    @Autowired
    private PointsRepository pointsRepository;

    @Override
    public FBServicesRes execute(FBServicesReq request) throws FBException {

        List<Points> pointsList = new ArrayList<>();
        if (request != null){
            if (request.getPointId() != null){
                pointsList = pointsRepository.findByPointId(request.getPointId());
            } else if (!StringUtils.isEmpty(request.getAddress())){
                pointsList = pointsRepository.findByPointAddress(request.getAddress());
            }
        } else {
            pointsList = pointsRepository.findAll();
        }
        if (!CollectionUtils.isEmpty(pointsList)){
            for (Points point : pointsList){

            }
        }
        return null;
    }
}
