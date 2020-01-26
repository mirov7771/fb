package ru.foodbooking.foodws.dao.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "FB_CATEGORIES")
public class Categories {

    @Id
    @Column(name = "CTGRID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ctgrId;
    @Column(name = "POINTID")
    private Long pointId;
    @Column(name = "CTGRBRIEF")
    private String ctgrBrief;
    @Column(name = "CTGRNAME")
    private String ctgrName;
    @Column(name = "CTGRLOGO")
    private String ctgrLogo;

    @OneToMany(mappedBy = "ctgrId",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Products> productsList;

    public Long getCtgrId() {
        return ctgrId;
    }

    public void setCtgrId(Long ctgrId) {
        this.ctgrId = ctgrId;
    }

    public Long getPointId() {
        return pointId;
    }

    public void setPointId(Long pointId) {
        this.pointId = pointId;
    }

    public String getCtgrBrief() {
        return ctgrBrief;
    }

    public void setCtgrBrief(String ctgrBrief) {
        this.ctgrBrief = ctgrBrief;
    }

    public String getCtgrName() {
        return ctgrName;
    }

    public void setCtgrName(String ctgrName) {
        this.ctgrName = ctgrName;
    }

    public String getCtgrLogo() {
        return ctgrLogo;
    }

    public void setCtgrLogo(String ctgrLogo) {
        this.ctgrLogo = ctgrLogo;
    }

    public List<Products> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Products> productsList) {
        this.productsList = productsList;
    }
}