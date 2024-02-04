package com.pactera.dataserver.api.req;

import com.pactera.dataserver.core.sbcf.UtilDoc;
import lombok.Data;

/**
 * @author Pactera WangShuai
 * @date 2019/12/24 16:41
 */
@Data
public class AccountReq extends UtilDoc {
    private String accountId;
    private String csv;
    private String linkcsv;
}
