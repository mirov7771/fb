package ru.foodbooking.foodws.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import ru.foodbooking.foodws.FBException;
import ru.foodbooking.foodws.support.request.GetRequest;
import ru.foodbooking.foodws.dao.PointsRepository;
import ru.foodbooking.foodws.dao.model.Points;
import ru.foodbooking.foodws.support.response.FBServicesRes;

import java.util.ArrayList;
import java.util.List;

@Component("points")
public class PointsService implements FBServices {

    private static Logger LOG = Logger.getLogger(PointsService.class);

    @Autowired
    private PointsRepository pointsRepository;

    @Override
    public List<FBServicesRes> execute(GetRequest request) throws FBException {
        LOG.debug("In method points");
        List<Points> pointsList = new ArrayList<>();
        if (request.getPointId() != null){
            pointsList = pointsRepository.findByPointId(request.getPointId());
        } else if (!StringUtils.isEmpty(request.getAddress())){
            pointsList = pointsRepository.findByPointAddress(request.getAddress());
        } else {
            Iterable<Points> pointsIterable = pointsRepository.findAll();
            if (pointsIterable != null){
                for(Points point : pointsIterable){
                    pointsList.add(point);
                }
            }
        }

        List<FBServicesRes> res = new ArrayList<>();
        if (!CollectionUtils.isEmpty(pointsList)){
            for (Points point : pointsList){
                 FBServicesRes tPoint = new FBServicesRes();
                 tPoint.setPointId(point.getPointId());
                 tPoint.setPointBrief(point.getPointBrief());
                 tPoint.setPointName(point.getPointName());
                 tPoint.setPointAddress(point.getPointAddress());
                 tPoint.setPointLogo(point.getPointLogo());
                 res.add(tPoint);
            }
        }
        LOG.debug("Out method points");
        return res;
    }

}
