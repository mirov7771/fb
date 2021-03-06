package ru.foodbooking.foodws.support.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GetRequest extends AbstractRequest{

    private Long pointId;
    private String address;
    private Long ctgrId;
    private Long productId;
    private String clientPhone;

    public static class Builder{

        private Long pointId;
        private String address;
        private Long ctgrId;
        private Long productId;
        private String clientPhone;

        public Builder setPointId(Long pointId){
            this.pointId = pointId;
            return this;
        }

        public Builder setAddress(String address){
            this.address = address;
            return this;
        }

        public Builder setCtgrId(Long ctgrId){
            this.ctgrId = ctgrId;
            return this;
        }

        public Builder setProductId(Long productId){
            this.productId = productId;
            return this;
        }

        public Builder setClientPhone(String clientPhone){
            this.clientPhone = clientPhone;
            return this;
        }

        public GetRequest build(){
            return new GetRequest(this);
        }
    }

    private GetRequest(Builder builder){
        pointId = builder.pointId;
        address = builder.address;
        ctgrId = builder.ctgrId;
        productId = builder.productId;
        clientPhone = builder.clientPhone;
    }
}
