package com.qj.controller;

import com.qj.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 初识springboot
 */
@RestController
public class HelloController {

//    @Value("${cupSize}")
//    private String cupSize;
//
//    @Value("${age}")
//    private Integer age;
//
//    @Value("${content}")
//    private String content;
    @Autowired
    private GirlProperties girlProperties;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String say(){
        return "hello springboot,  cupSize:"+girlProperties.getCupSize()+
                ",age:"+girlProperties.getAge();
//        return "hello springboot,  cupSize:"+cupSize+",age:"+age+",content:"+content;
    }
}

