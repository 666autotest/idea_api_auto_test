package api_auto_test_java41.tasecase;

import api_auto_test_java41.apidefinition.ApiCall;
import api_auto_test_java41.server.BusinessFlow;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.common.BaseTest;
import test.util.Environment;


/**
 * @author qq音乐
 * @date 2022/7/14 - 23:11
 */
public class ShopCarTest extends BaseTest {
    @Test
    public void test_add_shopCart_success(){
        //添加购物车用例：准备测试数据-->发起接口请求

/*      代码优化前
//      1.登录
        String longingData = "{\"principal\":\"waiwai\",\"credentials\":\"lemon123456\",\"appType\":3,\"loginType\":0}";
        Response loginRes = ApiCall.login(longingData);
        //2.提取token
        String token = loginRes.jsonPath().get("access_token");
        //3.搜索商品
        String searchData = "prodName&categoryId=&sort=0&orderBy=0&current=1&isAllProdType=true&st=0&size=12";
        Response searchRes = ApiCall.searchProduct(searchData);
        //4.提取商品id
        int prodId = searchRes.jsonPath().get("records[0].prodId");
        //5.商品信息
        Response infoRes = ApiCall.productInfo(prodId);*/

        //代码优化后
        Response infoRes = BusinessFlow.login_search_info();
        //6.提取skuid
        int skuId = infoRes.jsonPath().get("skuList[0].skuId");
        //6-1:skuId保存到环境变量
        Environment.saveToEnvironment("skuId",skuId);
       //7.添加购物车
        String shopData="{\"basketId\":0,\"count\":1,\"prodId\":\"#prodId#\",\"shopId\":1,\"skuId\":#skuId#}";
        Response shopCartRes = ApiCall.addShopCart(shopData,"#token#");
        System.out.println();
        //8.断言
        Assert.assertEquals(shopCartRes.getStatusCode(),200);
        }
}
