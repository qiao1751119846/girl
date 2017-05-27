package com.qj;

import com.qj.entity.Girl;
import com.qj.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Administrator on 2017/4/16 0016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {
    @Autowired
    private GirlService girlService;

    @Test
    public void findOneTest(){
        //根据id查询一条数据
        Girl girl=girlService.findOne(7);
        Assert.assertEquals(new Integer(15),girl.getAge());//比较年龄是否是15
    }
}
