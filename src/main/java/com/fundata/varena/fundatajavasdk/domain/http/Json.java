package com.fundata.varena.fundatajavasdk.domain.http;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.fundata.varena.fundatajavasdk.domain.BaseBean;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.Gson;

/**
 * http Json
 * @author baoyl
 * @created 2018/5/9
 */
public class Json extends BaseBean implements Iterable<Object> {
    private static final long serialVersionUID = 2792821093049194375L;

    private static final String CONTENT_TYPE = "application/json";
    private List<Object> params = Lists.newArrayList();

    public Json(Object... params) {
        Collections.addAll(this.params, params);
    }

    @Override
    public Iterator<Object> iterator() {
        return params.iterator();
    }

    public int size() {
        return params.size();
    }

    public boolean isEmpty() {
        return params.isEmpty();
    }

    public boolean contains(Object param) {
        return params.contains(param);
    }

    public boolean containsAll(Collection<?> params) {
        return this.params.containsAll(params);
    }

    public Object get(int index) {
        return params.get(index);
    }

    public Json add(Object param) {
        params.add(param);
        return this;
    }

    public Json addAll(Collection<?> params) {
        this.params.addAll(params);
        return this;
    }

    public Json add(String key, Object value) {
        Map<String, Object> param = Maps.newHashMap();
        param.put(key, value);
        return add(param);
    }

    @SuppressWarnings("unchecked")
    public Json put(String key, Object value) {
        if(isEmpty() || !(get(size()-1) instanceof Map)) {
            return add(key, value);
        }
        ((Map<String, Object>)get(size()-1)).put(key, value);
        return this;
    }

    @SuppressWarnings("unchecked")
    public Json putAll(Map<? extends String, ?> values) {
        if(isEmpty() || !(get(size()-1) instanceof Map)) {
            return add((Map<String, Object>)values);
        }
        ((Map<String, Object>)get(size()-1)).putAll(values);
        return this;
    }

    public Object value() {
        switch (size()) {
            case 0:
                return null;
            case 1:
                return params.get(0);
            default:
                return params;
        }
    }

    public List<Object> values() {
        return params;
    }

    public String contentType() {
        return CONTENT_TYPE;
    }

    @Override
    public String toString() {
        return new Gson().toJson(value());
    }

    public String merge() {
        //TODO

        return null;
    }
}
