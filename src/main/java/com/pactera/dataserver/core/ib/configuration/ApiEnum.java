package com.pactera.dataserver.core.ib.configuration;

import com.pactera.dataserver.core.http.RemoteApi;
import org.springframework.http.HttpMethod;

/**
 * @author cht
 */
public enum ApiEnum implements RemoteApi {
    /**
     *
     */
    login(HttpMethod.GET, "/login/{accntNo}/{password}"),
    home(HttpMethod.GET, "/home/{accntNo}"),
    detail(HttpMethod.GET, "/detail/{searchDateFrom}/{searchDateTo}/{next}/{accntNo}");

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
