package test;

import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

/**
 * @author luxi
 * @date 2021/10/25 0:39
 */
public class shopCart {
    public void add_shupCart(){
               String jsonData="{\"principal\":\"waiwai\",\"credentials\":\"lemon123456\",\"appType\":3,\"loginType\":0}";
        //post请求：json类型传参
        Response res=
                given().header("Content-Type","application/json").
                        body(jsonData).
                when().
                        post("http://mall.lemonban.com:8107/login").
                then().
                        log().all().
                        extract().response();
        //购物车请求
        Response res2=
                given().header("Content-Type","application/json").
                        body(jsonData).
                        when().
                        post("http://mall.lemonban.com:8107/login").
                        then().
                        log().all().
                        extract().response();
        int statusCode = res.getStatusCode();
        Assert.assertEquals(statusCode,2000);
        System.out.println("hello assertion");
        String nickName = res.jsonPath().get("nickName");
        Assert.assertEquals(nickName,"waiwai");
    }
}
