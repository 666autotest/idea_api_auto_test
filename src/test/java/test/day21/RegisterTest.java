
package test.day21;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RegisterTest {
   @Test
    @Parameters(value={"loginname","password"})
    public void registerSuccess(String loginname,String password){
        System.out.println("测试注册成功");
        System.out.println("测试的登录名："+loginname);
        System.out.println("测试的登录密码："+password);
    }
}

