package com.qj.controller;

import com.qj.entity.Result;
import com.qj.respository.GirlRespository;
import com.qj.service.GirlService;
import com.qj.entity.Girl;
import com.qj.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 请求资源控制类
 * RestController标签包含了Controller和responseBody标签
 */
@RestController
//@RequestMapping("/girl")
public class GirlController {

    @Autowired
    private GirlRespository girlRespository;

    @Autowired
    private GirlService girlService;

    /**
     * get请求查询数据
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        //findAll方法查询所有数据
        return girlRespository.findAll();
    }

    /**
     * post请求，添加数据
     * @return
     */
    @PostMapping(value = "/girlAdd")
//    public Girl girlAdd(@RequestParam("cupSize") String cupSize,@RequestParam("age") Integer age){
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult)
    {
        //注解验证错误消息处理
        if(bindingResult.hasErrors()){
//            System.out.println(bindingResult.getFieldError().getDefaultMessage());//输出错误信息
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());
        return  ResultUtil.success(girlRespository.save(girl));//sava方法用于添加或者更新数据
    }

    /*
    get请求查询一条数据
     */
    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id){
        //findOne方法  根据id查询
        return girlRespository.findOne(id);
    }

    /**
     * 根据年龄查询数据库
     */
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlList(@PathVariable("age") Integer age){
        return girlRespository.findByAge(age);
    }

    /**
     * put请求更新一条数据
     */
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age){
        Girl girl=new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);
        girl.setId(id);
        return girlRespository.save(girl);
    }

    /*
    delete请求方式，删除一条数据
     */
    @DeleteMapping(value = "/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id){
        girlRespository.delete(id);
    }

    @PostMapping(value = "/girls/two")
    public void girlTwo(){
        girlService.insertTwo();
    }

    /**
     * 对女生的年龄就行判断，0-10/10-16划分
     */
    @GetMapping(value = "/getGirlAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        girlService.getAge(id);
    }

}
