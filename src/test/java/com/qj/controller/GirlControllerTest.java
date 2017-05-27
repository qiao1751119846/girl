package com.qj.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/4/16 0016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc   //对API的测试
public class GirlControllerTest {
//    @Autowired
//    private GirlController girlController;
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void girlList() throws Exception {
//        girlController.girlList();
        mockMvc.perform(MockMvcRequestBuilders.get("/girls")) //get请求
                .andExpect(MockMvcResultMatchers.status().isOk())      //判断返回的状态码
                .andExpect(MockMvcResultMatchers.content().string("abc"));//得到返回内容，表示希望返回abc
    }

}