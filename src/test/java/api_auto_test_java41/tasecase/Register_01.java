package api_auto_test_java41.tasecase;

import api_auto_test_java41.pojo.ExcelPojo;
import api_auto_test_java41.utils.ExcelUtil;
import com.alibaba.fastjson.JSONObject;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.common.BaseTest;

import java.util.Locale;
import java.util.Map;

import static test.common.BaseTest.request;

public class Register_01 extends BaseTest {
    @BeforeClass
    public void setup(){
        //前置准备工作
        //生成一个手机号码-->查询数据库-->数据库中有这个信息再生成
        //SELECT count(*) from tz_user where user_mobile = '13612957129';
        Faker faker = new Faker(Locale.CHINA);
        String randomphone = faker.phoneNumber().cellPhone();
    }

    @Test (dataProvider = "getData")
    public void test_login_success(ExcelPojo excelPojo) {
        //发起接口请求
        Response res = request(excelPojo);
        assertResponse(excelPojo,res);
    }

    @DataProvider
    public Object[] getData() {
/*      已封装到  ExcelUtil.readExcel()中
        //1.读取Excel-->导入Easypoi
        ImportParams importParams = new ImportParams();
        importParams.setStartSheetIndex(0);
        //读取的文件路径：src\test\resources\caseData.xlsx
        List<CaseData> data = ExcelImportUtil.importExcel(new File("src\\test\\resources\\caseData.xlsx"),CaseData.class,importParams);
        //集合转数组*/
        return ExcelUtil.readExcel(0).toArray();

    }

    public static void main(String[] args) {
        //创建faker对象,Locale.CHINA代表中国地区
        Faker faker = new Faker(Locale.CHINA);
        System.out.println(faker.phoneNumber().cellPhone());;


    }
}
