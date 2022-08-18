package api_auto_test_java41.day18;

import api_auto_test_java41.day16.RequestTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;


/**
 * @author qq音乐
 * @date 2022/7/26 - 0:20
 * 下单接口请求
 */
public class SubmitOrderTest extends RequestTest {
    @Test
    public void placeOrder(){
        //1.登录
        String loginData="{\"principal\":\"java_auto\",\"credentials\":\"lemon123456\",\"appType\":3, \"loginType\":0 }";
        Map<String, Object> map1 = new HashMap<String,Object>();
        map1.put("Content-Type","application/json");
        Response res1 = request("post","http://mall.lemonban.com:8107/login",map1,loginData);
        Object token = res1.jsonPath().get("access_token");

       //2.查询商品
        Response res2 = request("get","http://mall.lemonban.com:8107/search/searchProdPage?",null,"prodName=lemon");
        Object prodId = res2.jsonPath().get("records[0].prodId");

        //3、进入到商品详情页
       Response res3 = given().
                when().
                get("http://mall.lemonban.com:8107/prod/prodInfo?prodId="+prodId).
                then().
                log().all().extract().response();

/*        Response res3 = request("get","http://mall.lemonban.com:8107/prod/prodInfo?,null,prodId);*/
        //获取shopId
        Object shopId = res3.jsonPath().get("shopId");
        //获取skuId
        Object skuId = res3.jsonPath().get("skuList[0].skuId");


        //4、添加购物车
/*       Response res4 = given().log().all().
                header("Content-Type","application/json").
                header("Authorization","bearer"+token).
                body("{\"basketId\":0,\"count\":1,\"prodId\":\""+prodId+"\",\"shopId\":"+shopId+",\"skuId\":"+skuId+"}").
                when().
                post("http://mall.lemonban.com:8107/p/shopCart/changeItem").
                then().
                log().all().extract().response();*/

       String shopCartData = "{\"basketId\":0,\"count\":1,\"prodId\":"+prodId+",\"shopId\":"+shopId+",\"skuId\":"+skuId+"}";
        Map<String, Object> map4 = new HashMap<String,Object>();
        map4.put("Content-Type","application/json");
        map4.put("Authorization","bearer"+token);
        Response res5 = request("post","http://mall.lemonban.com:8107/p/shopCart/changeItem",map4,shopCartData);
        System.out.println("=========================================");

      //5、查询购物车
        Response res6 = given().log().all().
                header("Content-Type","application/json").
                header("Authorization","bearer"+token).
                body("[]").
                when().
                post("http://mall.lemonban.com:8107/p/shopCart/info").
                then().
                log().all().extract().response();
        Object basketId = res5.jsonPath().get("shopCartItemDiscounts[0].shopCartItems[0].basketId[0]");

/*        //6、确认订单
        String jsonData6 = "{\"addrId\":0,\"basketIds\":[\"+basketId+\"],\"couponIds\":[],\"isScorePay\":0," +
                "\"userChangeCoupon\":0,\"userUseScore\":0,\"uuid\":\"c899b5a9-281b-4dd2-84e1-f521a2d3843f\"}";
        Response res7 = given().log().all().
                header("Content-Type","application/json").
                header("Authorization","bearer"+token).
                body(jsonData6).
                when().
                post("http://mall.lemonban.com:8107/p/order/confirm").
                then().
                log().all().extract().response();*/


/*        //7、提交订单
        //先去把请求头信息保存到map结构中
        Map<String,Object> map2 = new HashMap<String,Object>();
        map2.put("Content-Type","application/json");
        map2.put("Authorization","bearer"+token);
        String jsonData7 = "{\"orderShopParam\":[{\"remarks\":\"\",\"shopId\":"+shopId+"}],\"uuid\":\"c899b5a9-281b-4dd2-84e1-f521a2d3843f\"}";
        Response res8 = given().log().all().
                headers(map2).
                body(jsonData7).
                when().
                post("http://mall.lemonban.com:8107/p/order/submit").
                then().
                log().all().extract().response();*/
    }
    }


