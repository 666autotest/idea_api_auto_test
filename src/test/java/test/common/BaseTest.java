package test.common;

import api_auto_test_java41.data.Environment;
import api_auto_test_java41.pojo.ExcelPojo;
import api_auto_test_java41.utils.DBUtil;
import com.alibaba.fastjson.JSONObject;
import io.qameta.allure.Allure;
import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.response.Response;
import org.testng.Assert;
import test.util.JDBCUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.alibaba.fastjson.JSON.parseObject;
import static io.restassured.RestAssured.given;

/**
 * @author luxi
 * @date 2021/10/25 0:39
 */
public class BaseTest {

   /* public void assertResponse(ExcelPojo assertDatas, Response res) {
       /* if (null != assertDatas) {
            //{"statuscode":200,"nickName":"waiwai"}
            //2-1、断言为json字符串需转成Java的map(导入fastjson依赖)，1：fastjson 2：Jackson
            Map<String, Object> map = JSONObject.parseObject(assertDatas);
            //2-2、遍历Map
            Set<Map.Entry<String, Object>> datas = map.entrySet();
            for (Map.Entry<String, Object> keyValue : datas) {
                //key:statuscode nickName  value:200,waiwai
                String key = keyValue.getKey();
                Object value = keyValue.getValue();
                //3、断言
                if ("statuscode".equals(key)) {
                    //获取接口响应状态码
                    int statuscode = res.getStatusCode();
                    System.out.println("断言响应状态码，期望值：" + value + "实际值：" + statuscode);
                    Assert.assertEquals(statuscode, value);
                } else {
                    //响应体数据断言
                    //nickName -->相当于Gpath表达式
                    Object actualValue = res.jsonPath().get(key);
                    System.out.println("断言响应体字段，期望值：" + value + "实际值：" + actualValue);
                    Assert.assertEquals(actualValue, value);
                    //注：如需要加多组断言，只需在excel中添加断言项即可，代码不动

                }
            }
        }*/


    public void assertDB(String assertDB) {
        //把原始的数据库断言数据（json）转成Map
        Map<String, Object> map = parseObject(assertDB);
        Set<Map.Entry<String, Object>> datas = map.entrySet();
        for (Map.Entry<String, Object> keyValue : datas) {
            //map里面的key就是我们的查询sql语句
            Object actualValue = JDBCUtils.quarySingData((keyValue.getKey()));
            System.out.println("实际值：" + actualValue.toString());
            System.out.println("期望值：" + keyValue.getValue().toString());
            //map里面的value就是我们的期望值
            Assert.assertEquals(actualValue.toString(), keyValue.getValue().toString());
            //数据匹配

        }
    }


