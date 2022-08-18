package api_auto_test_java41.day09;

import api_auto_test_java41.day08.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class arrayToJson {
    public static void main(String[] args) throws JsonProcessingException {
        //1.将以下json字符串转换为YAML
        String jsonStr= "{ \"name\": \"中国\", \"provinces\": [{ \"name\": \"黑龙江\", \"capital\": \"哈尔滨\" }, { \"name\": \"广东\", \"capital\": \"广州\" }, { \"name\": \"湖南\", \"capital\": \"长沙\" }] }";
        ObjectMapper objectMapper = new ObjectMapper();

        //2.把json字符串转换为java对象
        Root1 root1 = objectMapper.readValue(jsonStr, Root1.class);
        System.out.println("root1:"+root1);

        //3.对象转数组
        byte[] byteArr = objectMapper.writeValueAsBytes(root1);
        System.out.println(byteArr);

    }
}