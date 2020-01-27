package ru.foodbooking.foodws.support.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class FBServicesRes {

    @JsonProperty("pointid")
    private Long pointId;
    @JsonProperty("pointbrief")
    private String pointBrief;
    @JsonProperty("pointname")
    private String pointName;
    @JsonProperty("pointaddress")
    private String pointAddress;
    @JsonProperty("pointlogo")
    private String pointLogo;
    @JsonProperty("ctgrid")
    private Long ctgrId;
    @JsonProperty("ctgrbrief")
    private String ctgrBrief;
    @JsonProperty("ctgrname")
    private String ctgrName;
    @JsonProperty("ctgrlogo")
    private String ctgrLogo;
    @JsonProperty("prdid")
    private Long prdId;
    @JsonProperty("prdbrief")
    private String prdBrief;
    @JsonProperty("prdname")
    private String prdName;
    @JsonProperty("prdlogo")
    private String prdLogo;

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

    public Long getCtgrId() {
        return ctgrId;
    }

    public void setCtgrId(Long ctgrId) {
        this.ctgrId = ctgrId;
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
