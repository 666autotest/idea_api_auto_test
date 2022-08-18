package api_auto_test_java41.tasecase;

import api_auto_test_java41.apidefinition.ApiCall;
import io.restassured.response.Response;
import org.kohsuke.rngom.parse.host.Base;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.common.BaseTest;

/**
 * @author qq音乐
 * @date 2022/7/14 - 23:11
 */
public class ProductSearchTest extends BaseTest {
    @Test
    public void test_searchproduct_success(){
        //1.准备测试数据
        String data = "冰箱";
        //2.发起接口请求
        String inputParam = "prodName="+data+"&categoryId=&sort=0&orderBy=0&current=1&isAllProdType=true&st=0&size=12";
        Response res = ApiCall.searchProduct(inputParam);
        //3.断言
        //3-1响应状态码
        int status = res.getStatusCode();
        Assert.assertEquals(status,200);
        //3-2根据prodName是否包含冰箱
        //3-2、根据prodName是否包含“冰箱”
        //3-3、先获取prodName
        String prodName = res.jsonPath().get("records[0].prodName");
        Assert.assertTrue(prodName.contains("冰箱"));
        //打印输出prodName
        System.out.println((String) res.jsonPath().get("records[0].prodName"));
    }
}
