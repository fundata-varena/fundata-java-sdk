package com.fundata.varena.fundatajavasdk.domain.http;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpRequest;

import com.fundata.varena.fundatajavasdk.utils.FunDataUtils;

/**
 * fundata dota2接口请求配置
 * @author baoyl
 * @created 2018/5/9
 */
public class FunDataRequestConfig implements RequsetConfig {
    private String key;
    private String secret;
    private String uri;
    private String params;

    public FunDataRequestConfig(String key, String secret, String uri, String params) {
        this.key = key;
        this.secret = secret;
        this.uri = uri;
        this.params = params;
    }

    public void config(HttpRequest request) {
        String nonce = FunDataUtils.randomCode(FunDataUtils.randomLength(5, 10));
        String time = FunDataUtils.getCurrentTime();
        String sign = FunDataUtils.makeMd5(StringUtils.join(new String[]{nonce, secret, time, uri, params}, "|"));
        request.setHeader("Content-Type", "application/json; charset=utf-8");
        request.setHeader("Accept-ApiKey", key);
        request.setHeader("Accept-ApiNonce", nonce);
        request.setHeader("Accept-ApiTime", time);
        request.setHeader("Accept-ApiSign", sign);
    }
}
