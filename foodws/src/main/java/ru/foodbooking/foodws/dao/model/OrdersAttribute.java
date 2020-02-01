package ru.foodbooking.foodws.dao.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "FB_ORDERSATTRIBUTE")
public class OrdersAttribute implements Serializable {

    private static final long serialVersionUID = -2591442644934729321L;

    @Id
    @Column(name = "ORDERATTRIBUTEID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderAttributeId;
    @Column(name = "ORDERID")
    private long orderId;
    @Column(name = "PRODUCTID")
    private long productId;
    @Column(name = "PRODUCTNAME")
    private String productName;
    @Column(name = "PRCOST")
    private float prCost;
    @Column(name = "CNT")
    private int cnt;

    @OneToMany(mappedBy = "orderId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<OrdersAttribute> ordersAttributeList;

    public long getOrderAttributeId() {
        return orderAttributeId;
    }

    public void setOrderAttributeId(long orderAttributeId) {
        this.orderAttributeId = orderAttributeId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrCost() {
        return prCost;
    }

    public void setPrCost(float prCost) {
        this.prCost = prCost;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public List<OrdersAttribute> getOrdersAttributeList() {
        return ordersAttributeList;
    }

    public void setOrdersAttributeList(List<OrdersAttribute> ordersAttributeList) {
        this.ordersAttributeList = ordersAttributeList;
    }
}
