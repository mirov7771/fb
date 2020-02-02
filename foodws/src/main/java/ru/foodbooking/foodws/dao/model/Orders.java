package ru.foodbooking.foodws.dao.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "FB_ORDER")
public class Orders implements Serializable {

    private static final long serialVersionUID = -602019617430872021L;

    @Id
    @Column(name = "ORDERID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToMany(mappedBy = "orderId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<OrdersAttribute> ordersAttributeList;

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

    public List<OrdersAttribute> getOrdersAttributeList() {
        return ordersAttributeList;
    }

    public void setOrdersAttributeList(List<OrdersAttribute> ordersAttributeList) {
        this.ordersAttributeList = ordersAttributeList;
    }
}
