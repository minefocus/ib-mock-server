package com.pactera.dataserver.core.sbcf.req;

import lombok.Data;

@Data
public class SbcfPager {
    //取得ページ
    private Integer page;
    //ページ内取得件数
    private Integer limit;
    //該当件数
    private Integer count;
    //現在ページ開始位置
    private Integer start;
    //現在ページ終了位置
    private Integer end;
}
