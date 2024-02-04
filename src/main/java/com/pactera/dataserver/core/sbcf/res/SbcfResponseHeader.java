package com.pactera.dataserver.core.sbcf.res;

import com.pactera.dataserver.core.sbcf.req.SbcfPager;
import lombok.Data;

import java.util.List;

@Data
public class SbcfResponseHeader {
    //APIバージョン
    private String apiVersion;
    //セッションID
    private String sessionId;
    //認証ID
    private String authId;
    //ページング
    private SbcfPager pager;
    //エラー一覧
    private List<SbcfError> errorList;
}
