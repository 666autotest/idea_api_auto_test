package api_auto_test_java41.day18;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @author qq音乐
 * @date 2022/7/15 - 18:29
 */
public class RegisterTest {
    @Test
    @Parameters(value = {"phone","password"})
    public void regisSuccess(String phone,String password){
        System.out.println("测试注册成功");
        System.out.println("测试的手机号码:"+phone);
        System.out.println("测试密码:"+password);

    }
}
