package test.testcases;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.alibaba.fastjson.JSONObject;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.ApiDefinition.ApiCall;
import test.common.BaseTest;
import test.pojo.CaseData;
import test.util.ExcelUtil;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static io.restassured.RestAssured.given;
import static org.apache.commons.lang3.ArrayUtils.toArray;

/**
 * @author luxi
 * @date 2021/10/25 0:39
 */
public class LoginTest extends BaseTest {
    @Test
    public void test_Login_succes() {
        //1.准备参数
        String jsonData = "{\"principal\":\"waiwai\",\"credentials\":\"lemon123456\",\"appType\":3,\"loginType\":0}";
        //2.调用apicall里的logon接口请求
        Response res = ApiCall.login(jsonData);
        //3.断言
        String nickName = res.jsonPath().get("nickName");
        Assert.assertEquals(nickName, "waiwai");
        //2.断言
        //注：一条断言失败，后面的断言不会执行;token值不能拿来做断言，因为每次登录token都会变
        int statusCode = res.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @Test(dataProvider = "getLoginDatasFromExcel")
    public void getLoginDatasFromExcel(CaseData caseData) {
        //1、准备测试数据
        //String jsonData="{\"principal\":\"waiwai\",\"credentials\":\"lemon123456\",\"appType\":3,\"loginType\":0}";
        //2、直接调用登录的接口请求
        Response res = ApiCall.login(caseData.getInputParams());
        //3、断言
        String assertDatas = caseData.getAssertResponse();
        //{"statuscode":200,"nickName":"waiwai"}
        //3-1、json字符串转成map-->1:FastJson 2:Jackson
        Map<String,Object> map =JSONObject.parseObject(assertDatas);
        //3-2遍历map
        Set<Map.Entry<String,Object>> datas = map.entrySet();
        for (Map.Entry<String,Object> keyValue : datas){
            System.out.println(keyValue.getKey());
            System.out.println(keyValue.getValue());
            String key = keyValue.getKey();
            Object value = keyValue.getValue();
            //3-3断言
            if ("statuscode".equals(key)){
                //获取接口响应状态码
               int statuscode = res.getStatusCode();
                System.out.println("断言响应状态码，期望值："+value+"实际值："+statuscode);
               Assert.assertEquals(statuscode,value);
            }else{
                //响应体数据断言(如果需要加断言，只需要往EXCEL添加即可，代码不变)
                Object actuaValue = res.jsonPath().get(key);
                System.out.println("断言响应体字段，期望值"+value+"实际值"+actuaValue);
                Assert.assertEquals(actuaValue,value);
            }
        }
    }
    //数据提供者
    @DataProvider
    public Object[] getLoginDatasFromExcel() {
        //1、读取Excel-->通过Easypoi(导入依赖)
        ImportParams importParams = new ImportParams();
        importParams.setStartSheetIndex(0);
        //读取文件Excel路径:src\test\resources\caseData.xlsx//读取Excel需要创建pojo实体类
        //通过集合接收数据
        List<CaseData> datas = ExcelImportUtil.importExcel(new File("src\\test\\resources\\caseData.xlsx"), CaseData.class, importParams);
        //集合转成一维数组
        return datas.toArray();

    }



    /**
     * 通用响应断言方法
     *
     * @param assertDatas Excel中的断言数据(Json格式设计)
     * @param res         接口响应结果
     */

    public void assertResponse(String assertDatas, Response res) {
        //{"statuscode":200,"nickName":"waiwai"}
        //2-1、断言为json字符串需转成Java的map(导入fastjson依赖)，1：fastjson 2：Jackson
        Map<String, Object> map = JSONObject.parseObject(assertDatas);
        //2-2、遍历Map
        Set<Map.Entry<String, Object>> datas = map.entrySet();
        for (Map.Entry<String, Object> keyValue : datas) {
            //key:statuscode nickName  value:200,waiwai
            String key = keyValue.getKey();
            Object value = keyValue.getValue();
            //3、断言
            if ("statuscode".equals(key)) {
                //获取接口响应状态码
                int statuscode = res.getStatusCode();
                System.out.println("断言响应状态码，期望值：" + value + "实际值：" + statuscode);
                Assert.assertEquals(statuscode, value);
            } else {
                //响应体数据断言
                //nickName -->相当于Gpath表达式
                Object actualValue = res.jsonPath().get(key);
                System.out.println("断言响应体字段，期望值：" + value + "实际值：" + actualValue);
                Assert.assertEquals(actualValue, value);
                //注：如需要加多组断言，只需在excel中添加断言项即可，代码不动

            }
        }
    }
}

