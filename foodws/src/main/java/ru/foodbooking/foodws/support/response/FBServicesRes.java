package ru.foodbooking.foodws.support.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import ru.foodbooking.foodws.support.type.TCategories;
import ru.foodbooking.foodws.support.type.TPoints;
import ru.foodbooking.foodws.support.type.TProducts;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FBServicesRes {

    @JsonProperty("pointslist")
    private List<TPoints> pointsList;
    @JsonProperty("ctgrlist")
    private List<TCategories> ctgrList;
    @JsonProperty("productslist")
    private List<TProducts> productsList;

    public List<TPoints> getPointsList() {
        return pointsList;
    }

    public void setPointsList(List<TPoints> pointsList) {
        this.pointsList = pointsList;
    }

    public List<TCategories> getCtgrList() {
        return ctgrList;
    }

    public void setCtgrList(List<TCategories> ctgrList) {
        this.ctgrList = ctgrList;
    }

    public List<TProducts> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<TProducts> productsList) {
        this.productsList = productsList;
    }

}
