package ru.foodbooking.foodws.support.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class PostRequest {

    @JsonProperty("pointid")
    private Long pointId;
    @JsonProperty("date")
    private Date date;
    @JsonProperty("clientphone")
    private String clientPhone;
    @JsonProperty("clientname")
    private String clientName;
    @JsonProperty("totalcost")
    private BigDecimal totalCost;
    @JsonProperty("attrs")
    private List<PostRequest.TAttr> attrs;

    public Long getPointId() {
        return pointId;
    }

    public void setPointId(Long pointId) {
        this.pointId = pointId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
}
