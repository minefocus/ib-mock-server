package com.pactera.dataserver.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author cht
 */
@Data
public class DetailSubModel implements Serializable {
    private String transactionDate;
    private String amount;
    private String amount2;
    private String transactionDetail;
    private String transactionBalance;
}
