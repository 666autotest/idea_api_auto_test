package test;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.alibaba.fastjson.JSONObject;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.ApiDefinition.ApiCall;
import test.pojo.CaseData;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author luxi
 * @date 2021/10/25 0:39
 */
@Test(dataProvider = "getLoginDatasFromExcel")

public class DataFromExcel {
    //这是的数据类型世一个对象，而不是一个数据类型
    public void LoginDatas_from_excel(CaseData caseData){
        //调用登录接口请求
        Response res = ApiCall.login(caseData.getInputParams());
        //2.断言(此块代码可通用，抽取出来封装成一个方法。-->封装到testcase-->assertResponse()中
        String assertDatas = caseData.getAssertResponse();
        //{"statuscode":200,"nickName":"waiwai"}
        //2-1、断言为json字符串需转成Java的map(导入fastjson依赖)，1：fastjson 2：Jackson
        Map<String,Object> map =JSONObject.parseObject(assertDatas);
        //2-2、遍历Map
        Set<Entry<String,Object>> datas = map.entrySet();
        for(Entry<String,Object> keyValue : datas){
            //key:statuscode nickName  value:200,waiwai
            String key = keyValue.getKey();
            Object value = keyValue.getValue();
        //3、断言
        if("statuscode".equals(key)) {
            //获取接口响应状态码
            int statuscode = res.getStatusCode();
            System.out.println("断言响应状态码，期望值："+value+"实际值："+statuscode);
            Assert.assertEquals(statuscode,value);
        }else{
            //响应体数据断言
            //nickName -->相当于Gpath表达式
            Object actualValue = res.jsonPath().get(key);
            System.out.println("断言响应体字段，期望值："+value+"实际值："+actualValue);
            Assert.assertEquals(actualValue,value);
            //注：如需要加多组断言，只需在excel中添加断言项即可，代码不动

        }
        }

        /*
    这里的断言会因为数据类型不同导致断言失败，要通过json字符串转成java里map(数据类型加上大括号)
    String assertDatas = caseData.getAssertResponse();
        //statuscode:200,nickName:"waiwai"
        //通过","和":",来分割
        String[] datas01 = assertDatas.split(",");
        for (int i = 0; i < datas01.length; i++) {
            //分割后得到name和value，2组值
            String[] datas02 = datas01[i].split(":");
            String name = datas02[0];
            Object value = datas02[1];
            if(name.equals("statuscode")){
                //获取实际响应体字段对应的值(nickName)
                System.out.println("Value的类型"+value.getClass());
                //响应状态码
                Assert.assertEquals(res.getStatusCode(),value);
        }else{
                //获取实际响应体字段对应的值
                Assert.assertEquals(res.jsonPath().get(name),value);
            }
        }*/

    }
    @DataProvider
    public Object[] getLoginDatasFromExcel(){
    //1、读取Excel-->通过Easypoi(导入依赖)
        ImportParams importParams = new ImportParams();
        importParams.setStartSheetIndex(0);
        //Excel路径：src\test\resources\caseData.xlsx
        //读取Excel需要创建pojo实体类
        //通过集合接收数据
        List<CaseData> datas = ExcelImportUtil.importExcel(new File("src\\test\\resources\\caseData.xlsx"), CaseData.class,importParams);
        //集合转为数组
        return datas.toArray();
        //注入数据，指定数据源等于方法名：dataProvider = "getLoginDatasfromExcel"
    }
}
