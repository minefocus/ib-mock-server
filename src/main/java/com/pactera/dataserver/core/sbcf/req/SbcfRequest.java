package com.pactera.dataserver.core.sbcf.req;

import com.pactera.dataserver.core.sbcf.UtilDoc;
import lombok.Data;

@Data
public class SbcfRequest<D extends UtilDoc> {
    private SbcfRequestHeader requestHeader;
    private SbcfData<D> data;
}
