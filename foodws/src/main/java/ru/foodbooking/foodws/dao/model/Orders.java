package ru.foodbooking.foodws.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "FB_ORDER")
public class Orders {

    @Column(name = "ORDERID")
    private Long orderId;
    @Column(name = "ORDERDATE")
    private Date orderDate;
    @Column(name = "CLIENTPHONE")
    private String clientPhone;
    @Column(name = "CLIENTNAME")
    private String clientName;
    @Column(name = "POINTID")
    private Long pointId;
    @Column(name = "TOTALCOST")
    private BigDecimal totalCost;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Long getPointId() {
        return pointId;
    }

    public void setPointId(Long pointId) {
        this.pointId = pointId;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }
}
