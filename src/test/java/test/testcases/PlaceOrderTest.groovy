package test.testcases

import io.restassured.response.Response
import org.testng.Assert
import org.testng.annotations.Test
import test.ApiDefinition.ApiCall
import test.service.BusinessFlow
import test.util.Environment
import test.util.JDBCUtils


/**
 * @author luxi* @date 2021/10/25 0:39
 */

public class PlaceOrderTest {
    @Test
    public void test_place_order_success(){
        Response prodInfoRes = BusinessFlow.login_search_info();
        //获取库存ID
        Environment.saveToEnvironment("skuId",prodInfoRes.jsonPath().get("skuList[0].skuId"));
        //1、确认订单
        String confirmDatas = "{\"addrId\":0,\"orderItem\":{\"prodId\":#prodId#,\"skuId\":#skuId#," +
                "\"prodCount\":1,\"shopId\":1},\"couponIds\":[],\"isScorePay\":0," +
                "\"userChangeCoupon\":0,\"userUseScore\":0," +
                "\"uuid\":\"c3b16d57-6683-4ad2-8bc6-7aeee5e79936\"}";
        Response confirmRes = ApiCall.confirmOrder(confirmDatas,"#token#");
        //2、提交订单
        String submitData = "{\"orderShopParam\":[{\"remarks\":\"\",\"shopId\":1}]," +
                "\"uuid\":\"c3b16d57-6683-4ad2-8bc6-7aeee5e79936\"}";
        Response submitRes = ApiCall.submitoOrder(submitData,"#token#");
        //获取订单号
        String orderNumbers = submitRes.jsonPath().get("orderNumbers");
        Environment.saveToEnvironment("orderNumbers",orderNumbers);
        //3、下单
        String placeOrderData = "{\"payType\":3,\"orderNumbers\":\"#orderNumbers#\"}";
        Response placeOrderRes = ApiCall.placeorder(placeOrderData,"#token#");
        /*String payNo = (String) JDBCUtils.querySingleData("SELECT pay_no FROM tz_order_settlement_history WHERE order_number= '#orderNumbers#';");
        Environment.saveToEnvironment("payNo",payNo);*/
        //4、模拟回调 --模拟真实的支付流程
       String mockPayData="{\n" +
                "    \"payNo\":#orderNumbers#, \n" +
                "    \"bizPayNo\":\"XXXX\",\n" +
                "    \"isPaySuccess\":true\n" +
                "}";
        Response mockPayRes = ApiCall.mockPay(mockPayData,"#token#");
        //1、响应断言
        //提取纯文本响应体数据
        String actual = mockPayRes.body().asString();
        Assert.assertEquals(actual,"success");
        //2、数据库断言
        String sql = "SELECT status FROM tz_order WHERE order_number=#orderNumbers#;";
        Object actualDB = JDBCUtils.quarySingData(sql);
        Assert.assertEquals(actualDB,2);
    }
}
