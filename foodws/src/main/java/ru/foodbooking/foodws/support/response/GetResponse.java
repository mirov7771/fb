package ru.foodbooking.foodws.support.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter @Setter @NoArgsConstructor
public class GetResponse {

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
    @JsonProperty("type")
    private Integer type;
    @JsonProperty("orderattributes")
    private List<TOrderAttributes> orderAttributes;

    @Getter @Setter @NoArgsConstructor
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
        private BigDecimal prCost;
        @JsonProperty("productcount")
        private BigDecimal cnt;
    }
}
