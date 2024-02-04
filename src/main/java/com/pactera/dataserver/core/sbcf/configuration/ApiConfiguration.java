package com.pactera.dataserver.core.sbcf.configuration;

import com.pactera.dataserver.core.http.AbstractRestConfiguration;
import com.pactera.dataserver.core.http.RequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;

import java.util.Collections;

/**
 * @author Pactera WangShuai
 * @date 2019/11/22 16:19
 */
@Component
public class ApiConfiguration extends AbstractRestConfiguration {

    @Value("${sbcf.base.url}")
    private String baseUrl;
    @Value("${bank.api.connect.timeout}")
    private int connectTimeout;
    @Value("${bank.api.read.timeout}")
    private int readTimeout;

    @Override
    public String baseUrl() {
        return baseUrl;
    }

    @Autowired
    private RequestInterceptor requestInterceptor;

    @Override
    public RequestInterceptor requestInterceptor() {
        return requestInterceptor;
    }

    @Override
    public ClientHttpRequestFactory requestFactory() {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        // 连接超时
        requestFactory.setConnectTimeout(connectTimeout);
        // 响应超时
        requestFactory.setReadTimeout(readTimeout);
        return requestFactory;
    }

    @Override
    public HttpHeaders defaultHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

}
