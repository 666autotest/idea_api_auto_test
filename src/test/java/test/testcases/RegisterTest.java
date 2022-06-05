package test.testcases;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.ApiDefinition.ApiCall;
import test.common.BaseTest;
import test.util.Environment;
import test.util.JDBCUtils;
import test.util.RandomDataUtil;

import java.util.Random;

/**
 * @author luxi
 * @date 2021/10/25 0:39
 */
public class RegisterTest extends BaseTest {
        @Test
        public void test_register_success(){
        //随机生成一个手机验证码
        String randomPhone  = RandomDataUtil.getUnregisterPhone();
        String randomName = RandomDataUtil.getUnregisterName();
        Environment.saveToEnvironment("randomPhone",randomPhone);
        Environment.saveToEnvironment("randomName",randomName);
        //1.发起验证码接口
        String data01 = "{\"mobile\":\"#randomPhone#\"}";
        ApiCall.sendRegisterSms(data01);
        //2.校验验证码接口
        //通过数据库tz_sms_log-->java代码查询数据库
        String sql = "select mobile_code from tz_sms_log where id = (select MAX(id) from tz_sms_log);";
        String code = (String)JDBCUtils.quarySingData(sql);
        //将验证码保存到环境变量中
        Environment.saveToEnvironment("code",code);
        String data02 = "{\"mobile\":\"#randomPhone#\",\"validCode\":\"#code#\"}";
        Response checkRes = ApiCall.checkRegisterSms(data02);
        //3.拿到接口响应文本类型数据
        String checkSms = checkRes.body().asString();
        //将校验的字符串保存到环境变量中
        Environment.saveToEnvironment("checkSms",checkSms);

        //4.注册接扣请求
        String data03 = "{\"appType\":3,\"checkRegisterSmsFlag\":\"#checkSms#\"," +
                "\"mobile\":\"#randomPhone#\",\"userName\":\"#randomName#\",\"password\":\"123456\"," +
                "\"registerOrBind\":1,\"validateType\":1}";
        Response registerRes = ApiCall.register(data03);
        System.out.println(registerRes.getStatusCode());
        //5.响应断言
         Assert.assertEquals(registerRes.getStatusCode(),200);
         Assert.assertEquals(registerRes.jsonPath().get("nickName"),randomName);

         //6.数据库断言
         String assertSql = "select count(*) from tz_user where user_mobile = '#randomPhone#';";
         long actual = (long)JDBCUtils.quarySingData(assertSql);
         Assert.assertEquals(actual,1);
        }
}
