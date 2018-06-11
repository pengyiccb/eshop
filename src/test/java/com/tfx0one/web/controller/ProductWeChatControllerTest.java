package com.tfx0one.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.tfx0one.web.model.Demo;
import com.tfx0one.web.model.EShopProductSkuAttr;
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
import com.tfx0one.web.model.EShopProduct;
import com.tfx0one.web.model.EShopProductSku;
import com.tfx0one.web.model.EShopProductAndSku;

import java.math.BigDecimal;
import java.util.*;

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
                        .get("/api/v1/wechat/productList").param("appId", "wxdda83d03c2d1521c")
                        .header("Authorization", "Bearer "+ token)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .accept(MediaType.APPLICATION_JSON_UTF8));

        actionsGet.andDo(MockMvcResultHandlers.print());
        actionsGet.andExpect(MockMvcResultMatchers.status().isOk());

        //发送get请求
        ResultActions actionsGet2 = mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/api/v1/wechat/productDetail").param("productId", "1")
                        .header("Authorization", "Bearer "+ token)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .accept(MediaType.APPLICATION_JSON_UTF8));

        actionsGet2.andExpect(MockMvcResultMatchers.status().isOk());
        actionsGet2.andDo(MockMvcResultHandlers.print());

        // 发送post请求 注意 json数据放在 content 中
//        String o = JSONObject.toJSONString(new Demo().withId(1).withCreateTime(new Date()).withMoney(1.23f).withName("demo1"));
//        System.out.println(o);
//
//        ResultActions actionsPost = mockMvc.perform(
//                MockMvcRequestBuilders
//                        .post("/demo/post")
////                        .param("demo", o)
//                        .header("Authorization", "Bearer "+ token)
//                        .content(o) //post json数据放这里！！！！
//                        .contentType(MediaType.APPLICATION_JSON_UTF8) //post json数据放这里！！！！
//                        .accept(MediaType.APPLICATION_JSON_UTF8));
//
//        actionsPost.andExpect(MockMvcResultMatchers.status().isOk());
//        actionsPost.andDo(MockMvcResultHandlers.print());

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

    @Test
    public void testInsertPro() throws Exception{
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


        EShopProductAndSku eshopProduct = new EShopProductAndSku();
        eshopProduct.product = new EShopProduct();
        eshopProduct.productSkuList = new ArrayList<EShopProductSku>() ;
        eshopProduct.product.withBrief("");
        eshopProduct.product.withContentDesc("");
        eshopProduct.product.withImgListUrl("");
        eshopProduct.product.withTitle("");
        eshopProduct.product.withKeyword("");
        eshopProduct.product.withPriceUnderline(new BigDecimal(1.34));
        eshopProduct.product.withSortOrder(new Byte("0"));
        eshopProduct.product.withIsOnSale(new Byte("0"));
        eshopProduct.product.withIsDelete(new Byte("0"));
        eshopProduct.product.withProductCategoryId(1);
        eshopProduct.product.withVendorUserId(0);
        eshopProduct.product.withSubtitle("");
        eshopProduct.product.withImgPrimaryUrl("");


        EShopProductSku eshopProductSku = new EShopProductSku();
        eshopProductSku.withUnitPrice(new BigDecimal(1.34));
        eshopProductSku.withCostPrice(new BigDecimal(1.34));
        eshopProductSku.withStockAmount(0);
        eshopProductSku.withStockSn(1);
        eshopProductSku.withAttrOption("qqq");
        eshopProductSku.withSaleAmount(0);
        eshopProduct.productSkuList.add(eshopProductSku);

        eshopProductSku = new EShopProductSku();
        eshopProductSku.withUnitPrice(new BigDecimal(1.34));
        eshopProductSku.withCostPrice(new BigDecimal(1.34));
        eshopProductSku.withStockAmount(0);
        eshopProductSku.withStockSn(1);
        eshopProductSku.withAttrOption("qqq");
        eshopProductSku.withSaleAmount(0);
        eshopProduct.productSkuList.add(eshopProductSku);

        // 发送post请求 注意 json数据放在 content 中
        String o = JSONObject.toJSONString(eshopProduct);
        System.out.println(o);

        ResultActions actionsPost = mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/api/v1/shop/createProduct")
//                        .param("demo", o)
                        .header("Authorization", "Bearer "+ token)
                        .content(o) //post json数据放这里！！！！
                        .contentType(MediaType.APPLICATION_JSON_UTF8) //post json数据放这里！！！！
                        .accept(MediaType.APPLICATION_JSON_UTF8));

        actionsPost.andDo(MockMvcResultHandlers.print());
        actionsPost.andExpect(MockMvcResultMatchers.status().isOk());
    }
}