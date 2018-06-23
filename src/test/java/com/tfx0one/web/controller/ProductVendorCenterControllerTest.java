package com.tfx0one.web.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by 2fx0one on 2018/6/11.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductVendorCenterControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;
    private MockHttpSession session;

//    @Autowired
//    private TestRestTemplate testRestTemplate;

//    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        session = new MockHttpSession();

//        session.setAttribute("user", "user");
    }

    @Test
    public void setProductAttrOption() throws Exception {
//        //发登录请求
//        String username = "test";
//        String password = "123456";
//        FrontEndLoginUser user= new FrontEndLoginUser();
//        user.setUsername(username);
//        user.setPassword(password);
//        String requestJson = JSONObject.toJSONString(user);
//        ResultActions actions = mockMvc.perform(
//                MockMvcRequestBuilders
////                        .post("/auth/login").param("username", username).param("password", password)
//                        .post("/auth/login")
//                        .contentType(MediaType.APPLICATION_JSON_UTF8).content(requestJson)
//                        .accept(MediaType.APPLICATION_JSON_UTF8));
//
//        // 必须登录成功才有下一步
////        actions.andExpect(MockMvcResultMatchers.status().isOk());
//
//        //获取token 分步写清楚
//        MvcResult result = actions.andReturn();
//        String s = result.getResponse().getContentAsString();
//        JSONObject json = JSONObject.parseObject(s);
//        String token = (String) json.get("token");
//
//        System.out.println(token);
//
//
//        // 发送post请求 注意 json数据放在 content 中
//        String o = JSONObject.toJSONString(
//                new EShopProductSkuAttr().withAttrName("COLOR").withUserId(1).withSortOrder(3)
//        );
//        System.out.println("@TEST" + o);
//
//        ResultActions actionsPost = mockMvc.perform(
//                MockMvcRequestBuilders
//                        .post("/api/v1/shop/setProductAttrOption")
////                        .param("demo", o)
//                        .header("Authorization", "Bearer " + token)
//                        .content(o) //post json数据放这里！！！！
//                        .contentType(MediaType.APPLICATION_JSON_UTF8) //post json数据放这里！！！！
//                        .accept(MediaType.APPLICATION_JSON_UTF8));
//
//        actionsPost.andDo(MockMvcResultHandlers.print());
//        actionsPost.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getProductAttrOption() throws Exception {
        //发登录请求
//        String username = "test";
//        String password = "123456";
//        ResultActions actions = mockMvc.perform(
//                MockMvcRequestBuilders
//                        .post("/auth/login").param("username", username).param("password", password)
//                        .contentType(MediaType.APPLICATION_JSON_UTF8)
//                        .accept(MediaType.APPLICATION_JSON_UTF8));
//
//        // 必须登录成功才有下一步
////        actions.andExpect(MockMvcResultMatchers.status().isOk());
//
//        //获取token 分步写清楚
//        MvcResult result = actions.andReturn();
//        String s = result.getResponse().getContentAsString();
//        JSONObject json = JSONObject.parseObject(s);
//        String token = (String) json.get("token");
//
//        System.out.println(token);
//
//        //发送get请求
//        ResultActions actionsGet = mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/v1/shop/getProductAttrOption").param("productCategoryId", "1")
//                        .header("Authorization", "Bearer " + token)
//                        .contentType(MediaType.APPLICATION_JSON_UTF8)
//                        .accept(MediaType.APPLICATION_JSON_UTF8));
//
//        actionsGet.andDo(MockMvcResultHandlers.print());
////        actionsGet.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void createProduct() {
    }

    @Test
    public void modifyProduct() {
    }
}