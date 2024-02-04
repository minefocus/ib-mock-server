package com.pactera.dataserver.core.http;

import org.springframework.http.HttpHeaders;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.web.client.ResponseErrorHandler;

/**
 * @author Pactera WangShuai
 * @date 2019/11/22 15:50
 */
public abstract class AbstractRestConfiguration implements RestConfiguration {
    @Override
    public HttpHeaders defaultHeaders() {
        return null;
    }

    @Override
    public ClientHttpRequestFactory requestFactory() {
        return null;
    }

    @Override
    public ResponseErrorHandler errorHandler() {
        return null;
    }
}
