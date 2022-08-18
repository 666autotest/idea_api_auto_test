/*
package api_auto_test_java41.tasecase;

import com.lemon.encryption.MD5Util;
import com.lemon.encryption.RSAManager;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

*/
/**
 * @author 歪歪欧巴
 * @Description TODO
 * @date 2022/8/8 20:09
 * @Copyright 湖南省零檬信息技术有限公司. All rights reserved.
 *//*

public class EncryptTest {
    @Test
    public void test_md5(){
        String orgPassword= "lemontester";
        //对参数md5加密
        //System.out.println(MD5Util.stringMD5(orgPassword));
        given().
                header("Content-Type","application/x-www-form-urlencoded").
               // body("loginame=admin&password="+MD5Util.stringMD5(orgPassword)).
        when().
                post("http://erp.lemfix.com/user/login").
        then().
                log().all();
    }

    @Test
    public void test_rsa() throws Exception {
        //=======================登录接口===============
        String jsonStr1 = "{\"mobile_phone\": \"13329334510\",\"pwd\": \"12345678\"}";
        Response res = given().
                header("Content-Type","application/json").
                header("X-Lemonban-Media-Type","lemonban.v3").
                body(jsonStr1).
        when().
                post("http://api.lemonban.com/futureloan/member/login").
        then().
                log().all().extract().response();
        int memberId = res.jsonPath().get("data.id");
        String token = res.jsonPath().get("data.token_info.token");
        //获取秒级的时间戳
        long timestamp = System.currentTimeMillis()/1000;
        //请求体 json 设置 sign 参数，
        // 1、取 token值前 50 位
        String str1 = token.substring(0,50);
        // 2、再拼接上 timestamp 值
        String str2 = str1+timestamp;
        // 3、然后通过 RSA 公钥加密得到的字符串
        //String sign = RSAManager.encryptWithBase64(str2);
       //========================充值接口===============
        String jsonStr2 = "{\"member_id\": "+memberId+",\"amount\": 10000.0,\"timestamp\": "+timestamp+",\"sign\": \""+sign+"\"}";
        given().
                header("Content-Type","application/json").
                header("X-Lemonban-Media-Type","lemonban.v3").
                header("Authorization","Bearer "+token).
                body(jsonStr2).
        when().
                post("http://api.lemonban.com/futureloan/member/recharge").
        then().
                log().all();
    }

    public static void main(String[] args) throws Exception {
        //获取系统时间戳（毫秒级）
        //System.out.println(System.currentTimeMillis()/1000);;
        */
/*String str = "123456";
        //System.out.println(str.substring(0,5));
        System.out.println(RSAManager.encryptWithBase64(str));*//*

    }
}
*/
