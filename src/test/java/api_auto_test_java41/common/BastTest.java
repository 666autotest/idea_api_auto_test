package api_auto_test_java41.common;
import api_auto_test_java41.pojo.ExcelPojo;
import com.alibaba.fastjson.JSONObject;
import io.restassured.response.Response;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.Set;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;


public class BastTest {
    /**
             * REST-assured接口请求统一封装
             * @param method 请求方法
             * @param url 请求地址
             * @param map 请求头
             * @param params 请求参数
             * @return 响应数据
             */
        public Response request(String method, String url, Map<String,Object> map, String params){

            //接口请求四大要素：请求方法、请求地址、请求头、请求参数
            Response res = null;
            //对请求方法判断
            if ("get".equals(method)){
                //get请求
                //对请求头进行判断，如果传过来的请求头为null，那么我们就不使用headers传入请求头
                if(map == null){
                    res=given().log().all().when().get(url+"?"+params).
                            then().log().all().extract().response();
                }else {
                    res=given().log().all().headers(map).when().get(url+"?"+params).
                            then().log().all().extract().response();
                }
            }else if("post".equals(method)){
                //post请求
                res=given().log().all().headers(map).body(params).when().post(url).
                        then().log().all().extract().response();
            }else if("put".equals(method)){
                //put请求
                res=given().log().all().headers(map).body(params).when().put(url).
                        then().log().all().extract().response();
            }else if("delete".equals(method)){
                //delete请求
                res=given().log().all().headers(map).body(params).when().delete(url).
                        then().log().all().extract().response();
            }
            return res;
        }

        /**
         * 统一断言，兼容不同的情况
         * @param excelPojo 从excel中读取到的一条测试用例数据
         * @param res 接口的实际响应数据（响应状态码、响应头、响应体）
         */
        public void assertResponse(ExcelPojo excelPojo, Response res){
            //判断【期望返回结果】数据是否为空
            if(excelPojo.getExpectedValue() != null){
                String expectedValue = excelPojo.getExpectedValue();
                //把原始的JSON格式的字符串  转成 Map（因为Map方便处理）
                //{"statuscode":200,"nickName":"java_auto","enabled":true,"bodystring":"Incorrect account or password"}
                Map<String,Object> expectedValueMap = JSONObject.parseObject(expectedValue);
                //获取Map里面所有的键（key）
                Set<String> allKeys = expectedValueMap.keySet();
                for (String key : allKeys){
                    if(key.equals("statuscode")){
                        //1、对响应状态码做断言
                        Assert.assertEquals(res.statusCode(),expectedValueMap.get(key));
                    }else if(key.equals("bodystring")){
                        //2、对整个响应体字符串做断言
                        Assert.assertEquals(res.body().asString(), expectedValueMap.get(key));
                    }else{
                        //3、对响应体某个字段做断言
                        //字段的实际值,Gpath表达式-->实际就是在期望响应结果中的key
                        //res.jsonPath().get(key);
                        //期望值
                        //expectedValueMap.get(key);
                        Assert.assertEquals(res.jsonPath().get(key),expectedValueMap.get(key));
                    }
                }
                //三种情况
                //1、对响应状态码做断言
                //2、对整个响应体字符串做断言
                //3、对响应体某个字段做断言

            }

        }
    }


