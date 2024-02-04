package com.pactera.dataserver.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author cht
 */
@Data
public class CommonModel implements Serializable {
    private String xtr;
    private String branchNo;
    private String accntNo;
    private String next;
    private String passWord;
    private String SearchYearFrom;
    private String SearchMonthFrom;
    private String SearchDayFrom;
    private String SearchYearTo;
    private String SearchMonthTo;
    private String SearchDayTo;
    private String err_msg;
    private String err_msg_home;
    private String box_area_message;
}
