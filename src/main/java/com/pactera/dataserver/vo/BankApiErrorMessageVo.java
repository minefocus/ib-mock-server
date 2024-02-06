package com.pactera.dataserver.vo;

import com.pactera.dataserver.core.http.ErrorBean;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author cht
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class BankApiErrorMessageVo extends ErrorBean {
    private String errorCode;
    private String errorMessage;

}
