package com.tfx0one.web.controller;

import org.junit.Before;
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
    @Test
    public void testRegister() throws Exception {
//        String username = "test";
//        String password = "123456";
//        mockMvc.perform(
//                MockMvcRequestBuilders.post("/JwtAuth/register").param("username", username).param("password", password)
//                        .contentType(MediaType.APPLICATION_JSON_UTF8)
//                        .accept(MediaType.APPLICATION_JSON_UTF8)
//        )
//                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testLoginAndDo() throws Exception {
        //发登录请求
//        String username = "test";
//        String password = "123456";
//        ResultActions actions = mockMvc.perform(
//                MockMvcRequestBuilders
//                        .post("/JwtAuth/login").param("username", username).param("password", password)
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
//                        .get("/api/v1/wechat/productList").param("appId", "wxdda83d03c2d1521c")
//                        .header("Authorization", "Bearer " + token)
//                        .contentType(MediaType.APPLICATION_JSON_UTF8)
//                        .accept(MediaType.APPLICATION_JSON_UTF8));
//
//        actionsGet.andDo(MockMvcResultHandlers.print());
////        actionsGet.andExpect(MockMvcResultMatchers.status().isOk());
//
//        //发送get请求
//        ResultActions actionsGet2 = mockMvc.perform(
//                MockMvcRequestBuilders
//                        .get("/api/v1/wechat/productDetail").param("productId", "1")
//                        .header("Authorization", "Bearer " + token)
//                        .contentType(MediaType.APPLICATION_JSON_UTF8)
//                        .accept(MediaType.APPLICATION_JSON_UTF8));
//
////        actionsGet2.andExpect(MockMvcResultMatchers.status().isOk());
//        actionsGet2.andDo(MockMvcResultHandlers.print());

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
    public void list() throws Exception {
//        mockMvc.perform(
//                MockMvcRequestBuilders.get("/api/v1/wechat/productList")
//                        .contentType(MediaType.APPLICATION_JSON_UTF8)
//                        .accept(MediaType.APPLICATION_JSON_UTF8)
//                        .session(session).param("appId", "a")
//        )
////                .andExpect(MockMvcResultMatchers.status().isOk())
////                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("abc"))
//                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testInsertPro() throws Exception {
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
//
//        EShopProduct eshopProduct = new EShopProduct();
//        eshopProduct.withBrief("");
//        eshopProduct.withContentDesc("");
//        eshopProduct.withImgListUrl("");
//        eshopProduct.withTitle("");
//        eshopProduct.withKeyword("");
//        eshopProduct.withPriceUnderline(new BigDecimal(1.34));
//        eshopProduct.withSortOrder(new Byte("0"));
//        eshopProduct.withIsOnSale(new Byte("0"));
//        eshopProduct.withIsDelete(new Byte("0"));
//        eshopProduct.withProductCategoryId(1);
//        eshopProduct.withVendorUserId(0);
//        eshopProduct.withSubtitle("");
//        eshopProduct.withImgPrimaryUrl("");
//
//        List list = new ArrayList();
//        EShopProductSku eshopProductSku = new EShopProductSku();
//        eshopProductSku.withUnitPrice(new BigDecimal(1.34));
//        eshopProductSku.withCostPrice(new BigDecimal(1.34));
//        eshopProductSku.withStockAmount(0);
//        eshopProductSku.withAttrOption("qqq");
//        eshopProductSku.withSaleAmount(0);
//        list.add(eshopProductSku);
//
//        EShopProductSku eshopProductSku1 = new EShopProductSku();
//        eshopProductSku1.withUnitPrice(new BigDecimal(1.34));
//        eshopProductSku1.withCostPrice(new BigDecimal(1.34));
//        eshopProductSku1.withStockAmount(0);
//        eshopProductSku1.withAttrOption("qqq");
//        eshopProductSku1.withSaleAmount(0);
//        list.add(eshopProductSku1);
//
//
//        Map<String, Object> map = new HashMap<>();
//        map.put("product", eshopProduct);
//        map.put("skuList", list);
//
//        // 发送post请求 注意 json数据放在 content 中
//        String o = JSONObject.toJSONString(map);
//        System.out.println(o);
//
//        ResultActions actionsPost = mockMvc.perform(
//                MockMvcRequestBuilders
//                        .post("/api/v1/shop/createProduct")
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
    @SuppressWarnings("unchecked")
    public void testUpdatePro() throws Exception {
        //发登录请求
//        String username = "test";
//        String password = "123456";
//        ResultActions actions = mockMvc.perform(
//                MockMvcRequestBuilders
//                        .post("/JwtAuth/login").param("username", username).param("password", password)
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
//
//        EShopProduct eshopProduct = new EShopProduct();
//        eshopProduct.withId(14);
//        eshopProduct.withBrief("111");
//        eshopProduct.withContentDesc("222");
//        eshopProduct.withImgListUrl("333");
//        eshopProduct.withTitle("44");
//        eshopProduct.withKeyword("555");
//        eshopProduct.withPriceUnderline(new BigDecimal(2.34));
//        eshopProduct.withSortOrder(new Byte("1"));
//        eshopProduct.withIsOnSale(new Byte("1"));
//        eshopProduct.withIsDelete(new Byte("1"));
//        eshopProduct.withProductCategoryId(2);
//        eshopProduct.withVendorUserId(1);
//        eshopProduct.withSubtitle("222");
//        eshopProduct.withImgPrimaryUrl("22");
//
//        List list = new ArrayList();
//        EShopProductSku eshopProductSku = new EShopProductSku();
//        eshopProductSku.withId(12);
//        eshopProductSku.withProductId(eshopProduct.getId());
//        eshopProductSku.withUnitPrice(new BigDecimal(2.34));
//        eshopProductSku.withCostPrice(new BigDecimal(2.34));
//        eshopProductSku.withStockAmount(10);
//        eshopProductSku.withAttrOption("rrr");
//        eshopProductSku.withSaleAmount(100);
//        list.add(eshopProductSku);
//
//        EShopProductSku eshopProductSku1 = new EShopProductSku();
//        eshopProductSku1.withId(13);
//        eshopProductSku1.withProductId(eshopProduct.getId());
//        eshopProductSku1.withUnitPrice(new BigDecimal(2.34));
//        eshopProductSku1.withCostPrice(new BigDecimal(2.34));
//        eshopProductSku1.withStockAmount(100);
//        eshopProductSku1.withAttrOption("yyy");
//        eshopProductSku1.withSaleAmount(200);
//        list.add(eshopProductSku1);
//
//
//        Map<String, Object> map = new HashMap<>();
//        map.put("product", eshopProduct);
//        map.put("skuList", list);
//
//        // 发送post请求 注意 json数据放在 content 中
//        String o = JSONObject.toJSONString(map);
//        System.out.println(o);
//
//        ResultActions actionsPost = mockMvc.perform(
//                MockMvcRequestBuilders
//                        .post("/api/v1/shop/modifyProduct")
////                        .param("demo", o)
//                        .header("Authorization", "Bearer " + token)
//                        .content(o) //post json数据放这里！！！！
//                        .contentType(MediaType.APPLICATION_JSON_UTF8) //post json数据放这里！！！！
//                        .accept(MediaType.APPLICATION_JSON_UTF8));
//
//        actionsPost.andDo(MockMvcResultHandlers.print());
//        actionsPost.andExpect(MockMvcResultMatchers.status().isOk());
    }
}