package com.qj.exception;

import com.qj.enums.ResultEnum;

/**
 * 自定义异常，此处需要继承RuntimeException，而不是Exception
 * 因为spring对RuntimeException才会进行事务回滚
 */
public class GirlException extends RuntimeException {
    private Integer code;


    public Integer getCode() {
        return code;
    }

//    public GirlException(Integer code,String message) {
//        super(message);
//        this.code=code;
//    }
public GirlException(ResultEnum resultEnum) {
    super(resultEnum.getMsg());
    this.code=resultEnum.getCode();
}

    public void setCode(Integer code) {
        this.code = code;
    }
}
