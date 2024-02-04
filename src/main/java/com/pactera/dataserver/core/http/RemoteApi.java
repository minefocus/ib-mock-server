package com.pactera.dataserver.core.http;

import org.springframework.http.HttpMethod;

/**
 * @author Pactera WangShuai
 * @date 2019/12/02 10:15
 */
public interface RemoteApi {

    public HttpMethod getMethod();

    public String getPath();
}
