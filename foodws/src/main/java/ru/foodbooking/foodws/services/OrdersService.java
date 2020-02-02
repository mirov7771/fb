package ru.foodbooking.foodws.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import ru.foodbooking.foodws.FBException;
import ru.foodbooking.foodws.dao.OrdersRepository;
import ru.foodbooking.foodws.dao.PointsRepository;
import ru.foodbooking.foodws.dao.model.Orders;
import ru.foodbooking.foodws.dao.model.OrdersAttribute;
import ru.foodbooking.foodws.dao.model.Points;
import ru.foodbooking.foodws.support.request.GetRequest;
import ru.foodbooking.foodws.support.response.FBServicesRes;
import ru.foodbooking.foodws.utils.ValidationUtils;

import java.util.ArrayList;
import java.util.List;

@Component("orders")
public class OrdersService implements FBServices {

    private static Logger LOG = Logger.getLogger(OrdersService.class);

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private PointsRepository pointsRepository;

    @Override
    public List<FBServicesRes> execute(GetRequest request) throws FBException {
        LOG.debug("In method points");
        ValidationUtils.validateRequest(request);
        List<FBServicesRes> res = new ArrayList<>();
        if (!StringUtils.isEmpty(request.getClientPhone())){
            List<Orders> ordersList = ordersRepository.findByClientPhone(request.getClientPhone());
            if (!CollectionUtils.isEmpty(ordersList)){
                for(Orders order : ordersList){
                    FBServicesRes tOrder = new FBServicesRes();
                    tOrder.setOrderId(order.getOrderId());
                    tOrder.setOrderDate(order.getOrderDate());
                    tOrder.setClientPhone(order.getClientPhone());
                    tOrder.setClientName(order.getClientName());
                    tOrder.setTotalCost(order.getTotalCost());
                    Long pointId = order.getPointId();
                    List<Points> pointsList = pointsRepository.findByPointId(pointId);
                    String pointName = null;
                    String pointAddress = null;
                    if (!CollectionUtils.isEmpty(pointsList)){
                        pointName = pointsList.get(0).getPointName();
                        pointAddress = pointsList.get(0).getPointAddress();
                    }
                    tOrder.setPointName(pointName);
                    tOrder.setPointAddress(pointAddress);
                    List<OrdersAttribute> attrs = order.getOrdersAttributeList();
                    if (!CollectionUtils.isEmpty(attrs)){
                        List<FBServicesRes.TOrderAttributes> tattrs = new ArrayList<>();
                        for(OrdersAttribute attr : attrs){
                            FBServicesRes.TOrderAttributes tattr = new FBServicesRes.TOrderAttributes();
                            tattr.setOrderId(attr.getOrderId());
                            tattr.setOrderAttributeId(attr.getOrderAttributeId());
                            tattr.setProductName(attr.getProductName());
                            tattr.setProductId(attr.getProductId());
                            tattr.setCnt(attr.getCnt());
                            tattr.setPrCost(attr.getPrCost());
                            tattrs.add(tattr);
                        }
                        tOrder.setOrderAttributes(tattrs);
                    }
                    res.add(tOrder);
                }
            }
        }
        LOG.debug("Out method points");
        return res;
    }
}
