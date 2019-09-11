package com.lin.cangkusp.common.constant;

import java.io.Serializable;
import java.util.Map;

public class ConResult implements Serializable {
    private int code;
    private String msg;
    private Map<Object,Object> data;

    public static ConResult ok(){
        ConResult result = new ConResult(200, "success", null);
        return result;
    }

    public static ConResult error(){
        ConResult result = new ConResult(400, "error", null);
        return result;
    }

    public ConResult(int code, String msg, Map<Object, Object> data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public ConResult setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ConResult setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Map<Object, Object> getData() {
        return data;
    }

    public ConResult setData(Map<Object, Object> data) {
        this.data = data;
        return this;
    }
}
