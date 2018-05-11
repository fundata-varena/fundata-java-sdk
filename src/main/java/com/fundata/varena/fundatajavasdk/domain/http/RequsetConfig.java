package com.fundata.varena.fundatajavasdk.domain.http;

import org.apache.http.HttpRequest;

/**
 * @author baoyl
 * @created 2018/5/9
 */
public interface RequsetConfig {
    public void config(HttpRequest request);
}
