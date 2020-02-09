package ru.foodbooking.foodws.dao.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "FB_ORDER")
@Getter @Setter @NoArgsConstructor
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
    @Column(name = "ORDERSTATE")
    private String orderState;
    @Column(name = "USERID")
    private Long userId;

    @OneToMany(mappedBy = "orderId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<OrdersAttribute> ordersAttributeList;

}
