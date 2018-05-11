package com.fundata.varena.fundatajavasdk.domain;

import org.apache.http.client.HttpClient;

import com.fundata.varena.fundatajavasdk.domain.entity.FunDataResult;
import com.fundata.varena.fundatajavasdk.domain.exception.ClientException;
import com.fundata.varena.fundatajavasdk.domain.http.Form;
import com.fundata.varena.fundatajavasdk.domain.http.Json;
import com.fundata.varena.fundatajavasdk.domain.http.RequsetConfig;

/**
 * @author baoyl
 * @created 2018/5/9
 */
public interface HttpClientOperation {

    public HttpClient getClient();

    /**
     * get请求
     * @param url
     * @return
     * @throws ClientException
     */
    public FunDataResult get(String url) throws ClientException;

    /**
     * get请求
     * @param url
     * @param form
     * @return
     * @throws ClientException
     */
    public FunDataResult get(String url, Form form) throws ClientException;

    /**
     * get请求
     * @param url
     * @param json
     * @return
     * @throws ClientException
     */
    public FunDataResult get(String url, Json json) throws ClientException;

    /**
     * get请求
     * @param url
     * @param form
     * @param config
     * @return
     * @throws ClientException
     */
    public FunDataResult get(String url, Form form, RequsetConfig config) throws ClientException;

    /**
     * get请求
     * @param url
     * @param json
     * @param config
     * @return
     * @throws ClientException
     */
    public FunDataResult get(String url, Json json, RequsetConfig config) throws ClientException;

    /**
     * post请求
     * @param url
     * @param form
     * @return
     * @throws ClientException
     */
    public FunDataResult post(String url, Form form) throws ClientException;

    /**
     * post请求
     * @param url
     * @param json
     * @return
     * @throws ClientException
     */
    public FunDataResult post(String url, Json json) throws ClientException;

    /**
     * post请求
     * @param url
     * @param form
     * @param config
     * @return
     * @throws ClientException
     */
    public FunDataResult post(String url, Form form, RequsetConfig config) throws ClientException;

    /**
     * post请求
     * @param url
     * @param json
     * @param config
     * @return
     * @throws ClientException
     */
    public FunDataResult post(String url, Json json, RequsetConfig config) throws ClientException;

}
