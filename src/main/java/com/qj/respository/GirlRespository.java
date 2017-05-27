package com.qj.respository;

import com.qj.entity.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * JpaRepository<Girl,Integer>   Girl:继承的类，Integer：该类的id类型
 * 对应数据库表的操作的类
 */
public interface GirlRespository extends JpaRepository<Girl,Integer> {
    //通过年龄查询，方法名findBy必须这样写
    public List<Girl> findByAge(Integer age);
}
