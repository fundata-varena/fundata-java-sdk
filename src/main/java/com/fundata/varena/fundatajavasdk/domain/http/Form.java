package com.fundata.varena.fundatajavasdk.domain.http;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.fundata.varena.fundatajavasdk.domain.BaseBean;

/**
 * http 表单
 * @author baoyl
 * @created 2018/5/9
 */
public class Form extends BaseBean implements Iterable<BasicNameValuePair> {
    private static final long serialVersionUID = -8522258723892506895L;
    /** 参数集合 */
    private List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();

    public Iterator<BasicNameValuePair> iterator() {
        return params.iterator();
    }

    public int size() {
        return params.size();
    }

    public boolean isEmpty() {
        return params.isEmpty();
    }

    public boolean contains(BasicNameValuePair param) {
        return params.contains(param);
    }

    public boolean containsAll(Collection<?> params) {
        return this.params.containsAll(params);
    }

    public BasicNameValuePair get(int index) {
        return params.get(index);
    }

    public Form add(String name, Integer value) {
        return add(name, value.toString());
    }

    public Form add(String name, Long value) {
        return add(name, value.toString());
    }

    public Form add(String name, Double value) {
        return add(name, value.toString());
    }

    public Form add(String name, Boolean value) {
        return add(name, value.toString());
    }

    public Form add(String name, String value) {
        params.add(new BasicNameValuePair(name, value));
        return this;
    }

    public Form add(String name, BigDecimal value) {
        return add(name, value.toString());
    }

    public Form add(String name, Date value) {
        return add(name, value.getTime());
    }

    public Form addNull(String name) {
        return add(name, (String)null);
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

    public List<BasicNameValuePair> values() {
        return params;
    }

    public List<NameValuePair> values2NVP() {
        List<NameValuePair> result = new ArrayList<NameValuePair>();
        for (final BasicNameValuePair param : params) {
            result.add(new NameValuePair() {
                public String getName() {
                    return param.getName();
                }

                public String getValue() {
                    return param.getValue();
                }
            });
        }
        return result;
    }

    @Override
    public String toString() {
        Object value = value();
        return value == null ? "()" : value.toString();
    }

    public String merge() {
        Collections.sort(params, new Comparator<BasicNameValuePair>() {
            public int compare(BasicNameValuePair o1, BasicNameValuePair o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        List<String> merges = new ArrayList<String>();
        for (BasicNameValuePair param : params) {
            merges.add(param.getName() + "=" + param.getValue());
        }
        return StringUtils.join("&", merges);
    }
}
