package com.fundata.varena.fundatajavasdk.fundata;

import java.net.URI;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.fundata.varena.fundatajavasdk.domain.HttpClientOperation;
import com.fundata.varena.fundatajavasdk.domain.entity.FunDataResult;
import com.fundata.varena.fundatajavasdk.domain.exception.ClientException;
import com.fundata.varena.fundatajavasdk.domain.http.EntityEnclosingGet;
import com.fundata.varena.fundatajavasdk.domain.http.Form;
import com.fundata.varena.fundatajavasdk.domain.http.Json;
import com.fundata.varena.fundatajavasdk.domain.http.RequsetConfig;
import com.google.gson.Gson;

/**
 * fundata http请求操作
 *
 * @author baoyl
 * @created 2018/5/9
 */
public class HttpClientTemplate implements HttpClientOperation {
    private static final String URL_START = "/";
    private String key;
    private String secret;
    private HttpClient client;
    private HttpHost host;
    private String rootPath;

    HttpClientTemplate(String host, String rootPath, String key, String secret) {
        this.key = key;
        this.secret = secret;
        this.rootPath = rootPath;
        this.client = HttpClientBuilder.create().build();
        this.host = new HttpHost(host);
    }

    @Override
    public HttpClient getClient() {
        return client;
    }

    @Override
    public FunDataResult get(String url) throws ClientException {
        return get(url, (Json) null);
    }

    @Override
    public FunDataResult get(String url, Form form) throws ClientException {
        return get(url, form, new FunDataRequestConfig(key, secret, rootPath + url, form == null ? null : form.merge()));
    }

    @Override
    public FunDataResult get(String url, Json json) throws ClientException {
        return get(url, json, new FunDataRequestConfig(key, secret, rootPath + url, json == null ? null : json.merge()));
    }

    @Override
    public FunDataResult get(String url, Form form, RequsetConfig config) throws ClientException {
        return get(url, null, form, config);
    }

    @Override
    public FunDataResult get(String url, Json json, RequsetConfig config) throws ClientException {
        return get(url, json, null, config);
    }

    public FunDataResult get(String url, Json json, Form form, RequsetConfig config) throws ClientException {
        url = handleUrl(url);
        HttpRequest get;
        if (json != null) {
            get = new EntityEnclosingGet(url);
        } else if (form == null || form.isEmpty()) {
            get = new HttpGet(url);
        } else {
            get = new HttpGet(buildURI(url, form));
        }
        return execute(get, json, null, config);
    }

    @Override
    public FunDataResult post(String url, Form form) throws ClientException {
        return post(url, form, new FunDataRequestConfig(key, secret, rootPath + url, form == null ? null : form.merge()));
    }

    @Override
    public FunDataResult post(String url, Json json) throws ClientException {
        return post(url, json, new FunDataRequestConfig(key, secret, rootPath + url, json == null ? null : json.merge()));
    }

    @Override
    public FunDataResult post(String url, Form form, RequsetConfig config) throws ClientException {
        return post(url, null, form, config);
    }

    @Override
    public FunDataResult post(String url, Json json, RequsetConfig config) throws ClientException {
        return post(url, json, null, config);
    }

    public FunDataResult post(String url, Json json, Form form, RequsetConfig config) throws ClientException {
        url = handleUrl(url);
        return execute(new HttpPost(url), json, form, config);
    }

    private String handleUrl(String url) {
        if (StringUtils.isBlank(url)) {
            url = "";
        } else if (!url.startsWith(URL_START)) {
            url = "/" + url;
        }
        return host + rootPath + url;
    }

    private URI buildURI(String url, Form form) throws ClientException {
        try {
            return new URIBuilder(url).addParameters(form.values2NVP()).build();
        } catch (Exception e) {
            throw new ClientException(ClientException.DEFAULT_CLIENT_EXCEPTION_CODE, e);
        }
    }

    private FunDataResult execute(HttpRequest request, Json json, Form form, RequsetConfig config) throws ClientException {
        try {
            if (json != null && !json.isEmpty()) {
                ((HttpEntityEnclosingRequest) request).setEntity(new StringEntity(json.toString(), "utf-8"));
            }
            if (form != null && !form.isEmpty()) {
                ((HttpEntityEnclosingRequest) request).setEntity(new UrlEncodedFormEntity(form.values(), "utf-8"));
            }
            if (config != null) {
                config.config(request);
            }
            HttpUriRequest httpUriRequest = (HttpUriRequest) request;
            return parseResult(client.execute(httpUriRequest));
        } catch (Exception e) {
            throw new ClientException(ClientException.DEFAULT_CLIENT_EXCEPTION_CODE, e);
        } finally {
            try {
                ((HttpRequestBase) request).releaseConnection();
            } catch (Exception e) {

            }
        }
    }

    private FunDataResult parseResult(HttpResponse response) throws Exception {
        String result = response.getEntity() == null ? null : EntityUtils.toString(response.getEntity(), "UTF-8");
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode >= HttpStatus.SC_OK && statusCode <= HttpStatus.SC_MULTI_STATUS) {
            return new Gson().fromJson(result, FunDataResult.class);
        }
        return FunDataResult.of(statusCode, "request error");
    }

}