package com.pactera.dataserver.core.sbcf.res;

import com.pactera.dataserver.core.sbcf.UtilDoc;
import lombok.Data;

import java.util.List;

@Data
public class SbcfResponse<D extends UtilDoc> {
    //レスポンスヘッダ
    private SbcfResponseHeader responseHeader;
    //データリスト
    private List<SbcfData<D>> dataList;
    //データ
    private SbcfData<D> data;

}
