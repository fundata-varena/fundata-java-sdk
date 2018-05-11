package com.fundata.varena.fundatajavasdk.fundata;

import com.fundata.varena.fundatajavasdk.domain.entity.FunDataResult;

/**
 * fundata执行器
 * @author baoyl
 * @created 2018/5/10
 */
public class FunDataExector {
    HttpClientTemplate clientOperation;

    FunDataExector(String key, String secret) {
        this.clientOperation = new HttpClientTemplate("api.varena.com", "/data-service/dota2", key, secret);
    }

}
