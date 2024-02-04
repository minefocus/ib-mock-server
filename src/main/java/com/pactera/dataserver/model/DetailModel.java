package com.pactera.dataserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jdk.nashorn.internal.objects.annotations.Property;
import lombok.Data;

import java.util.List;

/**
 * @author cht
 */
@Data
public class DetailModel extends CommonModel {
    private List<DetailSubModel> detailList;
    @JsonProperty(value = "SearchYearFrom")
    private String searchYearFrom;
    private String searchMonthFrom;
    private String searchDayFrom;
    private String searchYearTo;
    private String searchMonthTo;
    private String searchDayTo;
}
