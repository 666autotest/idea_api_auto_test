package api_auto_test_java41.server;

import api_auto_test_java41.apidefinition.ApiCall;
import api_auto_test_java41.data.Environment;
import io.restassured.response.Response;

/**
 * @author qq音乐
 * @date 2022/7/17 - 1:06
 * 业务逻辑层测试用例
 * 1.登录->搜索商品-->查看商品信息-->添加购物车
 * 2.登录->搜索商品-->查看商品信息-->下单
 * 3.登录->搜索商品-->查看商品信息-->添加购物车-->下单
 */
public class BusinessFlow {
/*    //将prodId、token设置为静态的全局变量
    public static int prodId;
    public static String token;*/
    /**
     * 登录->搜索-->商品信息，场景组合接口调用
     * @return 商品信息接口响应数据
     */
    public static Response login_search_info() {
        //场景组合是由多个接口请求组装
        //1.登录接口
        String longingData = "{\"principal\":\"waiwai\",\"credentials\":\"lemon123456\",\"appType\":3,\"loginType\":0}";
        Response loginRes = ApiCall.login(longingData);
        //1-1提前token
        String token = loginRes.jsonPath().get("access_token");
        //token保存到环境变量中
        Environment.saveToEnvironment("token",token);

        //Environment.envMap.put("token",token);
        //2.搜索商品接口
        String searchData = "prodName&categoryId=&sort=0&orderBy=0&current=1&isAllProdType=true&st=0&size=12";
        Response searchRes = ApiCall.searchProduct(searchData);
        int prodId = searchRes.jsonPath().get("records[0].prodId");
        //prodId保存到环境变量中
        Environment.saveToEnvironment("prodId",prodId);

        //Environment.envMap.put("prodId",prodId);
        //3.商品信息
        Response infoRes = ApiCall.productInfo(prodId);
        return infoRes;
    }
}
