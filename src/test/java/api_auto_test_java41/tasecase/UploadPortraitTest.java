package api_auto_test_java41.tasecase;



import api_auto_test_java41.pojo.ExcelPojo;
import api_auto_test_java41.utils.ExcelUtil;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.common.BaseTest;

public class UploadPortraitTest extends BaseTest {

    @Test(dataProvider = "getDatas")
    public void test_uploadProtrait(ExcelPojo excelPojo){
        //发起接口请求
        Response res = request(excelPojo);
        //断言
        //提取响应字段保存到环境变量中
        //extractToEnv(excelPojo,res);
        extracToEnv(excelPojo,res);
    }

    @DataProvider
    public Object[] getDatas(){
        return ExcelUtil.readExcel(4).toArray();
    }
}