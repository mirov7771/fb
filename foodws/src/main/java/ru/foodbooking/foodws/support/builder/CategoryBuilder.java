package ru.foodbooking.foodws.support.builder;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import ru.foodbooking.foodws.support.response.GetResponse;

@Getter
public class CategoryBuilder extends GetResponse {

    @JsonProperty("ctgrid")
    private Long ctgrId;
    @JsonProperty("ctgrbrief")
    private String ctgrBrief;
    @JsonProperty("ctgrname")
    private String ctgrName;

    public static class Builder{

        private Long ctgrId;
        private String ctgrBrief;
        private String ctgrName;

        public Builder(Long ctgrId){
            this.ctgrId = ctgrId;
        }

        public Builder setCtgrBrief(String ctgrBrief){
            this.ctgrBrief = ctgrBrief;
            return this;
        }

        public Builder setCtgrName(String ctgrName){
            this.ctgrName = ctgrName;
            return this;
        }

        public CategoryBuilder build(){
            return new CategoryBuilder(this);
        }
    }

    private CategoryBuilder(Builder builder){
        this.ctgrId = builder.ctgrId;
        this.ctgrBrief = builder.ctgrBrief;
        this.ctgrName = builder.ctgrName;
    }

}
