package test.testcases;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

/**
 * @author luxi
 * @date 2021/10/25 0:39
 */
public class MockTest {
    @Test
    public void test_mock() {
        String inputParams = "{\t\t\t\t\"mobile_phone\":\"13612957120\",\n" +
                "\t\t\t\t\"pwd\":\"123456\"}";
        Map<String,Object> map = new HashMap<>();
        map.put("Content-Type","application/json");
        map.put("X-Lemonban-Media-Type","lemonban.v1");

        given().
                log().all().
                headers(map).
                body(inputParams).
        when().
                post("http://127.0.0.1:9999/login").
        then().
                log().all().extract().response();


    }

}
