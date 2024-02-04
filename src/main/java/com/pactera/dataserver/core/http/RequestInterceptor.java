package com.pactera.dataserver.core.http;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Slf4j
@Component
public class RequestInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
        long startTime = System.currentTimeMillis();
        String requestBody = new String(bytes, StandardCharsets.UTF_8);
        log.debug("Request Body: {}", requestBody);
        ClientHttpResponse clientHttpResponse = clientHttpRequestExecution.execute(httpRequest, bytes);
        long endTime = System.currentTimeMillis();
        String xTandiTransactionId = httpRequest.getHeaders().getFirst("X-tandi-TransactionId") == null ? "-" : httpRequest.getHeaders().getFirst("X-tandi-TransactionId");
        log.info("request url：[{}] {}  request execution time：{}ms ", xTandiTransactionId, httpRequest.getURI(), (endTime - startTime));
        return clientHttpResponse;
    }
}
