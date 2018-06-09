package com.tfx0one.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.tfx0one.web.model.Demo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by 2fx0one on 2018/5/31.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductWeChatControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;
    private MockHttpSession session;

//    @Autowired
//    private TestRestTemplate testRestTemplate;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        session = new MockHttpSession();

//        session.setAttribute("user", "user");
    }


    //注册测试。 记得进数据库修改相关信息。比如appId
    @Test public void testRegister() throws Exception {
        String username = "test";
        String password = "123456";
        mockMvc.perform(
                MockMvcRequestBuilders.post("/auth/register").param("username", username).param("password", password)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .accept(MediaType.APPLICATION_JSON_UTF8)
        )
                .andDo(MockMvcResultHandlers.print());
    }
    @Test public void testLoginAndDo() throws Exception{
        //发登录请求
        String username = "test";
        String password = "123456";
        ResultActions actions = mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/auth/login").param("username", username).param("password", password)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .accept(MediaType.APPLICATION_JSON_UTF8));

        // 必须登录成功才有下一步
        actions.andExpect(MockMvcResultMatchers.status().isOk());

        //获取token 分步写清楚
        MvcResult result = actions.andReturn();
        String s = result.getResponse().getContentAsString();
        JSONObject json = JSONObject.parseObject(s);
        String token = (String)json.get("token");

        System.out.println(token);

        //发送get请求
        ResultActions actionsGet = mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/demo/list")
                        .header("Authorization", "Bearer "+ token)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .accept(MediaType.APPLICATION_JSON_UTF8));

        actionsGet.andExpect(MockMvcResultMatchers.status().isOk());
        actionsGet.andDo(MockMvcResultHandlers.print());

        // 发送post请求 注意 json数据放在 content 中
        String o = JSONObject.toJSONString(new Demo().withId(1).withCreateTime(new Date()).withMoney(1.23f).withName("demo1"));
        System.out.println(o);

        ResultActions actionsPost = mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/demo/post")
//                        .param("demo", o)
                        .header("Authorization", "Bearer "+ token)
                        .content(o) //post json数据放这里！！！！
                        .contentType(MediaType.APPLICATION_JSON_UTF8) //post json数据放这里！！！！
                        .accept(MediaType.APPLICATION_JSON_UTF8));

        actionsPost.andExpect(MockMvcResultMatchers.status().isOk());
        actionsPost.andDo(MockMvcResultHandlers.print());

//        actions.andDo(new ResultHandler() {
//            @Override
//            public void handle(MvcResult result) throws Exception {
//
//            }
//        })

        //数据库要有名字 没有就运行上面的测试用例注册一个 testRegister
    }

    @Test
    public void testAuthAndGet() {
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("token","xxxxxx");
//        HttpEntity formEntity = new HttpEntity(headers);
//        String[] urlVariables = new String[]{"admin"};
//        ResponseEntity<ActResult> result = testRestTemplate.exchange("/test/getHeader?username={username}", HttpMethod.GET,formEntity,ActResult.class,urlVariables);
//        Assert.assertEquals(result.getBody().getCode(),0);
    }
    @Test
    public void list() throws Exception{
        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/v1/wechat/productList")
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .accept(MediaType.APPLICATION_JSON_UTF8)
                        .session(session).param("appId", "a")
                )
                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("abc"))
                .andDo(MockMvcResultHandlers.print());
    }
}