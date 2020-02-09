package ru.foodbooking.foodws.support.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
public class PostResponse {

    @JsonProperty("status")
    private int status;
    @JsonProperty("orderid")
    private Long orderId;

}
