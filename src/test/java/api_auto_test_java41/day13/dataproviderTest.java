package api_auto_test_java41.day13;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author qq音乐
 * @date 2022/7/15 - 19:03
 */
public class dataproviderTest {
    @Test(dataProvider = "getDatas")
    public void login(String phone,String password){
        System.out.println("手机号码是："+phone);
        System.out.println("密码是："+password);
    }
    @DataProvider
    public Object[][] getDatas() {
        //数据提供者，要求数据格式Object[][]
        Object[][] datas = {
                {"13323234545", "123456"},
                {"13323234546", "123456"},
                {"13323234547", "123456"},
        };
        return datas;
    }
}
