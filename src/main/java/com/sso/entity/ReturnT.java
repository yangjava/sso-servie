package com.sso.entity;

import java.io.Serializable;

/**
 * 统一返回结果代码
 * @author yang
 * @param <T>
 */
public class ReturnT<T> implements Serializable {

    private static final long serialVersionUID = 5101502509789205348L;

    private Boolean success;

    private String msg;

    private T data;

    public ReturnT(String msg) {
        this.success=false;
        this.msg = msg;
    }

    public ReturnT(T data) {
        this.success=true;
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
