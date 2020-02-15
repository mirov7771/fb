package ru.foodbooking.foodws.dao.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "FB_ORDERSATTRIBUTE")
@Getter @Setter @NoArgsConstructor
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
    private BigDecimal prCost;
    @Column(name = "CNT")
    private BigDecimal cnt;

}
