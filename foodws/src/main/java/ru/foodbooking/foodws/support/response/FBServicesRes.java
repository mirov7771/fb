package ru.foodbooking.foodws.support.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

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
    @JsonProperty("description")
    private String description;
    @JsonProperty("prdid")
    private Long prdId;
    @JsonProperty("prdbrief")
    private String prdBrief;
    @JsonProperty("prdname")
    private String prdName;
    @JsonProperty("prdlogo")
    private String prdLogo;
    @JsonProperty ("cost")
    private BigDecimal cost;
    @JsonProperty("orderid")
    private Long orderId;
    @JsonProperty("orderdate")
    private Date orderDate;
    @JsonProperty("clientphone")
    private String clientPhone;
    @JsonProperty("clientname")
    private String clientName;
    @JsonProperty("totalcost")
    private BigDecimal totalCost;
    @JsonProperty("orderattributes")
    private List<TOrderAttributes> orderAttributes;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
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

    public List<TOrderAttributes> getOrderAttributes() {
        return orderAttributes;
    }

    public void setOrderAttributes(List<TOrderAttributes> orderAttributes) {
        this.orderAttributes = orderAttributes;
    }

    public static class TOrderAttributes{
        @JsonProperty("id")
        private long orderAttributeId;
        @JsonProperty("orderid")
        private long orderId;
        @JsonProperty("productid")
        private long productId;
        @JsonProperty("productname")
        private String productName;
        @JsonProperty("productcost")
        private float prCost;
        @JsonProperty("productcount")
        private int cnt;

        public long getOrderAttributeId() {
            return orderAttributeId;
        }

        public void setOrderAttributeId(long orderAttributeId) {
            this.orderAttributeId = orderAttributeId;
        }

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
