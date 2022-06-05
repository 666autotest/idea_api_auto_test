package test;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * @author luxi
 * @date 2021/10/25 0:39
 */
public class ResponseTest {
    //ERP系统post请求：json类型传参
    @Test
    public void test01() {
        String jsonData = "{\"principal\":\"waiwai\",\"credentials\":\"lemon123456\",\"appType\":3,\"loginType\":0}";
        Response res =
                given().
                        header("Content-Type", "application/json").
                        body(jsonData).
                        when().
                        post("http://mall.lemonban.com:8107/login").
                        then().
                        log().all().
                        extract().response();
        //1.获取响应状态码
        System.out.println(res.getStatusCode());

        //2.获取响应状态码
        System.out.println(res.time());

        //3.获取接口相应头信息
        //System.out.println(res.getHeaders());
        //4.获取Content-Type信息
        System.out.println(res.getHeader("Content-Type"));
        //5.获取set-cookie信息
        System.out.println(res.getHeader("Set-Cookie"));

        //6.解析响应体数据：res.jsonPath().get()
        // 获取昵称
        //System.out.println(res.jsonPath().get("nickName"));
        //System.out.println(res.jsonPath().get("expires_in"));
    }


    @Test
    public void test02() {
        Response res =
                given().
                        when().
                        get("http://mall.lemonban.com:8107/prod/prodListByTagId?tagId=2&size=12").
                        then().
                        log().all().
                        extract().response();
        //下标为0表示json数组的第一个元素,1..2...以此类推
        //下标为-1表示json数组的最后一个元素，-2表示倒数第二个，以此类推
        //获取recoreds数组prodName字段的值sout
        System.out.println(res.jsonPath().get("records[-1].price").toString());


    }

    //html标签获取
    @Test
    public void test03() {
        Response res =
                given().
                        when().
                        get("https://www.baidu.com/").
                        then().
                        log().all().
                        extract().response();
        //获取litle文本值
        //System.out.println(res.htmlPath().get("html.head.title"));
        //获取meta.name的属性值
        System.out.println(res.htmlPath().get("html.head.meta[2].@name").toString());
        System.out.println(res.htmlPath().get("html.head.meta[0].@content").toString());

    }
    //断言
    @Test
    public void test04() {
        String jsonData = "{\"principal\":\"waiwai\",\"credentials\":\"lemon123456\",\"appType\":3,\"loginType\":0}";
        Response res =
                given().
                        header("Content-Type", "application/json").
                        body(jsonData).
                        when().
                        post("http://mall.lemonban.com:8107/login").
                        then().
                        log().all().
                        extract().response();
        //1.以登录名为断言
        String nickName =res.jsonPath().get("nickName");
        Assert.assertEquals(nickName,"waiwai");
        //2.以状态码为断言
        //注：一条断言失败，后面的断言不会执行;token值不能拿来做断言，因为每次登录token都会变
        System.out.println("断言");
        int statusCode = res.getStatusCode();
        Assert.assertEquals(statusCode,200);

    }
}
