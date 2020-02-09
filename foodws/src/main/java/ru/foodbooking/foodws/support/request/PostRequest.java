package ru.foodbooking.foodws.support.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter @Setter @NoArgsConstructor
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

    @Getter @Setter @NoArgsConstructor
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

    }

}
