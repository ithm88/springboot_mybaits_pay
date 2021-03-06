package com.item.bean;

import javax.xml.soap.Detail;
import java.io.Serializable;

/*
* 向前端返回信息封装
* @param<T> 可变类型 这个是泛型,
* */
public class ResultUser<T> implements Serializable {
    //返回的信息
    private String msg;
    //数据是否正常请求
    private boolean success;
    //具体返回的数据
    private T detail;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getDetail() {
        return detail;
    }

    public void setDetail(T detail) {
        this.detail = detail;
    }
}
