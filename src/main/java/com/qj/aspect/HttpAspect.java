package com.qj.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/4/9 0009.
 */
@Aspect     //切面拦截注解
@Component  //将该类引入到spring容器中
public class HttpAspect {

    private final static Logger LOGGER= LoggerFactory.getLogger(HttpAspect.class);

//    @Before("execution(public * com.qj.controller.GirlController.girlList(..))")  //最先执行
    @Pointcut("execution(public * com.qj.controller.GirlController.*(..))")  //定义公共的拦截路径
    public void log(){
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        LOGGER.info("----before----");
        //以下代码在获取http请求
        ServletRequestAttributes attributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        //得到请求url
        LOGGER.info("--- url={}",request.getRequestURI());
        //得到请求mehtod
        LOGGER.info("--- method={}",request.getMethod());
        //得到请求ip
        LOGGER.info("--- ip={}",request.getRemoteUser());
        //类方法 getDeclaringTypeName:类名  getName：类方法
        LOGGER.info("--- class_mehtod={}",joinPoint.getSignature().getDeclaringTypeName()
                +"."+joinPoint.getSignature().getName());
        //得到请求参数
        LOGGER.info("args={}",joinPoint.getArgs());
    }

    @After("log()")    //最后执行
    public void doAfter(){
        LOGGER.info("-----after----");
    }

    /**
     * 得到请求相应值
     * ruturning中的object与方法的入参相同且要匹配
     */
    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturning(Object object){
        //在Girl对象中重写toString方法，然后将值打印出来，
        LOGGER.info("--- response={}",object.toString());
    }
}
