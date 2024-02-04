package com.pactera.dataserver.vo;

import com.pactera.dataserver.core.http.ErrorBean;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.util.StringUtils;

/**
 * @author cht
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class BankApiErrorMessageVo extends ErrorBean {
    private String errorCode;
    private String errorMessage;

    public boolean is400ServerError() {
        return (getHttpCode() == 400 && !StringUtils.isEmpty(errorCode) && !StringUtils.isEmpty(errorMessage));
    }

    public boolean is404ServerError() {
        return (getHttpCode() == 404);
    }

    public boolean is503ServerError() {
        return (getHttpCode() == 503);
    }

    public boolean is500ServerError() {
        return (getHttpCode() == 500);
    }

}
