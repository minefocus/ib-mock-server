package com.pactera.dataserver.core.sbcf.req;

import lombok.Data;

@Data
public class SbcfRequestHeader {
    private String apiVersion;
    private String sessionId;
    private String authId;
    private String masqueradeUserId;
    private String applicationCd;
    private String applicationVersion;
    private int appDiv;
    private SbcfPager pager;
}
