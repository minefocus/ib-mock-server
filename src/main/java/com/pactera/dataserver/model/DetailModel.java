package com.pactera.dataserver.model;

import lombok.Data;

import java.util.List;

/**
 * @author cht
 */
@Data
public class DetailModel extends CommonModel {
    private List<DetailSubModel> detailList;
    private String searchYearFrom;
    private String searchMonthFrom;
    private String searchDayFrom;
    private String searchYearTo;
    private String searchMonthTo;
    private String searchDayTo;
    private Integer sleep;
}
