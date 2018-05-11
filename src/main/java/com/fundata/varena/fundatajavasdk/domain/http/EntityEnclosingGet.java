package com.fundata.varena.fundatajavasdk.domain.http;

import java.net.URI;

import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;

/**
 * @author baoyl
 * @created 2018/5/9
 */
public class EntityEnclosingGet extends HttpEntityEnclosingRequestBase {
    public EntityEnclosingGet() {
    }

    public EntityEnclosingGet(URI uri) {
        setURI(uri);
    }

    public EntityEnclosingGet(String uri) {
        setURI(URI.create(uri));
    }

    @Override
    public String getMethod() {
        return HttpGet.METHOD_NAME;
    }
}
