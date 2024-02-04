package com.pactera.dataserver.api.req;

import com.pactera.dataserver.core.sbcf.UtilDoc;
import lombok.Data;

/**
 * @author Pactera WangShuai
 * @date 2019/12/24 17:39
 */
@Data
public class StatusReq extends UtilDoc {
    private String applicationDate;
    private String applicationType;
    private String appVer;
    private String deviceIdentification;

    private String sendStatus;
    private String compDate;

    private String revisionOid;
    private String errorMsg;

    private String dnpSendDate;
    private String dnpSendStatus;

    private String acomSendDate;
    private String acomSendStatus;

    private String bankAccountSendDate;
    private String bankAccountSendStatus;
    private String bankAddressSendDate;
    private String bankAddressSendStatus;
}
