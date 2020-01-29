package ru.foodbooking.foodws.support.type;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TCategories {

    @JsonProperty("pointid")
    private Long pointId;
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

    public Long getPointId() {
        return pointId;
    }

    public void setPointId(Long pointId) {
        this.pointId = pointId;
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
}
