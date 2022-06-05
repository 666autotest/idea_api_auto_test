package test.testcases;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import org.testng.annotations.DataProvider;
import test.ApiDefinition.ApiCall;
import test.common.BaseTest;
import test.pojo.CaseData;
import test.service.BusinessFlow;
import test.util.Environment;
import test.util.ExcelUtil;
import test.util.JDBCUtils;

import java.util.List;
import java.util.Map;



import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.reset;

/**
 * @author luxi
 * @date 2021/10/25 0:39
 * 业务流程用例：
 * 1.登录-搜索商品-查看商品信息-添加购物车
 * 2.登录-搜索商品-查看商品信息-下单
 * 3.登录-搜索商品-查看商品信息-添加购物车-下单
 *
 * 前面3个步骤相同，封装成业务逻辑层：service-BusinessFlow
 */
public class ShopcarTest extends BaseTest{
    @Test
    public void test_add_shopcart_sucess(){
        //登录-搜索商品-查看商品信息,公共步骤，以封装在service-buinessFlow
/*      //2-1、登录
        String loginData="{\"principal\":\"waiwai\",\"credentials\":\"lemon123456\",\"appType\":3,\"loginType\":0}";
        Response loginRes = ApiCall.login(loginData);
        //提取token
        String token = loginRes.jsonPath().get("access_token");
        //2-2、搜索商品
        String searchData = "prodName=&categoryId=&sort=0&orderBy=0&current=1&isAllProdType=true&st=0&size=12";
        Response searchRes = ApiCall.searchProduct(searchData);
        //提取商品ID
        int prodId = searchRes.jsonPath().get("records[0].prodId");
        //2-3、获取商品信息
        Response infoRes = ApiCall.productInfo(prodId);*/

        //直接调用BuinessFLow中的商品信息方法
        Response infoRes = BusinessFlow.login_search_info();
        System.out.println(BusinessFlow.login_search_info());

        //提取skuId
        int skuId = infoRes.jsonPath().get("skuList[0].skuId");
        Environment.saveToEnvironment("skuId",skuId);
        //2-4、添加到购物车
        String shopCarData="{\"basketId\":0,\"count\":1,\"prodId\":"+ Environment.getEnvironment("prodId") +",\"shopId\":1,\"skuId\":"+skuId+"}";
        shopCarData = Environment.replacParams(shopCarData);
        Response shopCarRes = ApiCall.addShopCart(shopCarData, (String)Environment.getEnvironment("token"));
        //3、断言
        Assert.assertEquals(shopCarRes.getStatusCode(),200);
        //4.数据库断言
        String assertSql = "select * from tz_basket where user_id = (select user_id from tz_user where user_name = 'lemontester');";
        Map<String,Object> dbData = JDBCUtils.quaryonedata(assertSql);
        //根据购物车商品数量断言
        Assert.assertEquals(dbData.get("basket_count"),1);
    }
    //@Test(dataProvider = "getShopCartDatas")
    public void test_shopcart(CaseData caseData){
        //测试数据
        //1、token
        Response loginRes = ApiCall.login("{\"principal\":\"waiwai\",\"credentials\":\"lemon123456\",\"appType\":3,\"loginType\":0}");
        String token = loginRes.jsonPath().get("access_token");
        String inputParams = caseData.getInputParams();
        Response addShopCartRes = ApiCall.addShopCart(inputParams,token);
        //断言
        assertResponse(caseData.getAssertResponse(),addShopCartRes);
        //数据库断言
        assertDB(caseData.getAssertDB());
    }

    @DataProvider
    public Object[] getShopCartDatas(){
        return ExcelUtil.readExcel(2).toArray();
    }
}
