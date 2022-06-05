package test.day25;

import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

/**
 * @author luxi
 * @date 2021/10/25 0:39
 *         given():设置测试预设(包括请求行、请求头、请求体、cookies等)
 *         when()：所要执行的操作(get/post请求)
 *         then():解析结果、断言
 */
public class RestAssuredTest {
    public static void main(String[] args) {
        //1.商城登录post请求
        String jsonData = "{\"principal\":\"waiwai\",\"credentials\":\"lemon123456\",\"appType\":3,\"loginType\":0}";
        given().
                log().all().
                header("Content-Type", "application/json").
                body(jsonData).
                when().
                post("http://mall.lemonban.com:8107/login").
                then().
                log().all();

    }

    @Test
    public void getDemo01() {
        //get请求参数直接拼接到URL地址的后面
        given().
                when().
                get("http://mall.lemonban.com:8107/prod/prodListByTagId?tagId=2&size=12").
                then().
                log().body();
    }

    @Test
    public void getDemo02() {
        //get请求参数写到given()后面
        given().
                queryParam("tagId", 2).
                queryParam("size", 12).
                when().
                get("http://mall.lemonban.com:8107/prod/prodListByTagId").
                then().
                log().body();
    }

    @Test
    //ERP系统post请求：from表单传参
    public void postDomo01() {
        given().
                header("Content-Type", "application/x-www-form-urlencoded").
                body("loginame=admin&password=e10adc3949ba59abbe56e057f20f883e").
                when().
                post("http://erp.lemfix.com/user/login").
                then().
                log().body();
    }

    @Test
    //ERP系统post请求：json类型传参
    public void postDomo02() {
        String jsonData = "{\"principal\":\"waiwai\",\"credentials\":\"lemon123456\",\"appType\":3,\"loginType\":0}";
        given().
                header("Content-Type", "application/json").
                body(jsonData).
                when().
                post("http://mall.lemonban.com:8107/login").
                then().
                log().body();
    }

    @Test
    public void postDemo03() {
        //3.xml传参
        String xmlData = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<suite>\n" +
                "    <class>测试xml</class>\n" +
                "</suite>";
        //post请求：json类型传参
        given().
                header("Content-Type", "application/xml").
                body(xmlData).
                when().
                post("http://www.httpbin.org/post").
                then().
                log().body();
    }
    //上传图片
    //步骤：web上传图片--》fiddler抓包--》postman(Headers{key:Authorization,value:bearer+token})
    //-->body{key:file,value:选择上传的图片}
    @Test
    public void postDomo04() {
        given().
                log().all().
                header("Authorization", "bearer2f286e91-a17f-45d5-8ca5-21501b976d11").
                multiPart(new File("C:\\Users\\lushifei\\Desktop\\柠檬班测试.jpeg")).
        when().
                post("http://mall.lemonban.com:8108/admin/file/upload/img ").
        then().
                log().body();
    }
}


