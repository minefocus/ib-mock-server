package com.pactera.dataserver.core.sbcf.req;

import com.pactera.dataserver.core.sbcf.UtilDoc;
import lombok.Data;

@Data
public class SbcfRootRequest<D extends UtilDoc> {
    private SbcfRequest<D> request;
}
