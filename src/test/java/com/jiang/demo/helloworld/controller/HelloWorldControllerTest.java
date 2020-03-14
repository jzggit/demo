package com.jiang.demo.helloworld.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("测试-用户登录信息")
@Slf4j
@ExtendWith(SpringExtension.class) //导入spring测试框架
@SpringBootTest
@AutoConfigureMockMvc
class HelloWorldControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Test
    void sayHello() throws Exception {
        log.info("开始-----");
        RequestBuilder req = MockMvcRequestBuilders.get("/jiang/hello");
        MvcResult result = mockMvc.perform(req).andReturn();
        int httpStatus = result.getResponse().getStatus();
        String content = result.getResponse().getContentAsString();
        log.info("Response: HttpStatus={},content={}", httpStatus, content);
        Assertions.assertTrue(httpStatus == HttpStatus.OK.value());
    }
}