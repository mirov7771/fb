package ru.foodbooking.foodws.support.request;

public class FBServicesReq {

    private Long pointid;
    private String address;
    private Long ctgrid;
    private Long productid;

    public void setPointid(Long pointid) {
        this.pointid = pointid;
    }

    public Long getPointid() {
        return pointid;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setCtgrid(Long ctgrid) {
        this.ctgrid = ctgrid;
    }

    public Long getCtgrid() {
        return ctgrid;
    }

    public void setProductid(Long productid) {
        this.productid = productid;
    }

    public Long getProductid() {
        return productid;
    }
}

