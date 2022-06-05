
package test.day21;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


/**
 * @author luxi
 * @date 2021/10/25 0:39
 * @Test作用：@Test是一种测试方法，该方法不需要main就可以运行
 *
 * 注意：测试方法的执行顺序是按方法名的首字母的优先级排序
 */

public class TestngTest {
    @AfterMethod
    public void tesrdownClass(){
        System.out.println("测试类之后执行");
    }
    @AfterMethod
    public void setupClass(){
        System.out.println("测试类之前执行");
    }

    @BeforeMethod
    //测试方法之前执行，比如执行测试用例前先登录
    //有几个测试方法，setupMethod就会执行几次
    public void setupMethod(){
        System.out.println("测试方法之前执行");
    }
    @Test(priority = 1)//tesgng框架的注解，由testng单独执行该方法，不需要main执行
    public void loginSuccess(){
        System.out.println("测试登录成功");
    }
    @Test(priority = 2)
    //测试完成之后的清除工作，如：清除垃圾数据
    public void taerMethod(){
        System.out.println("测试之后执行");

    }
    @Test(priority = 3)//测试方法执行顺序，值越大，执行顺序越低
    public void loginFail(){
        System.out.println("测试登录失败");
    }

}

