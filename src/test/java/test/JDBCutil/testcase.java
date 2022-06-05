package test.JDBCutil;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Random;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.sessionId;

/**
 * @author luxi
 * @date 2021/10/25 0:39
 */
public class testcase {
    String mobilephone;
    int id;
    @Test(priority = 0)

    public void register(){
        String phonelist="152";
        for (int i = 0; i <8 ; i++) {
            Random random=new Random();
            int sum = random.nextInt(9);
          phonelist= phonelist+sum;



        }
        String josnstr="{\"mobile_phone\":"+phonelist+",\"pwd\":\"12345678\",\"type\":1}";
        Response res=

                given().
                body(josnstr).header("Content-Type","application/json").
                header("X-lemonban-Media-Type","lemonban.v1").
                when().post("http://api.lemonban.com/futureloan/member/register").
                then().log().all().extract().response();
        mobilephone  = res.jsonPath().get("data.mobile_phone");

    }

    @Test(priority = 1)
    public void login(){
        String josnstr="{\"mobile_phone\":"+mobilephone+",\"pwd\":\"12345678\"}";
        Response res=
        given().
                body(josnstr).header("Content-Type","application/json").
                header("X-lemonban-Media-Type","lemonban.v1").
                when().post("http://api.lemonban.com/futureloan/member/login").
                then().log().all().extract().response();
        id=res.jsonPath().get("data.id");


    }


    @Test(priority = 2)
    public void regcharge(){
        String josnstr="{\"member_id\":"+id+",\"amount\":\"10000.00\"}";
        System.out.println(josnstr);
        given().
                body(josnstr).header("Content-Type","application/json").
                header("X-lemonban-Media-Type","lemonban.v1").
                when().post("http://api.lemonban.com/futureloan/member/recharge").
                then().log().all().extract().response();
    }

}
