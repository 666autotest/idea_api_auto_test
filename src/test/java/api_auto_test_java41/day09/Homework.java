package api_auto_test_java41.day09;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

/**
 * @author qq音乐
 * @date 2022/7/5
 */

public class Homework {
    public static void main(String[] args) throws IOException {
        //1.将以下json字符串转换为YAML
        String jsonStr= "{ \"name\": \"中国\", \"provinces\": [{ \"name\": \"黑龙江\", \"capital\": \"哈尔滨\" }, { \"name\": \"广东\", \"capital\": \"广州\" }, { \"name\": \"湖南\", \"capital\": \"长沙\" }] }";
        ObjectMapper objectMapper = new ObjectMapper();

        //2.把json字符串转换为java对象
        Root1 root1 = objectMapper.readValue(jsonStr, Root1.class);
        System.out.println("root1:"+root1);

        //java对象转成json字符串
        jsonStr=objectMapper.writeValueAsString(root1);
        System.out.println("jsonStr:"+jsonStr);

        //3.把java对象转换为YAML
        ObjectMapper objectMapper1 = new ObjectMapper(new YAMLFactory());
        objectMapper1.writeValue(new File("src\\test\\resources\\homework.yaml"),root1);

    }
}
