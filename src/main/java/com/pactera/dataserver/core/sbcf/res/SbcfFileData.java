package com.pactera.dataserver.core.sbcf.res;

import lombok.Data;

@Data
public class SbcfFileData {
    //コンテンツタイプ
    private String contentType;
    //ファイル名
    private String fileName;
    //ファイルサイズ
    private Integer fileSize;
}
