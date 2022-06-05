package test.day21;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author luxi
* 解析：
* 1.testng.xml只能传递简单的参数，如果是循环遍历的使用不同的参数则可以通过DataProvider（数据提供者）
* 2.Dataprovider：通过DataProvider：（利用此注解标注一个方法返回参数，返回值为一个Object类型的二维数组，* 若没有声明则为方法名。在测试方法上引用此dataprovider时需要指向对应的name值）
*
*/

public class DataproviderTest {
   //通过dataProvider(数据提供者)将getDatas()发方法里的数据提供过来
    @Test(dataProvider ="getDatas")
   public void login(String loginname,String password){
        System.out.println("用户名："+loginname);
        System.out.println("用户密码："+password);

    }
   //通过这个方法存储测试用例所需的数据(数据提供者)
   @DataProvider
   public Object[][] getDatas(){
       //数据提供者：要求数据格式为Object[][]
       Object[][] datas={
               {"路飞","123456"},
                {"索隆","123456"},
               {"山治","123456"},
                {"乔巴",""},
        };
        return datas;
    }
}

