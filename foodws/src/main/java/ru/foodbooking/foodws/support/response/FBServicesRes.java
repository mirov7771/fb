package ru.foodbooking.foodws.support.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import ru.foodbooking.foodws.support.type.TCategories;
import ru.foodbooking.foodws.support.type.TPoints;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FBServicesRes {

    @JsonProperty("pointslist")
    private List<TPoints> pointsList;
    @JsonProperty("ctgrlist")
    private List<TCategories> ctgrList;
    @JsonProperty("prdid")
    private Long prdId;
    @JsonProperty("prdbrief")
    private String prdBrief;
    @JsonProperty("prdname")
    private String prdName;
    @JsonProperty("prdlogo")
    private String prdLogo;

    public List<TPoints> getPointsList() {
        return pointsList;
    }

    public void setPointsList(List<TPoints> pointsList) {
        this.pointsList = pointsList;
    }

    public List<TCategories> getCategoriesList() {
        return ctgrList;
    }

    public void setCategoriesList(List<TCategories> ctgrList) {
        this.ctgrList = ctgrList;
    }

    public Long getPrdId() {
        return prdId;
    }

    public void setPrdId(Long prdId) {
        this.prdId = prdId;
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
