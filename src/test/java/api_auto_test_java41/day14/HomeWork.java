package api_auto_test_java41.day14;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import test.ApiDefinition.ApiCall;
import test.common.BaseTest;

import java.security.Key;

import static io.restassured.RestAssured.given;

/**
 * @author qq音乐
 * @date 2022/7/20 - 22:34
 */
public class HomeWork extends BaseTest {
    /**
     * 登录接口请求
     */
    @Test
    public void login() {
        String data = "{\"principal\":\"java_auto\",\"credentials\":\"lemon123456\",\"appType\":3, \"loginType\":0 }";
        given().
                header("Content-Type", "application/json").
                body(data).
                when().
                post("http://mall.lemonban.com:8107/login").
                then().
                log().all();
        //Response res = ApiCall.login(data);
    }

    /**
     * 搜索商品接口请求
     */
    @Test
    public void searchProduct() {
        given().
        when().
                get("http://mall.lemonban.com:8107/search/searchProdPage?prodName=文具").
        then().
                log().all();
    }
    /**
     * 商品信息接口请求
     */
    @Test
    public void productInfo() {
        Response res =
        given().
                header("Content-Type", "application/json").
                when().
                get("http://mall.lemonban.com:8107/prod/prodInfo?prodId=355").
                then().
                log().all().extract().response();

    }
    /**
     * 添加购物车
     */
    @Test
    public void addShopCar() {
        String inputParam = "{\"basketId\":0,\"count\":1,\"prodId\":\"355\",\"shopId\":1,\"skuId\":7478}";
        given().
                header("Content-Type", "application/json").
                header("Authorization","bearer471c5519-ad16-452a-946f-2977304b8907").
                body(inputParam).
                when().
                post("http://mall.lemonban.com:8107/p/shopCart/changeItem").
                then().
                log().all();
    }
    /**
     * 下单
     */
    @Test
    public void playOrder() {
        String inputParam = "{\"orderShopParam\":[{\"remarks\":\"\",\"shopId\":1}],\"uuid\":\"ad9ecd67-83ee-48d3-92be-c1913f08f126\"}";
        given().
                header("Content-Type", "application/json").
                header("Authorization","bearer7bcae99a-0f5e-4335-92dd-cea6bb1be190").
                body(inputParam).
                when().
                post("http://mall.lemonban.com:8107/p/order/submit").
                then().
                log().all();
    }
}