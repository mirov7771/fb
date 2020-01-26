package ru.foodbooking.foodws.dao.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "FB_POINTS")
public class Points {

    @Id
    @Column(name = "POINTID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pointId;
    @Column(name = "POINTBRIEF")
    private String pointBrief;
    @Column(name = "POINTNAME")
    private String pointName;
    @Column(name = "POINTADDRESS")
    private String pointAddress;
    @Column(name = "POINTLOGO")
    private String pointLogo;

    @OneToMany(mappedBy = "pointId", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Categories> categoriesList;

    public Long getPointId() {
        return pointId;
    }

    public void setPointId(Long pointId) {
        this.pointId = pointId;
    }

    public String getPointBrief() {
        return pointBrief;
    }

    public void setPointBrief(String pointBrief) {
        this.pointBrief = pointBrief;
    }

    public String getPointName() {
        return pointName;
    }

    public void setPointName(String pointName) {
        this.pointName = pointName;
    }

    public String getPointAddress() {
        return pointAddress;
    }

    public void setPointAddress(String pointAddress) {
        this.pointAddress = pointAddress;
    }

    public String getPointLogo() {
        return pointLogo;
    }

    public void setPointLogo(String pointLogo) {
        this.pointLogo = pointLogo;
    }

    public List<Categories> getCategoriesList() {
        return categoriesList;
    }

    public void setCategoriesList(List<Categories> categoriesList) {
        this.categoriesList = categoriesList;
    }
}
