package api_auto_test_java41.tasecase;

import api_auto_test_java41.pojo.ExcelPojo;
import api_auto_test_java41.data.Environment;
import api_auto_test_java41.utils.DBUtil;
import api_auto_test_java41.utils.ExcelUtil;
import com.alibaba.fastjson.JSONObject;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.common.BaseTest;

import java.util.Map;
import java.util.Set;

import static api_auto_test_java41.tasecase.login.request;

public class PlaceOrdeTest extends BaseTest {
    @BeforeClass//测试类执行之前把prodName，从数据库查询出来然后保存到环境变量中
    public void setup(){
        //测试前置工作
        //执行sql语句生成所需要的商品数据
        Object data = DBUtil.querySingledata("SELECT t1.prod_name FROM tz_prod t1,tz_sku t2 WHERE t1.prod_id=t2.prod_id AND t1.status=1 \n" +
                "AND t1.seckill_activity_id=0 AND t1.group_activity_id =0 AND t2.stocks>20 LIMIT 1;");
        //把数据保存到环境变量中
        Environment.var.put("prodName",data);
    }

    @Test(dataProvider = "getDatas")
    public void placeorder(ExcelPojo excelPojo) {
        //1.发起接口请求
        Response res = request(excelPojo);
        //2.响应断言
        assertResponse(excelPojo,res);
        //3.解析响应体字段保存到环境变量中
        extracToEnv(excelPojo,res);
        //4.数据库断言
        assertDB(excelPojo);
    }
    @DataProvider
    public Object[] getDatas(){
        //把集合转为一维Object[]以为数组
        return ExcelUtil.readExcel(3).toArray();

    }
}
