package com.pactera.dataserver.core.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * d
 *
 * @author Pactera WangShuai
 * @date 2019/11/07 15:26
 */
@Slf4j
@Component
public class CusRestTemplate {

    private final ObjectMapper om;

    private final RestTemplate restTemplate;

    private final String baseUrl;

    private final HttpHeaders defaultHeaders;

    public CusRestTemplate(RestConfiguration restConfiguration) {
        this.baseUrl = restConfiguration.baseUrl();
        this.defaultHeaders = restConfiguration.defaultHeaders();

        if (restConfiguration.requestFactory() == null) {
            this.restTemplate = new RestTemplate();
        } else {
            this.restTemplate = new RestTemplate(restConfiguration.requestFactory());
        }

        if (restConfiguration.errorHandler() != null) {
            this.restTemplate.setErrorHandler(restConfiguration.errorHandler());
        }
        restTemplate.setInterceptors(Collections.singletonList(restConfiguration.requestInterceptor()));

        this.om = new ObjectMapper();
    }

    /**
     * GET方式のリクエスト
     *
     * @param remoteApi    APIの型
     * @param uriVariables パラメータ
     * @param <T>          結果オブジェクト
     * @return 正常に戻った結果のオブジェクト
     */
    public <T> Optional<T> getForEntity(final RemoteApi remoteApi, Class<T> resultType, Object... uriVariables) {
        try {
            ResponseEntity<T> result = restTemplate.getForEntity(this.baseUrl.concat(remoteApi.getPath()), resultType, uriVariables);
            return Optional.ofNullable(result.getBody());
        } catch (RestClientResponseException e) {
            log.warn("{} {}", e.getRawStatusCode(), e.getResponseBodyAsString());
            if (log.isDebugEnabled()) {
                log.debug(e.getMessage(), e);
            }
            return Optional.empty();
        }
    }

    /**
     * リクエスト
     *
     * @param remoteApi         APIの型
     * @param headers           ヘッド情報
     * @param resultType        結果のオブジェクトタイプ
     * @param errorType         エラーオブジェクトタイプ
     * @param exceptionSupplier エラーリカバリー
     * @param uriVariables      パラメータ
     * @param <T>               結果オブジェクト
     * @param <E>               エラーオブジェクト
     * @param <X>               異常オブジェクト
     * @return 正常に戻った結果のオブジェクト
     * @throws X           異常オブジェクト
     * @throws IOException IO異常
     */
    public <T, E extends ErrorBean, X extends Throwable> Optional<T> getForEntityOrElseThrow(final RemoteApi remoteApi,
                                                                                             final HttpHeaders headers,
                                                                                             Class<T> resultType,
                                                                                             Class<E> errorType,
                                                                                             CusSupplier<E, ? extends X> exceptionSupplier,
                                                                                             final Object... uriVariables) throws X, IOException {
        return orElseThrow(() -> restTemplate.exchange(this.baseUrl.concat(remoteApi.getPath()),
                remoteApi.getMethod(), entity(headers), resultType, uriVariables), errorType, exceptionSupplier, remoteApi);
    }

    /**
     * リクエスト
     *
     * @param remoteApi         APIの型
     * @param headers           ヘッド情報
     * @param resultType        結果のオブジェクトタイプ
     * @param errorType         エラーオブジェクトタイプ
     * @param exceptionSupplier エラーリカバリー
     * @param uriVariables      パラメータ
     * @param <T>               結果オブジェクト
     * @param <E>               エラーオブジェクト
     * @param <X>               異常オブジェクト
     * @return 正常に戻った結果のオブジェクト
     * @throws X           異常オブジェクト
     * @throws IOException IO異常
     */
    public <T, E extends ErrorBean, X extends Throwable> Optional<T> getForEntityOrElseThrow(final RemoteApi remoteApi,
                                                                                             final HttpHeaders headers,
                                                                                             Class<T> resultType,
                                                                                             Class<E> errorType,
                                                                                             CusSupplier<E, ? extends X> exceptionSupplier,
                                                                                             final Map<String, ?> uriVariables) throws X, IOException {
        return orElseThrow(() -> restTemplate.exchange(this.baseUrl.concat(remoteApi.getPath()),
                remoteApi.getMethod(), entity(headers), resultType, uriVariables), errorType, exceptionSupplier, remoteApi);
    }

