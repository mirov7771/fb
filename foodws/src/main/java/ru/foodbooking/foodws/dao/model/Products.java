package ru.foodbooking.foodws.dao.model;

import javax.persistence.*;

@Entity
@Table(name = "FB_PRODUCTS")
public class Products {

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

    public Long getPrdId() {
        return prdId;
    }

    public void setPrdId(Long prdId) {
        this.prdId = prdId;
    }

    public Long getCtgrId() {
        return ctgrId;
    }

    public void setCtgrId(Long ctgrId) {
        this.ctgrId = ctgrId;
    }

    public String getPrdBrief() {
        return prdBrief;
    }

    public void setPrdBrief(String prdBrief) {
        this.prdBrief = prdBrief;
    }

    public String getPrdName() {
        return prdName;
    }

    public void setPrdName(String prdName) {
        this.prdName = prdName;
    }

    public String getPrdLogo() {
        return prdLogo;
    }

    public void setPrdLogo(String prdLogo) {
        this.prdLogo = prdLogo;
    }
}
