package com.qj.handle;

import com.qj.entity.Result;
import com.qj.exception.GirlException;
import com.qj.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 该类用于捕获返回的异常
 */
@ControllerAdvice
public class ExceptionHandle {

    private static final Logger LOGGER= LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)  //制定该方法捕获返回什么类型的异常
    @ResponseBody
    public Result handle(Exception e){
        //判断，如果该异常是我们自定义的GirlException异常，就进行处理
        if(e instanceof GirlException){
            GirlException girlException= (GirlException) e;
            return ResultUtil.error(girlException.getCode(),girlException.getMessage());
        }else {
            LOGGER.error("系统异常:{}",e);
            return ResultUtil.error(-1,"未知错误");
        }
//        return ResultUtil.error(100,e.getMessage());//得到异常消息，并将其打包成我们希望看到的格式返回给前台
    }
}
