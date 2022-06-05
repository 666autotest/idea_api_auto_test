/*
package day01;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

*/
/**
 * @author luxi
 * @date 2021/10/25 0:39
 * 序列化：java对象转换为json/Yaml/XML
 * 反序列化：json/Yaml/XML对象转换为java对象
 *//*

public class JsonTest {
    public static void main(String[] args) throws JsonProcessingException {
        //1.实例化ObjectMapper对象
        ObjectMapper mapper = new ObjectMapper();
        //2.序列化java对象-->JSON/YAML/XML
        //JAVA对象对应的类型编写要求：类属性+get/set方法+无参构造/有参构造(student类)
        //3.生存java对象
        Student student = new Student("张三",20);
        //3.转换java对象———>json
        String jsonStr = mapper.writeValueAsString(student);
        System.out.println(jsonStr);

    }
}
*/
