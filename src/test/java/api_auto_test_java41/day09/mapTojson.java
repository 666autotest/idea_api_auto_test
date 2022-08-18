package api_auto_test_java41.day09;

//map和json互转
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;

public class mapTojson {
    public static void main(String[] args) throws JsonProcessingException {
        //1.创建HashMap对象
        HashMap<String,Integer> hashMap = new HashMap<String,Integer>();
        //2.往hashMap中添加数据
        hashMap.put("杨过",18);
        hashMap.put("小龙女",28);
        System.out.println(hashMap);
        //3.创建ObjectMapper对象
        ObjectMapper objectMapper = new ObjectMapper();
        //4.用map里writeValueAsString，把map装错json,用String 类型接收
        String json = objectMapper.writeValueAsString(hashMap);
        System.out.println(json);

        //5.json转map
        Map<String, Object> testMap = objectMapper.readValue(json, Map.class);
        System.out.println(testMap);



    }
}
