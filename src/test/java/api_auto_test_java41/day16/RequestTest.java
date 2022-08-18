package api_auto_test_java41.day16;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.given;

/**
 * @author qq音乐
 * @date 2022/7/25 - 23:43
 */
public class RequestTest {
    /**
     * @param method  请求方法
     * @param url     请求地址
     * @param map     请求头
     * @param params  请求参数
     * return  响应数据
     */
    public Response request(String method, String url, Map<String, Object> map, String params){
        Response res = null;
        //结果请求4大要素：请求方法、请求地址、请求头、请求参数
        //1.对接口请求进行判断
        if ("get".equals(method)){
            //get请求
            //如果headers为空，则跳过
            if (map == null){
                res=given().log().all().
                when().get(url+"?"+params).
                then().log().all().extract().response();
            }else{
                res=given().log().all().headers(map).
                    when().get(url+"?"+params).
                    then().log().all().extract().response();
            }
        }else if ("post".equals(method)){
            //post请求
            res=given().log().all().headers(map).body(params).
             when().post(url).
             then().log().all().extract().response();
        }else if ("put".equals(method)){
            //put请求
            res=given().log().all().headers(map).body(params).
            when().put(url).
            then().log().all().extract().response();
        }else if ("delete".equals(method)){
            //delete请求
            res=given().log().all().headers(map).body(params).
                    when().delete(url).
                    then().log().all().extract().response();
        }else {
            System.out.println("接口请求方法非法，请检查你的请求方法");
        }
        return res;
    }



}
