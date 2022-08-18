package api_auto_test_java41.day18;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import test.common.BaseTest;

import static io.restassured.RestAssured.given;

/**
 * @author qq音乐
 * @date 2022/7/23 - 1:46
 */
public class Homework {

    @Test
    public void placeOrderPay(){
        //造测试数据（商品）
        //1、登录
        String data="{\"principal\":\"java_auto\",\"credentials\":\"lemon123456\",\"appType\":3, \"loginType\":0 }";
        Response res1 = given().log().all().
                header("Content-Type","application/json").
                body(data).
                when().
                post("http://mall.lemonban.com:8107/login").
                then().
                log().all().extract().response();
        //解析获取登录返回的token
        Object token = res1.jsonPath().get("access_token");

        //2、查询商品
        Response res2 = given().log().all().
                when().
                get("http://mall.lemonban.com:8107/search/searchProdPage?prodName=冰墩墩").
                then().
                log().all().extract().response();
        Object prodId = res2.jsonPath().get("records[0].prodId");

        //3、进入到商品详情页
        Response res3 = given().log().all().
                when().
                get("http://mall.lemonban.com:8107/prod/prodInfo?prodId="+prodId).
                then().
                log().all().extract().response();
        //获取shopId
        Object shopId = res3.jsonPath().get("shopId");
        //获取skuId
        Object skuId = res3.jsonPath().get("skuList[0].skuId");

        //4、添加购物车
        Response res4 = given().log().all().
                header("Content-Type","application/json").
                header("Authorization","bearer"+token).
                body("{\"basketId\":0,\"count\":1,\"prodId\":\""+prodId+"\",\"shopId\":"+shopId+",\"skuId\":"+skuId+"}").
                when().
                post("http://mall.lemonban.com:8107/p/shopCart/changeItem").
                then().
                log().all().extract().response();

        //5、查询购物车
        Response res5 = given().log().all().
                header("Content-Type","application/json").
                header("Authorization","bearer"+token).
                body("[]").
                when().
                post("http://mall.lemonban.com:8107/p/shopCart/info").
                then().
                log().all().extract().response();
        Object basketId = res5.jsonPath().get("shopCartItemDiscounts[0].shopCartItems[0].basketId[0]");

        //6、确认订单
        String jsonData6 = "{\"addrId\":0,\"basketIds\":["+basketId+"],\"couponIds\":[],\"isScorePay\":0," +
                "\"userChangeCoupon\":0,\"userUseScore\":0,\"uuid\":\"c899b5a9-281b-4dd2-84e1-f521a2d3843f\"}";
        Response res6 = given().log().all().
                header("Content-Type","application/json").
                header("Authorization","bearer"+token).
                body(jsonData6).
                when().
                post("http://mall.lemonban.com:8107/p/order/confirm").
                then().
                log().all().extract().response();

        //7、提交订单
        String jsonData7 = "{\"orderShopParam\":[{\"remarks\":\"\",\"shopId\":"+shopId+"}],\"uuid\":\"c899b5a9-281b-4dd2-84e1-f521a2d3843f\"}";
        Response res7 = given().log().all().
                header("Content-Type","application/json").
                header("Authorization","bearer"+token).
                body(jsonData7).
                when().
                post("http://mall.lemonban.com:8107/p/order/submit").
                then().
                log().all().extract().response();
    }


}
