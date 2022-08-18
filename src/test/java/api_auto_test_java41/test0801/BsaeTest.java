package api_auto_test_java41.test0801;

import api_auto_test_java41.pojo.ExcelPojo;
import com.alibaba.fastjson.JSONObject;
import io.restassured.response.Response;
import org.testng.Assert;
import test.common.BaseTest;

import java.util.Map;
import java.util.Set;

import static io.restassured.RestAssured.given;

/**
 * @author qq音乐
 * @date 2022/7/18 - 0:37
 */

/**
 *所有测试类的统一父类
 *
 *
 */

public class BsaeTest {


    /**
     * 通用断言方法
     *
     * @param assertData Excel中断言数据(JSON格式设计)
     * @param res        接口响应结果
     */
/*    public void assertResponse(String assertData, Response res) {

        //判空处理，当从Excel读取的响应数据为空的时候，表示不需要断言
        if (null != assertData) {
            //,{"statuscode":200,"nickName":"waiwai"}
            //json字符串里的Java转map,通过1:FastJson  2:Jackson
            Map<String, Object> map = JSONObject.parseObject(assertData);
            //遍历Map
            Set<Map.Entry<String, Object>> data = map.entrySet();
            for (Map.Entry<String, Object> KeyValue : data) {
                String key = KeyValue.getKey();
                Object value = KeyValue.getValue();
                //3-3断言
                if ("statuscode".equals(key)) {
                    //获取响应状态码
                    int statuscode = res.getStatusCode();
                    System.out.println("断言响应状态码，期望值：" + value + "实际值：" + statuscode);
                    Assert.assertEquals(statuscode, value);
                } else {
                    //获取响应体数据
                    //nickName-->相当于Gpath表达式
                    Object actualValue = res.jsonPath().get(key);
                    System.out.println("断言响应体字段，期望值：" + value + "实际值：" + actualValue);
                    Assert.assertEquals(actualValue, value);
                }
            }*/

}

