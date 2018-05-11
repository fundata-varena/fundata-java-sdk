package com.fundata.varena.fundatajavasdk.domain.entity;

import com.fundata.varena.fundatajavasdk.domain.BaseBean;

/**
 * fundata dota2请求结果实体
 * @author baoyl
 * @created 2018/5/9
 */
public class FunDataResult extends BaseBean {
    private static final long serialVersionUID = 2839929345094299990L;

    private Integer retcode;
    private String message;
    private Object data;

    public FunDataResult(){}

    public FunDataResult(Integer retcode, String message) {
        this.retcode = retcode;
        this.message = message;
    }

    public Integer getRetcode() {
        return retcode;
    }

    public void setRetcode(Integer retcode) {
        this.retcode = retcode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
