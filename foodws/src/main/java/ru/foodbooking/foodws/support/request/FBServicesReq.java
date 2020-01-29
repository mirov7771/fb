package ru.foodbooking.foodws.support.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FBServicesReq {

    @JsonProperty("pointid")
    private Long pointId;
    @JsonProperty("address")
    private String address;
    @JsonProperty("ctgrid")
    private Long ctgrId;
    @JsonProperty("productid")
    private Long productId;

    public void setPointId(Long pointId) {
        this.pointId = pointId;
    }

    public Long getPointId() {
        return pointId;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setCtgrId(Long ctgrId) {
        this.ctgrId = ctgrId;
    }

    public Long getCtgrId() {
        return ctgrId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getProductId() {
        return productId;
    }
}

