package test.Auto_Code;

import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;


/**
 * @author luxi
 * @date 2021/10/25 0:39
 * given(). 设置测试项，含请求头、请求参数、请求体、cookies等
 * when().  所要执行的操作(get/post请求)
 * then()   解析结果、断言
 */
public class RestAssured {
    public static void main(String[] args) {
/*        //1.get请求
        given().
        when().
                get("http://erp.lemfix.com/login.html ").
        then().
                log().all();*/


/*        //2.post请求
        String jsonData = "{\"mobile_phone\":\"13423234324\",\"pwd\":\"12345678\",\"type\":1}";
        given().
                header("Content-Type","application/json","X-lemonban-Media-Type","lemonban.v1").
                //body内的数据类型为json类型，需定义String类型的字符穿过
                body(jsonData).
        when().
                post("http://api.lemonban.com/futureloan/member/register").
        then().
                log().all();*/
/*
        String jsonData="{\"principal\":\"waiwai\",\"credentials\":\"lemon123456\",\"appType\":3,\"loginType\":0}";
        given().
                log().all().
                header("Content-Type","application/json").
                body(jsonData).
        when().
                post("http://mall.lemonban.com:8107/login").
        then().
                log().all();*/
    }
/*
    @Test
    public void getDemo01() {
        //get请求参数直接拼接到URL地址的后面
        given().
                when().
                get("http://mall.lemonban.com:8107/prod/prodListByTagId?tagId=2&size=12").
                then().
                log().body();}

        @Test
        public void getDemo02(){
            //get请求参数写到given()后面
            given().
                    queryParam("tagId",2).
                    queryParam("size",12).
                    when().
                    get("http://mall.lemonban.com:8107/prod/prodListByTagId").
                    then().
                    log().body();

    }*/



/*     @Test
   //ERP系统登录接口,post请求：form表单传参
    public void getDemo0(){
        given().
                header("Content-Type", "application/x-www-form-urlencoded").
                body("loginame=admin&password=e10adc3949ba59abbe56e057f20f883e").
        when().
                post("http://erp.lemfix.com/user/login").
        then().
                log().all();*/

    @Test
    public void postDemo02() {
        String jsonData = "{\"principal\":\"waiwai\",\"credentials\":\"lemon123456\",\"appType\":3,\"loginType\":0}";
        //post请求：json类型传参
        given().
                header("Content-Type", "application/json").
                body(jsonData).
                when().
                post("http://mall.lemonban.com:8107/login").
                then().
                log().body();

    }
}


