package com.qj.entity;

/**
 * http请求返回的最外层对象  定义公共的返回消息类
 */
public class Result<T> {

    private Integer code;   //错误码

    private String msg;     //提示信息

    private T date;         //成功返回的对象内容

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }
}
