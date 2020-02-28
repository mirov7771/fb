package ru.foodbooking.foodws.services.get;

import lombok.extern.slf4j.Slf4j;
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
import ru.foodbooking.foodws.support.response.GetResponse;
import ru.foodbooking.foodws.utils.ValidationUtils;

import java.util.ArrayList;
import java.util.List;

@Component("orders")
@Slf4j
public class OrdersService implements GetServices {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private PointsRepository pointsRepository;

    @Override
    public List<GetResponse> execute(GetRequest request) throws FBException {
        log.debug("In method points");
        ValidationUtils.validateRequest(request);
        List<GetResponse> res = new ArrayList<>();
        if (!StringUtils.isEmpty(request.getClientPhone())){
            List<Orders> ordersList = ordersRepository.findByClientPhone(request.getClientPhone());
            if (!CollectionUtils.isEmpty(ordersList)){
                for(Orders order : ordersList){
                    GetResponse tOrder = new GetResponse();
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
                        List<GetResponse.TOrderAttributes> tattrs = new ArrayList<>();
                        for(OrdersAttribute attr : attrs){
                            GetResponse.TOrderAttributes tattr = new GetResponse.TOrderAttributes();
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
        log.debug("Out method points");
        return res;
    }
}
