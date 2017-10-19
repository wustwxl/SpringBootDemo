package com.example.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: F7687967
 * @date: 2017/10/19
 * @time: 上午 08:10
 * @description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserControllerTest {

    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }

    @Test
    public void testUserController() throws Exception {

        // 测试UserController
        RequestBuilder request = null;

        // 1、post提交一个user
        request = post("/users/user")
                .param("name", "lc")
                .param("age", "22");
        mvc.perform(request)
                .andExpect(content().string(equalTo("[{\"code\":1,\"info\": \"创建用户成功\",\"data\": {\"id\": null,\"name\": \"lc\",\"age\": 22}}]")));

        // 2、put修改id为9的user
        request = put("/users/9")
                .param("name", "wxl")
                .param("age", "20");
        mvc.perform(request)
                .andExpect(content().string(equalTo("[{\"code\":1,\"info\": \"修改指定用户详细信息成功\",\"data\": {\"id\": 9,\"name\": \"wxl\",\"age\": 20}}]")));

        // 3、get一个id为9的user
        request = get("/users/9");
        mvc.perform(request)
                .andExpect(content().string(equalTo("[{\"code\":1,\"info\": \"获取指定用户详细信息成功\",\"data\": {\"id\": 9,\"name\": \"wxl\",\"age\": 20}}]")));

        // 4、del删除name为wxl的user
        request = delete("/users/wxl");
        mvc.perform(request)
                .andExpect(content().string(equalTo("[{\"code\":1,\"info\": \"删除指定用户成功\",\"data\": \"wxl\"}]")));

        // 5、get查一下user数目，应该为0
        request = get("/users/userNum");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[{\"code\":1,\"info\": \"获取用户数目成功\",\"data\": 0}]")));

    }

}
