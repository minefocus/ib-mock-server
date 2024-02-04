package com.pactera.dataserver.core.sbcf.res;

import lombok.Data;

@Data
public class SbcfError {
    //エラープロパティ
    private String errorProperty;
    //エラーコード
    private String errorCd;
    //エラーメッセージ
    private String errorMessage;
}
