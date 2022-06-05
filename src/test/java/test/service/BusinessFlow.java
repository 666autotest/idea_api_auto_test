package test.service;

import io.restassured.response.Response;
import test.ApiDefinition.ApiCall;
import test.util.Environment;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author luxi
 * @date 2021/10/25 0:39
 *
 *  * 业务流程用例：
 *  * 1.登录-搜索商品-查看商品信息-添加购物车
 *  * 2.登录-搜索商品-查看商品信息-下单
 *  * 3.登录-搜索商品-查看商品信息-添加购物车-下单
 *  *
 *  * 前面3个步骤相同，封装成业务逻辑层：service-BusinessFlow
 *  */

public class BusinessFlow {
     //全局变量,通过util环境变量读取
/*    public static int prodId;
    public static String token;*/
    public static Response login_search_info(){

        //1、登录接口
        String loginData = "{\"principal\":\"waiwai\",\"credentials\":\"lemon123456\",\"appType\":3,\"loginType\":0}";
        Response loginRes = ApiCall.login(loginData);
        //提取token
        String token = loginRes.jsonPath().get("access_token");
        //保存到环境变量当中
        Environment.saveToEnvironment("token",token);
        //2、搜索商品接口
        String searchData = "prodName=&categoryId=&sort=0&orderBy=0&current=1&isAllProdType=true&st=0&size=12";
        Response searchRes = ApiCall.searchProduct(searchData);
        int prodId = searchRes.jsonPath().get("records[0].prodId");
        //保存到环境变量当中
        Environment.saveToEnvironment("prodId",prodId);
        //3.商品信息接口
        Response infoRes = ApiCall.productInfo(prodId);
        return infoRes;

    }
    }