    /**
     * リクエスト
     *
     * @param remoteApi         APIの型
     * @param headers           ヘッド情報
     * @param uriQuery          urlクエリパラメータ
     * @param resultType        結果のオブジェクトタイプ
     * @param errorType         エラーオブジェクトタイプ
     * @param exceptionSupplier エラーリカバリー
     * @param uriVariables      パラメータ
     * @param <T>               結果オブジェクト
     * @param <E>               エラーオブジェクト
     * @param <X>               異常オブジェクト
     * @return 正常に戻った結果のオブジェクト
     * @throws X           異常オブジェクト
     * @throws IOException IO異常
     */
    public <T, E extends ErrorBean, X extends Throwable> Optional<T> getForEntityOrElseThrow(final RemoteApi remoteApi,
                                                                                             final HttpHeaders headers,
                                                                                             final String uriQuery,
                                                                                             Class<T> resultType,
                                                                                             Class<E> errorType,
                                                                                             CusSupplier<E, ? extends X> exceptionSupplier,
                                                                                             final Map<String, ?> uriVariables) throws X, IOException {
        return orElseThrow(() -> restTemplate.exchange(this.baseUrl.concat(remoteApi.getPath()).concat(uriQuery),
                remoteApi.getMethod(), entity(headers), resultType, uriVariables), errorType, exceptionSupplier, remoteApi);
    }

    /**
     * リクエスト
     *
     * @param remoteApi         APIの型
     * @param entity            リクエストボディ
     * @param resultType        結果のオブジェクトタイプ
     * @param errorType         エラーオブジェクトタイプ
     * @param exceptionSupplier エラーリカバリー
     * @param uriVariables      パラメータ
     * @param <T>               結果オブジェクト
     * @param <E>               エラーオブジェクト
     * @param <X>               異常オブジェクト
     * @return 正常に戻った結果のオブジェクト
     * @throws X           異常オブジェクト
     * @throws IOException IO異常
     */
    public <T, E extends ErrorBean, X extends Throwable> Optional<T> postForEntityOrElseThrow(final RemoteApi remoteApi,
                                                                                              final HttpEntity<?> entity,
                                                                                              Class<T> resultType,
                                                                                              Class<E> errorType,
                                                                                              CusSupplier<E, ? extends X> exceptionSupplier,
                                                                                              final Object... uriVariables) throws X, IOException {
        return orElseThrow(() -> restTemplate.exchange(this.baseUrl.concat(remoteApi.getPath()),
                remoteApi.getMethod(), entity(entity), resultType, uriVariables), errorType, exceptionSupplier, remoteApi);
    }

    public <T, E extends ErrorBean, X extends Throwable> Optional<T> postForEntityOrElseThrow(final RemoteApi remoteApi,
                                                                                              final HttpEntity<?> entity,
                                                                                              ParameterizedTypeReference<T> resultType,
                                                                                              Class<E> errorType,
                                                                                              CusSupplier<E, ? extends X> exceptionSupplier,
                                                                                              final Object... uriVariables) throws X, IOException {
        return orElseThrow(() -> restTemplate.exchange(this.baseUrl.concat(remoteApi.getPath()),
                remoteApi.getMethod(), entity(entity), resultType, uriVariables), errorType, exceptionSupplier, remoteApi);
    }

    /**
     * リクエスト
     *
     * @param remoteApi         APIの型
     * @param entity            リクエストボディ
     * @param resultType        結果のオブジェクトタイプ
     * @param errorType         エラーオブジェクトタイプ
     * @param exceptionSupplier エラーリカバリー
     * @param uriVariables      パラメータ
     * @param <T>               結果オブジェクト
     * @param <E>               エラーオブジェクト
     * @param <X>               異常オブジェクト
     * @return 正常に戻った結果のオブジェクト
     * @throws X           異常オブジェクト
     * @throws IOException IO異常
     */
    public <T, E extends ErrorBean, X extends Throwable> Optional<T> postForEntityOrElseThrow(final RemoteApi remoteApi,
                                                                                              final HttpEntity<?> entity,
                                                                                              Class<T> resultType,
                                                                                              Class<E> errorType,
                                                                                              CusSupplier<E, ? extends X> exceptionSupplier,
                                                                                              final Map<String, ?> uriVariables) throws X, IOException {
        return orElseThrow(() -> restTemplate.exchange(this.baseUrl.concat(remoteApi.getPath()),
                remoteApi.getMethod(), entity(entity), resultType, uriVariables), errorType, exceptionSupplier, remoteApi);
    }

