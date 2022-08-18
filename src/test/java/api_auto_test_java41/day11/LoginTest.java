package api_auto_test_java41.day11;

import org.junit.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author qq音乐
 * @date 2022/7/8 - 22:10
 */
public class LoginTest {
    /*
  1、请实现以下功能测试代码：

（1）有LoginTest与RegisterTest两个测试类

（2）在所有测试类运行之前打印输出：全局初始化操作

（3）在测试类LoginTest运行之前打印输出：登录测试类执行开始

（4）在测试方法loginSuccess()运行之前打印输出：登录测试方法执行开始

（5）在测试方法loginSuccess()运行之后打印输出：登录测试方法执行结束

（6）在测试类LoginTest运行之后打印输出：登录测试类执行结束
*/
    @BeforeClass
    public void setupClass(){
        System.out.println("登录测试类执行开始");
    }
    @BeforeMethod
    public void setupMethod(){
        System.out.println("登录测试方法执行开始");
    }
    @Test
    public void loginSuccess(){
        System.out.println("登录测试方法执行");
    }
    @AfterMethod
    public void teardownMethod(){
        System.out.println("登录测试方法结束");
    }
    @AfterClass
    public void teardownClass(){
        System.out.println("登录测试类执行结束");
    }
}
