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
    detail(HttpMethod.GET, "/detail/{searchDateFrom}/{searchDateTo}/{next}/{accntNo}"),
    /**
     * ご利用規定
     */
    usageRegulation(HttpMethod.GET, "/usage_regulation"),
    /**
     * 申込情報入力
     */
    userInfo(HttpMethod.GET, "/user_info/{EMailAddress}"),
    /**
     * 暗証番号入力
     */
    cardPassword(HttpMethod.GET, "/card_password/{CdPswdId}"),
    /**
     * パスワード入力
     */
    loginPassword(HttpMethod.GET, "/login_password/{ISUserPassword}"),
    /**
     * 確認・登録
     */
    userRegistration(HttpMethod.GET, "/user_registration");

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
