package test.ApiDefinition;

import io.qameta.allure.Allure;
import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import test.common.GlobalConfig;
import test.util.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

/**
 * @date 2021/10/25 0:39
 * 登录接口请求定义
 * @param  接口入参
 * {"principal":"waiwai","credentials":"lemon123456","appType":3,"loginType":0}
 *
 */
//接口调用
public class ApiCall {
    /**
     * 接口请求通用方法封装
     *
     * @param method      请求方法 (get/post/put/delete……)
     * @param url         接口请求地址
     * @param headersMap  请求头，存放到Map中
     * @param inputParams 请求参数
     * @return 接口响应结果
     */
    public static Response request(String interfaceName, String method, String url, Map headersMap, String inputParams) {
        String logFilePath = null;
        /*
      //把所有接口日志（请求+响应）重定向到本地log文件夹中(不建议使用，因为每个接口请求日志都保存在一个文件夹中,不方便分析)
        PrintStream fileOutPutStream = null;
        try {
            fileOutPutStream = new PrintStream(new File("log/test_all.log"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        RestAssured.filters(new RequestLoggingFilter(fileOutPutStream),new ResponseLoggingFilter(fileOutPutStream));
*/

//测试用例日志单独保存(前提需要在REST-Assured请求和响应中添加log)
        if (!GlobalConfig.IS_DEBUG) {
            PrintStream fileOutPutStream = null;
            //创建target文件目录（日志保存到target目录下，执行mvn clear,就可以顺便把垃圾垃圾日志清理掉 ）
            String logFileDir = "target/log/";
            File file = new File(logFileDir);
            //判断logFileDir是否存在
            if (!file.exists()) {
                file.mkdirs();//创建层级目录：targe/log/test
                //file.mkdir();创建当前目录:target/log
            }
            logFilePath = logFileDir + "test_" + System.currentTimeMillis() + ".log";
            try {
                fileOutPutStream = new PrintStream(new File(logFilePath));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            RestAssured.config = RestAssured.config().logConfig(LogConfig.logConfig().defaultStream(fileOutPutStream));
        }
        //参数化替换
        //1、接口入参做参数化替换
        inputParams = Environment.replacParams(inputParams);
        //2、接口请求头参数化替换
        headersMap = Environment.replacParams(headersMap);
        //3、接口请求地址参数化替换
        url = Environment.replacParams(url);
        //指定项目base url
        RestAssured.baseURI = GlobalConfig.url;
        Response res = null;
        if ("get".equalsIgnoreCase(method)) {
            res = given().log().all().headers(headersMap).when().get(url + "?" + inputParams).then().log().all().extract().response();
        } else if ("post".equalsIgnoreCase(method)) {
            res = given().log().all().headers(headersMap).body(inputParams).when().post(url).then().log().all().extract().response();
        } else if ("put".equalsIgnoreCase(method)) {
            res = given().log().all().headers(headersMap).body(inputParams).when().put(url).then().log().all().extract().response();
        } else if ("delete".equalsIgnoreCase(method)) {
            //TODO
        } else {
            System.out.println("接口请求方法非法，请检查你的请求方法");
        }
        //添加日志信息到Allure报表中
        if (!GlobalConfig.IS_DEBUG) {
            try {
                Allure.addAttachment("接口请求/响应信息", new FileInputStream(logFilePath));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    public static Response login(String inputParams) {
        //String jsonData = "{\"principal\":\"waiwai\",\"credentials\":\"lemon123456\",\"appType\":3,\"loginType\":0}";
        Map headMap = new HashMap();
        headMap.put("Content-Type", "application/json");
        //调用resqust方法
        return request("登录请求", "post", "http://mall.lemonban.com:8107/login", headMap, inputParams);
/*       Response res =
                given().
                        header("Content-Type", "application/json").
                        body(inputParams).
                        when().
                        post("http://mall.lemonban.com:8107/login").
                        then().
                        log().all().
                        extract().response();
        return res;*/
    }

    /**
     * 搜索商品接口请求定义
     *
     * @param inputParams 接口请求入参
     *                    prodName=&categoryId=&sort=0&orderBy=0&current=1&isAllProdType=true&st=0&size=12
     * @return 响应信息
     */
    public static Response searchProduct(String inputParams) {
        inputParams = Environment.replacParams(inputParams);
        Map headMap = new HashMap();
        headMap.put("Content-Type", "application/json");
        return request("搜索商品", "get", "/search/searchProdPage", headMap, inputParams);
/*        Response res =
                given().
                when().
                         get("http://mall.lemonban.com:8107/search/searchProdPage?" + inputParams).
                then().
                        log().all().
                        extract().response();
        return res;*/
    }

    /**
     * 商品信息接口请求定义
     *
     * @param prodId 商品ID
     * @return 响应结果
     */
    public static Response productInfo(int prodId) {
        Map headMap = new HashMap();
        headMap.put("Content-Type", "application/json");
        return request("商品信息", "get", "/prod/prodInfo", headMap, "prodId=" + prodId);
/*        Response res =
                given().
                        when().
                        get("http://mall.lemonban.com:8107/prod/prodInfo?" + "prodId=" + prodId).
                        then().
                        log().all().
                        extract().response();
        return res;*/
    }

    @Test
    public static Response addShopCart(String inputParams, String token) {
        //对接口入参进行替换
        inputParams = Environment.replacParams(inputParams);
        token = Environment.replacParams(token);
        Map headMap = new HashMap();
        headMap.put("Content-Type", "application/json");
        headMap.put("Authorization", "bearer" + token);
        return request("添加购物车", "post", "/p/shopCart/changeItem", headMap, inputParams);
/*        Response res =
                given().
                        log().all().
                        header("Content-Type", "application/json").
                        header("Authorization", "bearer" + token).
                        body(inputParams).
                when().
                        post("http://mall.lemonban.com:8107/p/shopCart/changeItem").
                then().
                        log().all().
                        extract().response();
        return res;*/
    }

    /**
     * 注册验证码发送接口请求
     *
     * @param inputParams 请求参数
     * @return 响应参数
     */
    public static Response sendRegisterSms(String inputParams) {
        Map<String, Object> headMap = new HashMap<>();
        headMap.put("Content-Type", "application/json");
        return request("注册验证码发送", "put", "/user/sendRegisterSms", headMap, inputParams);
    }

    /**
     * 校验注册码接口请求
     *
     * @param inputParams 请求参数
     *                    {"mobile":"13612957120","validCode":"823550"}
     * @return 响应数据
     */
    public static Response checkRegisterSms(String inputParams) {
        Map<String, Object> headMap = new HashMap<>();
        headMap.put("Content-Type", "application/json");
        return request("校验注册验证码", "put", "/user/checkRegisterSms", headMap, inputParams);
    }

    /**
     * 注册接口请求
     *
     * @param inputParams 请求参数
     *                    {"appType":3,"":"test01","password":"123456","registerOrBind":1,"validateType":1}
     * @return
     */
    public static Response register(String inputParams) {
        Map<String, Object> headMap = new HashMap<>();
        headMap.put("Content-Type", "application/json");
        return request("注册", "put", "/user/registerOrBindUser", headMap, inputParams);

    }

    /**
     * 确认订单接口定义
     *
     * @param inputParams 接口入参
     * {"addrId":0,"orderItem":{"prodId":88,"skuId":420,"prodCount":1,"shopId":1},"couponIds":[],"isScorePay":0,"userChangeCoupon":0,"userUseScore":0,"uuid":"1a616894-d383-4880-8e2e-091d055041ab"}
     * @param token
     * @return
     */
    public static Response confirmOrder(String inputParams, String token) {
        Map<String, Object> headMap = new HashMap<>();
        headMap.put("Content-Type", "application/json");
        headMap.put("Authorization", "bearer" + token);
        return request("确认订单", "post", "/p/order/confirm", headMap, inputParams);

    }

    /**
     * 提交订单接口定义
     * @param inputParams 接口入参
     * {"orderShopParam":[{"remarks":"","shopId":1}],"uuid":"1a616894-d383-4880-8e2e-091d055041ab"}
     * @param token
     * @return
     */
    public static Response submitoOrder(String inputParams, String token) {
        Map<String, Object> headMap = new HashMap<>();
        headMap.put("Content-Type", "application/json");
        headMap.put("Authorization", "bearer" + token);
        return request("提交订单", "post", "/p/order/submit", headMap, inputParams);

    }

    /**
     * 支付下单
     * @param inputParams 接口入参
     * {"payType":3,"orderNumbers":"1505469918085386240"}
     * @param token
     * @return
     */
    public static Response placeorder(String inputParams, String token) {
        Map<String, Object> headMap = new HashMap<>();
        headMap.put("Content-Type", "application/json");
        headMap.put("Authorization", "bearer" + token);
        return request("支付下单", "post", "/p/order/pay", headMap, inputParams);
    }

    /**
     * 模拟支付回调的接口
     * @param inputParams 接口入参
     *{
     *    "payNo":1470015941797744640, #商城支付订单号
     *    "bizPayNo":XXXX, #微信方的订单号
     *    "isPaySuccess":true,#true成功，false失败
     * }
     * @param token
     * @return
     */
    public static Response mockPay(String inputParams, String token){
        Map<String, Object> headMap = new HashMap<>();
        headMap.put("Content-Type", "application/json");
        headMap.put("Authorization", "bearer" + token);
        return request("支付接口", "post", "/notice/pay/3", headMap, inputParams);

    }
}