package api_auto_test_java41.day16;

import api_auto_test_java41.pojo.ExcelPojo;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

import static io.restassured.RestAssured.*;

/**
 * @author qq音乐
 * @date 2022/7/26 - 2:00
 */
public class LoginTest extends RequestTest{
    @Test(dataProvider = "getLoginDataFromExcel")
    public void login(ExcelPojo excelDataPojocel){

        //发起接口请求
        //Response res = request("get","http://mall.lemonban.com:8107/login",map,excelDataPojocel.getParams());
        //1.登录
        String loginData="{\"principal\":\"java_auto\",\"credentials\":\"lemon123456\",\"appType\":3, \"loginType\":0 }";
        Response res = given().
                header("Content-Type","application/json").
                body(loginData).
                when().
                post("http://mall.lemonban.com:8107/login").
                then().
                log().all().extract().response();


}
    @DataProvider
    public Object[] getLoginDataFromExcel(){
        //1、读取Excel中的数据-EasyPOI
        File file = new File("src\\test\\resources\\testcase.xlsx");
        //读取Excel的参数配置，默认会读取所有的内容
        ImportParams importParams = new ImportParams();
        //设置开始读取sheet的位置，0-->第一个sheet
        importParams.setStartSheetIndex(0);

        List<ExcelPojo> data = ExcelImportUtil.importExcel(file, ExcelPojo.class,importParams);
        Object[] arr = data.toArray();
        return arr;
    }
}
