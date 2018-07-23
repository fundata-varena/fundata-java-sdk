package com.fundata.varena.fundatajavasdk.fundata;

import com.fundata.varena.fundatajavasdk.domain.entity.FunDataResult;
import com.fundata.varena.fundatajavasdk.domain.exception.ClientException;
import com.fundata.varena.fundatajavasdk.domain.http.Form;
import com.fundata.varena.fundatajavasdk.domain.http.Json;

/**
 * fundata执行器
 *
 * @author baoyl
 * @created 2018/5/10
 */
public class FunDataExector {
    protected HttpClientTemplate clientOperation;

    public FunDataExector(String key, String secret, String rootPath) {
        this.clientOperation = new HttpClientTemplate("api.varena.com", rootPath, key, secret);
    }

    public FunDataResult commonForm(String url, Form form) throws ClientException {
        return this.clientOperation.get(url, form);
    }

    public FunDataResult commonJson(String url, Json json) throws ClientException {
        return this.clientOperation.get(url, json);
    }

}
