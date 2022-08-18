package test.interfacecase;

import java.util.Random;

import static io.restassured.RestAssured.given;

/**
 * @author luxi
 * @date 2021/10/25 0:39
 */
public class registerTest_01 {
    public static void main(String[] args) {
        String phonelist="134";
        for (int i = 0; i <8 ; i++) {
            Random random=new Random();
            int sum = random.nextInt(9);
            phonelist=phonelist+sum;
        }
        System.out.println(phonelist);
        String jsonstr="{\"mobile_phone\":"+phonelist+",\"pwd\":\"12345678\",\"type\":1}";
        given().body(jsonstr).header("Content-Type","application/json").header("X-lemonban-Media-Type","lemonban.v1").
                when().post("http://api.lemonban.com/futureloan/member/register").
                then().log().all().extract().response();
    }
}
