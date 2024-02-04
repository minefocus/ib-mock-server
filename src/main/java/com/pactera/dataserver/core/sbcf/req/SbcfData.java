package com.pactera.dataserver.core.sbcf.req;

import com.pactera.dataserver.core.sbcf.UtilDoc;
import lombok.Data;

@Data
public class SbcfData<D extends UtilDoc> {
    private String dataClass;
    private String adminName;
    private Object query;
    private Object sort;
    private Object fields;
    private D jsonData;
    private String oid;
}