    /**
     * リクエスト
     *
     * @param remoteApi         APIの型
     * @param entity            リクエストボディ
     * @param uriQuery          urlクエリパラメータ
     * @param resultType        結果のオブジェクトタイプ
     * @param errorType         エラーオブジェクトタイプ
     * @param exceptionSupplier エラーリカバリー
     * @param uriVariables      パラメータ
     * @param <T>               結果オブジェクト
     * @param <E>               エラーオブジェクト
     * @param <X>               異常オブジェクト
     * @return 正常に戻った結果のオブジェクト
     * @throws X           異常オブジェクト
     * @throws IOException IO異常
     */
    public <T, E extends ErrorBean, X extends Throwable> Optional<T> postForEntityOrElseThrow(final RemoteApi remoteApi,
                                                                                              final HttpEntity<?> entity,
                                                                                              final String uriQuery,
                                                                                              Class<T> resultType,
                                                                                              Class<E> errorType,
                                                                                              CusSupplier<E, ? extends X> exceptionSupplier,
                                                                                              final Map<String, ?> uriVariables) throws X, IOException {
        return orElseThrow(() -> restTemplate.exchange(this.baseUrl.concat(remoteApi.getPath()).concat(uriQuery),
                remoteApi.getMethod(), entity(entity), resultType, uriVariables), errorType, exceptionSupplier, remoteApi);
    }

    /**
     * リクエスト処理の実行
     *
     * @param rest              請求方法
     * @param errorType         エラーオブジェクトタイプ
     * @param exceptionSupplier エラーリカバリー
     * @param <T>               結果オブジェクト
     * @param <E>               エラーオブジェクト
     * @param <X>               異常オブジェクト
     * @return 正常に戻った結果のオブジェクト
     * @throws X           異常オブジェクト
     * @throws IOException IO異常
     */
    private <T, E extends ErrorBean, X extends Throwable> Optional<T> orElseThrow(Supplier<ResponseEntity<T>> rest,
                                                                                  Class<E> errorType,
                                                                                  CusSupplier<E, ? extends X> exceptionSupplier,
                                                                                  final RemoteApi remoteApi) throws X, IOException {
        try {
            ResponseEntity<T> result = rest.get();
            return Optional.ofNullable(result.getBody());
        } catch (RestClientResponseException e) {
            log.warn("{} {} {} {} {}", remoteApi.toString(), remoteApi.getMethod().toString(), remoteApi.getPath(), e.getRawStatusCode(), e.getResponseBodyAsString());
            if (log.isDebugEnabled()) {
                log.debug(e.getMessage(), e);
            }

            E error = null;
            if(errorType != null) {
                error = om.readValue(e.getResponseBodyAsByteArray(), errorType);
                error.setHttpCode(e.getRawStatusCode());
            }

            X x = exceptionSupplier.get(error, e);
            if (x == null) {
                return Optional.empty();
            } else {
                throw x;
            }
        }
    }


    private HttpEntity<?> entity(HttpHeaders headers) {
        if (this.defaultHeaders == null && headers == null) {
            return HttpEntity.EMPTY;
        }

        HttpHeaders newHeaders = new HttpHeaders();

        if (this.defaultHeaders != null) {
            newHeaders.setAll(this.defaultHeaders.toSingleValueMap());
        }

        if (headers != null) {
            newHeaders.setAll(headers.toSingleValueMap());
        }

        if (log.isDebugEnabled()) {
            log.debug(newHeaders.toString());
        }

        return new HttpEntity<>(newHeaders);
    }

    private HttpEntity<?> entity(HttpEntity<?> entity) {
        if (this.defaultHeaders == null && entity == null) {
            return HttpEntity.EMPTY;
        }

        HttpHeaders newHeaders = new HttpHeaders();

        if (this.defaultHeaders != null) {
            newHeaders.setAll(this.defaultHeaders.toSingleValueMap());
        }

        if (entity != null && entity.getHeaders() != null) {
            newHeaders.setAll(entity.getHeaders().toSingleValueMap());
        }

        if (log.isDebugEnabled()) {
            log.debug(newHeaders.toString());
        }

        if (entity == null) {
            return new HttpEntity<>(newHeaders);
        } else {
            return new HttpEntity<>(entity.getBody(), newHeaders);
        }
    }
}