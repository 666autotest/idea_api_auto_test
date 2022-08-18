package api_auto_test_java41.demoMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Map集合中的第二种遍历方式：使用Entry对象遍历
 * Map集合中的方法：
 *      Set<Map.entry<k,v>> entrySet(),返回映射中包含映射关系的Set试图
 *
 *  实现步骤：
 *      1.使用Map集合中的方法entryset(),把集合中多个entry对象提取出来，存储到一个set集合中
 *      2.遍历set集合，获取每一个entry对象
 *      3.使用entry对象中的方法getkey()和getvalue()获取键和值
 */
public class demo03entrySet {
    public static void main(String[] args) {
        //1.创建Map集合
        Map<String,Integer> map = new HashMap<>();
        //2.添加元素
        map.put("赵丽颖",168);
        map.put("杨颖",165);
        map.put("林志玲",178);
        //3.使用Map集合中的方法entryset(),把集合中多个entry对象提取出来，存储到一个set集合中
        Set<Map.Entry<String,Integer>> set = map.entrySet();
        //4.遍历set集合，获取每一个entry对象
        //使用迭代器遍历set集合
        Iterator<Map.Entry<String,Integer>> it=set.iterator();
        while (it.hasNext()){
            Map.Entry<String,Integer> entry = it.next();
            //5.使用Enrty对象中的getkey()和getvalue()获取键和值
            String key =entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key+""+value);
        }
        System.out.println("------------------");
        //增强for遍历
        for (Map.Entry<String,Integer> entry:set) {
            //使用Enrty对象中的getkey()和getvalue()获取键和值
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key+"="+value);

        }
    }
}
