package ru.foodbooking.foodws.dao.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "FB_PRODUCTS")
@Getter @Setter @NoArgsConstructor
public class Products implements Serializable {

    private static final long serialVersionUID = 2712083515043911106L;

    @Id
    @Column(name = "PRDID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prdId;
    @Column(name = "CTGRID")
    private Long ctgrId;
    @Column(name = "PRDBRIEF")
    private String prdBrief;
    @Column(name = "PRDNAME")
    private String prdName;
    @Column(name = "PRDLOGO")
    private String prdLogo;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "COST")
    private BigDecimal cost;
    @Column(name = "POINTID")
    private Long pointId;

}
