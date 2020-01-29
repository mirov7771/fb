package ru.foodbooking.foodws.support.request;

public class FBServicesReq {

    private Long pointId;
    private String address;
    private Long ctgrId;
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

