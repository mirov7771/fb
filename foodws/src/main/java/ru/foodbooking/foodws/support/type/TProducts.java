package ru.foodbooking.foodws.support.type;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TProducts {

    @JsonProperty("ctgrid")
    private Long ctgrId;
    @JsonProperty("prdid")
    private Long prdId;
    @JsonProperty("prdbrief")
    private String prdBrief;
    @JsonProperty("prdname")
    private String prdName;
    @JsonProperty("prdlogo")
    private String prdLogo;

    public Long getCtgrId() {
        return ctgrId;
    }

    public void setCtgrId(Long ctgrId) {
        this.ctgrId = ctgrId;
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
