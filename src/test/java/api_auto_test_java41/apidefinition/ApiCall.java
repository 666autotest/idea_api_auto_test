package api_auto_test_java41.apidefinition;



import api_auto_test_java41.data.Environment;
import io.qameta.allure.Allure;
import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.response.Response;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

/**
 * @author qq音乐
 * @date 2022/7/14 - 2:15
 */
public class ApiCall {
    /**
     * 接口请求通用方法封装，get\post\put\delete
     * @param method 接口请求方法
     * @param url    接口请求地址
     * @param headersMap  请求头，存放到map结构中
     * @param inputParams  请求参数
     * @return 响应结果
     */

    public static Response request(String interfaceName, String method, String url, Map headersMap,String inputParams){
/*
        //全局重定向输出到指定文件中(通过REST-Assured过滤器实现)  全部都存储到一个文件中--不方便管理、查看
        PrintStream fileOutPutStream = null;
        try {
            fileOutPutStream = new PrintStream(new File("log/test_all.log"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        RestAssured.filters(new RequestLoggingFilter(fileOutPutStream),new ResponseLoggingFilter(fileOutPutStream));
*/

        //每个测试用例日志单独保存到本地(前提需要在REST-Assured请求和响应中添加log),添加该配置后，日志不会输出到控制台
        //日志重定向到：D:\git_code\idea\idea_api_auto_test\log
        PrintStream fileOutPutStream = null;
        //设置日志文件的地址
        String logFileDir = "target/log/";
        File file = new File(logFileDir);
        if (!file.exists()){
            file.mkdirs();//创建层级目录，如：target/log/test
            //file.mkdir();创建单层目录，如：target/log
        }
        String logFilePath = logFileDir+"test_"+interfaceName+"_"+System.currentTimeMillis()+".log";
        try {
            fileOutPutStream = new PrintStream(new File(logFilePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        RestAssured.config = RestAssured.config().logConfig(LogConfig.logConfig().defaultStream(fileOutPutStream));

        //1.对接口的入参进行参数化替换
        inputParams=Environment.replaceParams(inputParams);
        //2.对接口的请求头进行参数化替换（请求头包含token）
        //token=Environment.replaceParams(token);
        headersMap = Environment.replaceParams(headersMap);
        //3.对接口请求地址进行参数化替换
        url = Environment.replaceParams(url);
        //初始化Response，Response是一个对象
        Response res = null;
        if("get".equalsIgnoreCase(method)){
             res =
                given().log().all().
                    headers(headersMap).
                when().
                    get(url+"?"+inputParams).
                then().
                    log().all().
                    extract().response();
        }else if("post".equalsIgnoreCase(method)){
            res =
            given().log().all().
                        headers(headersMap).
                        body(inputParams).
                when().
                    get(url).
                then().
                    log().all().
                    extract().response();
        }else if("put".equalsIgnoreCase(method)){
            //TODO
        }else if("delete".equalsIgnoreCase(method)){
            //TODO
        }else{
            System.out.println("非法接口请求方法，请检查");
        }
        //添加日志信息到Allure报表中
        try {
            Allure.addAttachment("接口的请求/响应信息",new FileInputStream(logFilePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return res;
    }




    /**
     * 登录接口请求定义
     *
     * @param inputParams 接口入参
     *                 {"principal":"waiwai","credentials":"lemon123456","appType":3,"loginType":0}
     * @return
     */
    public static Response login(String inputParams){
        Map headMap = new HashMap();
        headMap.put("Content-Type","application/json");
        return request("登录请求","post","http://mall.lemonban.com:8107/login",headMap,inputParams);

    /*        Response res =
                given().header("Content-Type", "application/json").
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
     * @return
     */
    public static Response searchProduct(String inputParams) {
        inputParams = Environment.replaceParams(inputParams);
        Map hesdMap = new HashMap();
        hesdMap.put("Content-Type","application/json");
        return  request("搜索商品","get","http://mall.lemonban.com:8107/search/searchProdPage",hesdMap,inputParams);
/*        Response res =
                given().
                        when().
                        get("http://mall.lemonban.com:8107/search/searchProdPage?"+inputParams).
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
        Map hesdMap = new HashMap();
        hesdMap.put("Content-Type","application/json");
        return  request("商品信息","get","http://mall.lemonban.com:8107/prod/prodInfo",hesdMap,"prodId="+prodId);
/*        Response res =
                given().
                        when().
                        get("http://mall.lemonban.com:8107/prod/prodInfo?" + "prodId=" + prodId).
                        then().
                        log().all().
                        extract().response();
        return res;*/

    }

    /**
     * 添加购物车请求
     * @param inputParams 请求入参
     * {"basketId:0,"count":1,"prodId":83,"shopId":1,"skuId":415}
     * @return
     */
    public static Response addShopCart(String inputParams,String token){

        Map headMap = new HashMap();
        headMap.put("Content-Type","application/json");
        headMap.put("Authorization","bearer"+token);
        return request("添加购物车","post","http://mall.lemonban.com:8107/p/shopCart/changeItem",headMap,inputParams);
/*        Response res=
                given().
                        log().all().
                        header("Content-Type","application/json").
                        header("Authorization","bearer"+token).
                        body(inputParams).
                when().
                        post("http://mall.lemonban.com:8107/p/shopCart/changeItem").
                then().
                        log().all().
                        extract().response();
        return res;*/
    }
}