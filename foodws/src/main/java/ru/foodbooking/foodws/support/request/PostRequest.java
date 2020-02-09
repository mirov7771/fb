package ru.foodbooking.foodws.support.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostRequest extends AbstractRequest {

    @JsonProperty("pointid")
    private Long pointId;
    @JsonProperty("clientphone")
    private String clientPhone;
    @JsonProperty("clientname")
    private String clientName;
    @JsonProperty("totalcost")
    private BigDecimal totalCost;
    @JsonProperty("attrs")
    private List<PostRequest.TAttr> attrs;
    @JsonProperty("deviceid")
    private String deviceId;
    @JsonProperty("orderid")
    private Long orderId;
    @JsonProperty("code")
    private String code;

    public Long getPointId() {
        return pointId;
    }

    public void setPointId(Long pointId) {
        this.pointId = pointId;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public List<PostRequest.TAttr> getAttrs() {
        return attrs;
    }

    public void setAttrs(List<TAttr> attrs) {
        this.attrs = attrs;
    }

    public static class TAttr{

        @JsonProperty("orderid")
        private long orderId;
        @JsonProperty("productid")
        private long productId;
        @JsonProperty("productname")
        private String productName;
        @JsonProperty("prcost")
        private float prCost;
        @JsonProperty("cnt")
        private int cnt;

        public long getOrderId() {
            return orderId;
        }

        public void setOrderId(long orderId) {
            this.orderId = orderId;
        }

        public long getProductId() {
            return productId;
        }

        public void setProductId(long productId) {
            this.productId = productId;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public float getPrCost() {
            return prCost;
        }

        public void setPrCost(float prCost) {
            this.prCost = prCost;
        }

        public int getCnt() {
            return cnt;
        }

        public void setCnt(int cnt) {
            this.cnt = cnt;
        }

    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
