package api_auto_test_java41.tasecase;


import api_auto_test_java41.pojo.ExcelPojo;
import api_auto_test_java41.pojo.ExcelPojo;
import api_auto_test_java41.utils.ExcelUtil;
import com.alibaba.fastjson.JSONObject;
import io.restassured.response.Response;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.common.BaseTest;

import java.util.Map;

import static io.restassured.RestAssured.request;

/**
 * @author qq音乐
 * @date 2022/7/14 - 23:11
 */


public class LoginTest extends BaseTest {
    @Test(dataProvider = "getLoginDataFromExcel")
    public void test_login_success(ExcelPojo excelPojo){
        //4.请求头header是json类型，这里传的是map类型，需转换
        Map<String, Object> map = JSONObject.parseObject(excelPojo.getHeaders());
        System.out.println(excelPojo);
        //5.发起接口请求
        request(excelPojo);

/*   //优化前的代码
        String loginData = "{\"principal\":\"waiwai\",\"credentials\":\"lemon123456\",\"appType\":3,\"loginType\":0}";
        Response res =
        given().header("Content-Type","application/json").
                body(loginData).

        when().
                post("http://mall.lemonban.com:8107/login ").
        then().
        log().all().extract().response();

        int statusCode = res.statusCode();
        Assert.assertEquals(statusCode,200);
        String nickName = res.jsonPath().get("nickName");
        Assert.assertEquals(nickName,"waiwai");

       //1.获取响应状态码
        System.out.println(res.getStatusCode());
        //2.获取所有响应头，res.headers()因为重写了图String，所以可以打印出来
        System.out.println(res.headers());
        //3.获取用户名(需强转成String类型，否则会报错)
        System.out.println((String)res.jsonPath().get("nickName"));
        //4.复杂字段获取：获取json数组第一个元素，prodName字段，-2代表倒数第二个元素
        // System.out.println((String) res.jsonPath().get("records[0].prodName"));
        // System.out.println((String) res.jsonPath().get("records[-2].prodName"));
        //5.获取接口响应时间
        System.out.println(res.time());
        //5.获取指定响应头字段
        System.out.println(res.getHeader("Content-Type"));*/


        //优化后的代码
        //1.准备测试数据
        //String jsonData = "{\"principal\":\"waiwai\",\"credentials\":\"lemon123456\",\"appType\":3,\"loginType\":0}";
        //2.直接调用封装好的登录接口请求
        //Response res = ApiCall.login(caseData.getImportParams());
        //3.断言
        //String assertData = caseData.getResponseAssert();
        //assertResponse(assertData,res);



        /*(已封装到BaseTest类中)
        {"statuscode":200,"nickName":"waiwai"}
        //json字符串里的Java转map,通过1:FastJson  2:Jackson
        Map<String,Object> map = JSONObject.parseObject(assertData);
        //遍历Map
        Set<Map.Entry<String,Object>> data = map.entrySet();
        for (Map.Entry<String,Object> KeyValue:data) {
            String key = KeyValue.getKey();
            Object value = KeyValue.getValue();
        //3-3断言
            if ("statuscode".equals(key)){
                //获取响应状态码
               int statuscode =  res.getStatusCode();
                System.out.println("断言响应状态码，期望值："+value+"实际值："+statuscode);
               Assert.assertEquals(statuscode,value);
            }else{
                //获取响应体数据
                //nickName-->相当于Gpath表达式
                Object actualValue = res.jsonPath().get(key);
                System.out.println("断言响应体字段，期望值："+value+"实际值："+actualValue);
                Assert.assertEquals(actualValue,value);
            }
        }*/



        /*      优化前的代码
        int statusCode = res.statusCode();
        Assert.assertEquals(statusCode,200);
        String nickName = res.jsonPath().get("nickName");
        Assert.assertEquals(nickName,"waiwai");*/


/*不需要的代码
        //statuscode:200,nickName:"waiwai"
        String[] data01 = assertData.split(",");
        for (int i = 0; i < data01.length; i++) {
            String[] data02 = data01[i].split(":");
            String name = data02[0];
            Object value = data02[1];
            if (name.equals("statuscode")){
                System.out.println("value的数据类型"+value.getClass());
                Assert.assertEquals(res.getStatusCode(),value);
            }else{
                //获取实际响应体字段对应的值(nickName)
                Assert.assertEquals(res.jsonPath().get(name),value);
            }
        }*/

    }

    @DataProvider
    public Object[] getLoginDataFromExcel() {
/*      已封装到  ExcelUtil.readExcel()中
        //1.读取Excel-->导入Easypoi
        ImportParams importParams = new ImportParams();
        importParams.setStartSheetIndex(0);
        //读取的文件路径：src\test\resources\caseData.xlsx
        List<CaseData> data = ExcelImportUtil.importExcel(new File("src\\test\\resources\\caseData.xlsx"),CaseData.class,importParams);
        //集合转数组*/
        return ExcelUtil.readExcel(0).toArray();

    }
}
