package api_auto_test_java41.day08;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * @author qq音乐
 * @date 2022/7/2 - 2:24
 */
public class JsonHomeWork {
    public static void main(String[] args) throws IOException {
        /*第二道作业题
        将以下json字符串解析成java对象
        {"name":"黑龙江","capital":"哈尔滨"}
       */

/*      String jsonStr = "{\"name\":\"黑龙江\",\"capital\":\"哈尔滨\"}";
        ObjectMapper mapper = new ObjectMapper();
        JsonInfo jsoninfo = mapper.readValue(jsonStr,JsonInfo.class);
        System.out.println(jsoninfo.getName());
        System.out.println(jsoninfo.getCapital());*/

/*      第二道作业
        将以下json字符串解析成java对象
        { "name": "中国", "provinces": [{ "name": "黑龙江", "capital": "哈尔滨" },
        { "name": "广东", "capital": "广州" }, { "name": "湖南", "capital": "长沙" }] }*/
        ObjectMapper objectMapper = new ObjectMapper();
        //Student student = objectMapper.readValue(new File("data.json"),Student.class);
        Root student = objectMapper.readValue(new File("data.json"),Root.class);
        System.out.println(student.getName());
        System.out.println(student.getProvinces());
    }
}
