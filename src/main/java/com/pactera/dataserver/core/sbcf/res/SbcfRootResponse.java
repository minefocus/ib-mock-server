package com.pactera.dataserver.core.sbcf.res;

import com.pactera.dataserver.core.sbcf.UtilDoc;
import lombok.Data;

@Data
public class SbcfRootResponse<D extends UtilDoc> {
    //レスポンスデータ
    private SbcfResponse<D> response;
}
