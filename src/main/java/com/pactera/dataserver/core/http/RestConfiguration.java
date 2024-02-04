package com.pactera.dataserver.core.http;

import org.springframework.http.HttpHeaders;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.web.client.ResponseErrorHandler;

/**
 * @author Pactera WangShuai
 * @date 2019/11/22 15:50
 */
public interface RestConfiguration {
    /**
     * ss
     *
     * @return
     */
    String baseUrl();
    /**
     * RequestInterceptor
     *
     * @return
     */
    RequestInterceptor requestInterceptor();
    /**
     * ss
     *
     * @return
     */
    HttpHeaders defaultHeaders();

    /**
     * sss
     *
     * @return
     */
    ClientHttpRequestFactory requestFactory();

    /**
     * ss
     *
     * @return
     */
    ResponseErrorHandler errorHandler();
}
