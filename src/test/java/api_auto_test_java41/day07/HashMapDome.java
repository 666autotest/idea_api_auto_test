package api_auto_test_java41.day07;


import java.util.HashMap;
import java.util.Iterator;

/**
 * @author qq音乐
 * @date 2022/6/30 - 2:35
 */

//第二道作业题：
public class HashMapDome {
    public static void main(String[] args) {
        //1.创建HashMap对象{"id":"1","mobile_phone":"13212312312","pwd":"12312312"}
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id", "1");
        hashMap.put("mobile_phone", "13212312312");
        hashMap.put("pwd", "12312312");

        //2.判断Map中是否有mobile_phone键,如果有输出对应的值
        Iterator keys = hashMap.keySet().iterator();
        while (keys.hasNext()) {
            String key = (String) keys.next();
            if ("mobile_phone".equals(key)) {
                System.out.println(hashMap.get("mobile_phone"));
            } else {
                System.out.println("Map中没有有mobile_phone键");
            }

            //3.替换Map中pwd对应的值，替换为88888888
            hashMap.replace("pwd", 88888888);
            System.out.println(hashMap.get("pwd"));


        }
    }
}
