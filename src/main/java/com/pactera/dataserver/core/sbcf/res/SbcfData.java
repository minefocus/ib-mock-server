package com.pactera.dataserver.core.sbcf.res;

import com.pactera.dataserver.core.sbcf.UtilDoc;
import lombok.Data;

@Data
public class SbcfData<D extends UtilDoc> {
    //データクラス
    private String dataClass;
    //データID
    private String oid;
    //管理名称
    private String adminName;
    //jsonデータ
    private D jsonData;
    //ファイル
    private SbcfFileData fileData;
}
