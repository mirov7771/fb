package ru.foodbooking.foodws.support.type;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TPoints {

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

}
