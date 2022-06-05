package test.common;

import com.alibaba.fastjson.JSONObject;
import io.restassured.response.Response;
import org.testng.Assert;
import test.util.JDBCUtils;

import java.util.Map;
import java.util.Set;

/**
 * @author luxi
 * @date 2021/10/25 0:39
 */
public class BaseTest {
    /**
     * 通用响应断言方法
     *
     * @param assertDatas Excel中的断言数据(Json格式设计)
     * @param res         接口响应结果
     */
    public void assertResponse(String assertDatas, Response res) {
        if (null != assertDatas) {
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

    public void assertDB(String assertDB) {
        //把原始的数据库断言数据（json）转成Map
        Map<String, Object> map = JSONObject.parseObject(assertDB);
        Set<Map.Entry<String, Object>> datas = map.entrySet();
        for (Map.Entry<String, Object> keyValue : datas) {
            //map里面的key就是我们的查询sql语句
            Object actualValue = JDBCUtils.quarySingData((keyValue.getKey()));
            System.out.println("实际值：" + actualValue.toString());
            System.out.println("期望值：" + keyValue.getValue().toString());
            //map里面的value就是我们的期望值
            Assert.assertEquals(actualValue.toString(), keyValue.getValue().toString());
            //数据匹配

        }
    }

}