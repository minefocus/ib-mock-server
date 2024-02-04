package com.pactera.dataserver.core.sbcf.configuration;

import com.pactera.dataserver.core.http.RemoteApi;
import org.springframework.http.HttpMethod;

/**
 * @author Pactera WangShuai
 * @date 2019/12/02 9:32
 */
public enum ApiEnum implements RemoteApi {
    /**
     *
     */
    login(HttpMethod.GET, "/yamagata_data_server/login/{accntNo}"),
    home(HttpMethod.GET, "/yamagata_data_server/home/{accntNo}"),
    detail(HttpMethod.GET, "/yamagata_data_server/detail/{searchDateFrom}/{searchDateTo}/{next}/{accntNo}");

    private HttpMethod method;
    private String path;

    ApiEnum(HttpMethod method, String path) {
        this.method = method;
        this.path = path;
    }

    @Override
    public HttpMethod getMethod() {
        return method;
    }

    @Override
    public String getPath() {
        return path;
    }
}