    /**
     * REST-assured接口请求统一封装
     *
     * @return 响应数据
     */
    public static Response request(ExcelPojo excelPojo) {
        //1.指定接口日志保存路径在log/testXX.log
        PrintStream fileOutPutStream = null;
        String logFilePath = "log/tes"+excelPojo.getCaseId()+".log";
        try {
            fileOutPutStream = new PrintStream(new File(logFilePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //2.把接口日志重定向到本地log/testXX.log
        RestAssured.config = RestAssured.config().logConfig(LogConfig.logConfig().defaultStream(fileOutPutStream));



        //拆分String method, String url, Map<String,Object> map, String params，因为提换请求头需要字符串类型，请求头是map
        //1.请求方法
        String method = excelPojo.getMethod();
        //2.请求地址
        String url = excelPojo.getUrl();
        //3.请求头
        String headers = excelPojo.getHeaders();
        //4.请求参数
        String params = excelPojo.getParams();
        //5.在接口请求之前替换#prodId#,作为实际环境变量中保存
        params = replaceParam(params);
        //4.替换请求头
        headers = replaceParam(headers);
        //5.替换url
        url = replaceParam(url);
        //把请求头字符由串转换为Map
        Map<String, Object> map = JSONObject.parseObject(headers);
        params = replaceParam(params);
        //接口请求四大要素：请求方法、请求地址、请求头、请求参数
        Response res = null;
        //对请求方法判断
        if ("get".equals(method)) {
            //get请求
            //对请求头进行判断，如果传过来的请求头为null，那么我们就不使用headers传入请求头
            if (map == null) {
                res = given().log().all().when().get(url + "?" + params).
                        then().log().all().extract().response();
            } else {
                res = given().log().all().headers(map).when().get(url + "?" + params).
                        then().log().all().extract().response();
            }
        } else if ("post".equals(method)) {
            //post请求--支持json传参、form、表单传参、xml传参
            //判断是否为文件上传--判断请求头
            if (map.containsValue("multipart/form-data")) {
                res = given().log().all().headers(map).multiPart(new File(params)).when().post(url).andReturn().
                        then().log().all().extract().response();
            } else {
                //post请求
                res = given().log().all().headers(map).body(params).when().post(url).
                        then().log().all().extract().response();
            }
        } else if ("put".equals(method)) {
            //put请求
            res = given().log().all().headers(map).body(params).when().put(url).
                    then().log().all().extract().response();
        } else if ("delete".equals(method)) {
            //delete请求
            res = given().log().all().headers(map).body(params).when().delete(url).
                    then().log().all().extract().response();
        }
        //接口日志保存到allure报告附件中
        try {
            Allure.addAttachment("接口日志",new FileInputStream(logFilePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * 统一断言，兼容不同的情况
     *
     * @param excelPojo 从excel中读取到的一条测试用例数据
     * @param res       接口的实际响应数据（响应状态码、响应头、响应体）
     */
    public void assertResponse(ExcelPojo excelPojo, Response res) {

        //判断【期望返回结果】数据是否为空
        //三种情况
        //1、对响应状态码做断言
        //2、对整个响应体字符串做断言
        //3、对响应体某个字段做断言
        if (excelPojo.getExpectedValue() != null) {
            String expectedValue = excelPojo.getExpectedValue();
            //把原始的JSON格式的字符串  转成 Map（因为Map方便处理）
            //{"statuscode":200,"nickName":"java_auto","enabled":true,"bodystring":"Incorrect account or password"}
            Map<String, Object> expectedValueMap = parseObject(expectedValue);
            //获取Map里面所有的键（key）
            Set<String> allKeys = expectedValueMap.keySet();
            for (String key : allKeys) {
                if (key.equals("statuscode")) {
                    //1、对响应状态码做断言
                    org.junit.Assert.assertEquals(res.statusCode(), expectedValueMap.get(key));
                } else if (key.equals("bodystring")) {
                    //2、对整个响应体字符串做断言
                    org.junit.Assert.assertEquals(res.body().asString(), expectedValueMap.get(key));
                } else {
                    //3、对响应体某个字段做断言
                    //字段的实际值,Gpath表达式-->实际就是在期望响应结果中的key
                    //res.jsonPath().get(key);
                    //期望值
                    //expectedValueMap.get(key);
                    org.junit.Assert.assertEquals(res.jsonPath().get(key), expectedValueMap.get(key));
                }
            }
        }
    }

    public static String replaceParam(String orgstr) {
        //{
        //"basketId": 0,"count": 1,"prodId": "#prodId#","shopId": #shopId#,"skuId": #skuId#
        //1、找到#XXX部分-->使用正则表达式
        //1-1、使用Pattern类的compile()方法编译正则表达式
        //参数为空的不需要替换
        if (orgstr != null) {
            Pattern pattern = Pattern.compile("#(.*?)#");//括号表示分组
            //1-2、进行匹配，参数为要匹配的原始字符串
            Matcher matcher = pattern.matcher(orgstr);
            //1-3、循环遍历匹配器
            while (matcher.find()) {
                //match.group()-->符合正则表达式的子
                //group(0),第0组表示一整个字符串
                System.out.println(matcher.group(0));
                System.out.println(matcher.group(1));
                //group(1)获取第一组内容，索引从1开始
                String key = matcher.group(1);
                //从环境变量中取得变量值
                Object value = Environment.var.get(key);
                //把取出来的值替换#prodId#,#shopId#,#skuId#
                //字符串的值不会改变，所以用orgstr接收
                orgstr = orgstr.replace(matcher.group(0), value + "");
            }
        }
        return orgstr;
    }

    public static void main(String[] args) {
        String orgStr = "{\"basketId\":0,\"count\":1,\"prodId\":\"#prodId#\",\"shopId\":#shopId#,\"skuId\":#skuId#}";

        Environment.var.put("prodId", 888);
        Environment.var.put("shopId", 888);
        Environment.var.put("skuId", 888);
        System.out.println(replaceParam(orgStr));
    }

    /**
     * 数据库断言方法
     * @param excelPojo
     */
    public void assertDB(ExcelPojo excelPojo){
    //1.获取数据库期望结果信息
        String expectedDB=excelPojo.getExpectedDB();
        if (expectedDB !=null){
            //需要对【#XX#】进行替换
            expectedDB=replaceParam(expectedDB);
            Map<String,Object> expectedMap=JSONObject.parseObject(expectedDB);
            Set<String> allkeys = expectedMap.keySet();
            for (String key: allkeys) {
                //key:要执行的sql,value:期望的数据结果
                Object actual_result =DBUtil.querySingledata(key);
                Object expected_reult = expectedMap.get(key);
                Assert.assertEquals(actual_result+"",expected_reult+"");
            }
        }
    }

    /**
     * 提取响应字段，保存对应的字段到环境变量中
     *
     * @param excelPojo
     * @param res
     */
    public void extracToEnv(ExcelPojo excelPojo, Response res) {
        String extractFiled = excelPojo.getExtractField();
        if (extractFiled != null) {
            //提取响应字段--传递给下一个接口
            Map<String, Object> extractFieldMap = JSONObject.parseObject(extractFiled);
            //遍历map
            Set<String> allKeys = extractFieldMap.keySet();
            for (String key : allKeys) {
                //key-->提取字段名  value：要提取的Gpath表达式
                Object value = extractFieldMap.get(key);
                if ("bodystring".equals(value)) {
                    //提取响应体字符串
                    String bodyString = res.body().asString();
                    Environment.var.put(key, bodyString);
                } else {
                    //解析获取响应字段的值
                    Object fieldValue = res.jsonPath().get(value + "");
                    //保存到环境变量中
                    Environment.var.put(key, fieldValue);
                }
            }
        }

    }

}