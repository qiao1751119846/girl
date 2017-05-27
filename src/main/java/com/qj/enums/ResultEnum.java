package com.qj.enums;

/**
 * Created by Administrator on 2017/4/16 0016.
 */
public enum ResultEnum {
    UNKONW_ERROR(-1,"未知错误"),
    SUCCESS(0,"成功"),
    PRIMARY_SCHOOL(100,"可能在上小学"),
    MIDDLE_SCHOOL(101,"可能在上初中"),
    senior_high_school(102,"可能在上高中")
    ;

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
