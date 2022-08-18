package api_auto_test_java41.tasecase;


import api_auto_test_java41.data.Environment;
import api_auto_test_java41.utils.RandomUtil;
import test.common.BaseTest;
import api_auto_test_java41.pojo.ExcelPojo;
import api_auto_test_java41.utils.DBUtil;
import api_auto_test_java41.utils.ExcelUtil;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.common.BaseTest;
import test.util.RandomDataUtil;

import java.util.Locale;

public class registerTest extends BaseTest {
    private String randomphone;
    @BeforeClass
    public void setup(){
        //前置准备工作
        //1、生成一个没有被注册的手机号码
        randomphone = RandomUtil.getUnregisterPhone();
        //2、生成一个没有被注册的用户名
        String randomname = RandomUtil.getUnregisterUser();
        //3、将数据保存到环境变量中，提供给后面接口使用
        Environment.var.put("randomphone",randomphone);
        Environment.var.put("randomname",randomname);
    }

    @Test(dataProvider = "getDatas")
    public void test_register(ExcelPojo excelPojo){
        //发起接口请求
        Response res = request(excelPojo);
        //断言
        assertResponse(excelPojo,res);
        //提取响应字段
        extracToEnv(excelPojo,res);
        //数据库断言
        //assertDB(excelPojo);

        //在第一条接口请求结束之后通过查询数据库获取短信验证码
        //判断是否是第一条接口请求（发送短信验证码接口请求）
        if (excelPojo.getCaseId() == 1){
            //查询数据库
            Object result = DBUtil.querySingledata("select mobile_code from tz_sms_log " +
                    "where user_phone='"+randomphone+"' ORDER BY rec_date DESC LIMIT 1");
            //保存到环境变量中
            Environment.var.put("verifycode",result);
        }
    }

    @DataProvider
    public Object[] getDatas(){
        //把集合转换为一维Object数组
        return ExcelUtil.readExcel(5).toArray();
    }
    }

