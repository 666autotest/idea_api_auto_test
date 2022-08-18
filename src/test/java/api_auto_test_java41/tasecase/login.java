package api_auto_test_java41.tasecase;


import api_auto_test_java41.pojo.ExcelPojo;
import api_auto_test_java41.pojo.ExcelPojo;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.alibaba.fastjson.JSONObject;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.common.BaseTest;

import java.io.File;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;

public class login extends BaseTest {
    @Test(dataProvider = "getDataFromExcel")
    public void login(ExcelPojo excelPojo) {
/*        //1.登录
        //String loginData = "{\"principal\":\"java_auto\",\"credentials\":\"lemon123456\",\"appType\":3, \"loginType\":0 }";
        Response res = given().log().all().
                header("Content-Type", "application/json").
                body(excelDataPojo).
                when().
                post("http://mall.lemonban.com:8107/login").
                then().
                log().all().extract().response();
       */

        //把请求头的json字符串转成Map
        Map<String,Object> map = JSONObject.parseObject(excelPojo.getHeaders());
        //Response res = request(excelDataPojo.getMethod(),excelDataPojo.getUrl(),map,excelDataPojo.getParams());
        Response res = request(excelPojo.getMethod(),excelPojo.getUrl(),map,excelPojo.getParams());
        //断言
        assertResponse(excelPojo,res);
    }
    @DataProvider
    public Object[] getDataFromExcel(){
        //1.读取Excel-->导入Easypoi
        File file = new File("src\\test\\resources\\testcase.xlsx");
        //2.读取Excel的参数配置，默认会读取所有的内容
        ImportParams importParams  =new ImportParams();
        //3.设置开始读取sheet的位置，0-->第一个sheet
        importParams.setStartSheetIndex(0);
        //4.设置共读取几行数据
        //importParams.setReadRows(4);
        //5.设置从第几行数据开始读取,索引从0开始
        importParams.setStartRows(2);
        List<ExcelPojo> datas =ExcelImportUtil.importExcel(file, ExcelPojo.class,importParams);
/*        Object[] data = datas.toArray();
       return data;*/
        //简写
        return datas.toArray();

    }
    /**
     * REST-assured接口请求统一封装
     * @param method 请求方法
     * @param url 请求地址
     * @param map 请求头
     * @param params 请求参数
     * @return 响应数据
     */
    public static Response request(String method, String url, Map<String,Object> map, String params){
        //接口请求四大要素：请求方法、请求地址、请求头、请求参数
        Response res = null;
        //对请求方法判断
        if ("get".equals(method)){
            //get请求
            //对请求头进行判断，如果传过来的请求头为null，那么我们就不使用headers传入请求头
            if(map == null){
                res=given().log().all().when().get(url+"?"+params).
                        then().log().all().extract().response();
            }else {
                res=given().log().all().headers(map).when().get(url+"?"+params).
                        then().log().all().extract().response();
            }
        }else if("post".equals(method)){
            //post请求
            res=given().log().all().headers(map).body(params).when().post(url).
                    then().log().all().extract().response();
        }else if("put".equals(method)){
            //put请求
            res=given().log().all().headers(map).body(params).when().put(url).
                    then().log().all().extract().response();
        }else if("delete".equals(method)){
            //delete请求
            res=given().log().all().headers(map).body(params).when().delete(url).
                    then().log().all().extract().response();
        }
        return res;
    }
}