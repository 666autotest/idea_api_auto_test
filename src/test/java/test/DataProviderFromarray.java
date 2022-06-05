package test;

import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.ApiDefinition.ApiCall;
import test.common.BaseTest;

/**
 * @author luxi
 * @date 2021/10/25 0:39
 */


public class DataProviderFromarray extends BaseTest {
    @DataProvider
    public Object[] getLoginDatas(){
        //数据类型为一维/二维数组
        Object[] data ={"{\"principal\":\"waiwai\",\"credentials\":\"lemon123456\",\"appType\":3,\"loginType\":0}",
                      "{\"principal\":\"\",\"credentials\":\"lemon123456\",\"appType\":3,\"loginType\":0}",
                      "{\"principal\":\"waiwai\",\"credentials\":\"\",\"appType\":3,\"loginType\":0}",
                      "{\"principal\":\"\",\"credentials\":\"\",\"appType\":3,\"loginType\":0}",
                      "{\"principal\":\"waiwai1\",\"credentials\":\"\",\"appType\":3,\"loginType\":0}",
                      "{\"principal\":\"waiwai\",\"credentials\":\"lemon123456\",\"appType\":3,\"loginType\":0}"};
        return data;
    }
    @Test(dataProvider = "getLoginDatas")
    public void test_Login_succes_DataProvider(String casedata) {
    Response res = ApiCall.login(casedata);
/*        //3.断言
        String nickName = res.jsonPath().get("nickName");
        Assert.assertEquals(nickName, "waiwai");
        //2.以状态码为断言
        //注：一条断言失败，后面的断言不会执行;token值不能拿来做断言，因为每次登录token都会变
        System.out.println("断言");
        int statusCode = res.getStatusCode();
        Assert.assertEquals(statusCode, 200);*/

    }
}
