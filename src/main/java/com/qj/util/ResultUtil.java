package com.qj.util;

import com.qj.entity.Result;

/**
 * Created by Administrator on 2017/4/16 0016.
 */
public class ResultUtil {
    //成功
    public static Result success(Object object){
        Result result=new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setDate(object);
        return result;
    }

    public static Result success(){
        return success(null);
    }

    //失败
    public static Result error(Integer code,String msg){
        Result result=new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
