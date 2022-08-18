package api_auto_test_java41.test0801;

import api_auto_test_java41.pojo.ExcelPojo;
import api_auto_test_java41.pojo.ExcelPojo;
import com.alibaba.fastjson.JSONObject;
import io.restassured.response.Response;

import java.util.Map;

/**
 *
 * 响应断言封装
 *
 */
public class AssertResponse {
    public void assertResponse(ExcelPojo excelDataPojo, Response res) {
        //判断响应结果是否为空
        if (excelDataPojo.getExpectedValue() != null) {
            //1.期望响应结果{"statuscode":200,"nickName":"java_auto"}
            String expectedValue = excelDataPojo.getExpectedValue();
            //1-1:xpectedValue是字符串类型，需要转成map
            Map<String, Object> expectedValueMap = JSONObject.parseObject(expectedValue);

            //2.实际响应结果
            int actualStatuscode = res.statusCode();
            String actualNickname = res.jsonPath().get("nickName");
            org.testng.Assert.assertEquals(actualNickname, expectedValueMap.get("nickName"));
            org.testng.Assert.assertEquals(actualStatuscode, expectedValueMap.get("statuscode"));
        }
    }
}