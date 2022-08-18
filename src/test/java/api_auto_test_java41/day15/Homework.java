package api_auto_test_java41.day15;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * @author qq音乐
 * @date 2022/7/23 - 1:46
 */
public class Homework {
    @Test
    public void login(){
        //1.登录
        String loginData="{\"principal\":\"java_auto\",\"credentials\":\"lemon123456\",\"appType\":3, \"loginType\":0 }";
        Response res = given().
                header("Content-Type","application/json").
                body(loginData).
                when().
                post("http://mall.lemonban.com:8107/login").
                then().
                log().all().extract().response();
        //1-1.获取token
        String token = res.jsonPath().get("access_token");

        //2、查询商品
        Response res2 = given().
                when().
                get("http://mall.lemonban.com:8107/search/searchProdPage?prodName=lemon").
                then().
                log().all().extract().response();
        Object prodId = res2.jsonPath().get("records[0].prodId");

        //3、进入到商品详情页
        Response res3 = given().
                when().
                get("http://mall.lemonban.com:8107/prod/prodInfo?prodId="+prodId).
                then().
                log().all().extract().response();
        //3-1.获取skuId
        int skuId = res3.jsonPath().get("skuList[0].skuId");
        System.out.println("skuId="+skuId);
        //获取shopID
        Object shopId = res3.jsonPath().get("shopId");
        System.out.println("shopId="+shopId);
        //4.添加购物车
        String shopCartData = "{\"basketId\":0,\"count\":1,\"prodId\":"+prodId+",\"shopId\":"+shopId+",\"skuId\":"+skuId+"}";
        given().
                header("Content-Type", "application/json").
                header("Authorization","bearer"+token).
                body(shopCartData).
                when().
                post("http://mall.lemonban.com:8107/p/shopCart/changeItem").
                then().
                log().all();
        //5.查询购物车


        //6.确认订单

        //6.下单
        String inputParam = "{\"orderShopParam\":[{\"remarks\":\"\",\"shopId\":1}],\"uuid\":\"ad9ecd67-83ee-48d3-92be-c1913f08f126\"}";
        given().
                header("Content-Type", "application/json").
                header("Authorization","bearer"+token).
                body(inputParam).
                when().
                post("http://mall.lemonban.com:8107/p/order/submit").
                then().
                log().all();

    }

}
