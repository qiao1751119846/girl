package com.qj.service;

import com.qj.enums.ResultEnum;
import com.qj.exception.GirlException;
import com.qj.respository.GirlRespository;
import com.qj.entity.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/4/9 0009.
 */
@Service
public class GirlService {

    @Autowired
    private GirlRespository girlRespository;

    /**
     * 利用事物控制sql的同步执行
     */
    @Transactional
    public void insertTwo(){
        Girl girl=new Girl();
        girl.setCupSize("A");
        girl.setAge(19);
        girlRespository.save(girl);

        Girl girl01=new Girl();
        girl01.setCupSize("B");
        girl01.setAge(20);
        girlRespository.save(girl01);
    }

    public void getAge(Integer id) throws Exception {
        Girl girl=girlRespository.findOne(id);
        Integer age=girl.getAge();
        if(age<10){
//            throw  new Exception("可能还在上小学");
//            throw  new GirlException(100,"可能还在上小学");
            throw  new GirlException(ResultEnum.PRIMARY_SCHOOL);

        }else if(age>10&&age<16){
//            throw  new Exception("可能在初中了");
//            throw  new GirlException(101,"可能在初中了");
            throw  new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
//        throw new Exception("应该已经在上高中了");
//        throw new GirlException(102,"应该已经在上高中了");
        throw new GirlException(ResultEnum.senior_high_school);
    }

    /**
     * 通过id查询一条信息
     */
    public Girl findOne(Integer id){
        return girlRespository.findOne(id);
    }
}
