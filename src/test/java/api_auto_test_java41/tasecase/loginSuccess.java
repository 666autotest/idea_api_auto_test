package api_auto_test_java41.tasecase;



import api_auto_test_java41.pojo.ExcelPojo;
import api_auto_test_java41.utils.ExcelUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.alibaba.fastjson.JSONObject;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.common.BaseTest;

import java.io.File;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;

public class loginSuccess extends BaseTest {
    @Test(dataProvider = "getLoginDataFromExcel")
    //读取Excel时，每一行数据都是一个excelDataPojo对象，所以这里的方法参数是对象
    public void test_login_Success(ExcelPojo excelPojo) {
        //准备测试数据
        //1.读取excel中的数据-->EasyPOI
        //File file = new File("src\\test\\resources\\testcase.xlsx");
        //2.读取Excel的参数配置，默认会读取所有的内容
        //ImportParams importParams = new ImportParams();
        //3.设置开始读取sheet的位置，0-->第一个sheet
        //importParams.setStartSheetIndex(0);
       //设置读取开始行数
        //importParams.setStartRows(0);
        //.设置读取总读取的行数
        //importParams.setReadRows(5);

        //List<ExcelDataPojo> datas = ExcelImportUtil.importExcel(file, ExcelDataPojo.class, importParams);
        //System.out.println(datas);

        //4.请求头header是json类型，这里传的是map类型，需转换
        Map<String, Object> map = JSONObject.parseObject(excelPojo.getHeaders());
        //5.发起接口请求
        Response res = request(excelPojo);


        //System.out.println("参数："+datas.get(0).getParams());//excel中的请求参数

        //6.期望响应结果{"statuscode":200,"nickName":"java_auto"}
/*
        String expectedValue = excelDataPojo.getExpectedValue();
        //6-1:xpectedValue是字符串类型，需要转成map
        Map<String,Object> expectedValueMap = JSONObject.parseObject(expectedValue);
        System.out.println("期望响应结果："+expectedValueMap);
        //实际响应结果
        int actualStatuscode = res.statusCode();
        String actualNickname = res.jsonPath().get("nickName");
        Assert.assertEquals(actualNickname,expectedValueMap.get("nickName"));
        Assert.assertEquals(actualStatuscode,expectedValueMap.get("statuscode"));
*/


        assertResponse(excelPojo,res);


    }

    //DataProvider数据驱动测试：如果不使用，只能读到Excel第一条数据
    @DataProvider

    public Object[] getLoginDataFromExcel() {
        //直接调用封装好的ExcelUtil.readExcel()方法
        return ExcelUtil.readExcel(0).toArray();

/*      已封装该方法到util-->ExcelUtil中
        //1、读取Excel中的数据-EasyPOI
        File file = new File("src\\test\\resources\\testcase.xlsx");
        //读取Excel的参数配置，默认会读取所有的内容
        ImportParams importParams = new ImportParams();
        //设置开始读取sheet的位置，0-->第一个sheet
        importParams.setStartSheetIndex(0);

        List<ExcelDataPojo> data = ExcelImportUtil.importExcel(file, ExcelDataPojo.class,importParams);

        //简写方式：return data.toArray();
        Object[] arr = data.toArray();
        return arr;
    }*/
    }

}
