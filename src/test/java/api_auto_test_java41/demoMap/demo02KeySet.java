package api_auto_test_java41.demoMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Map集合的第一种遍历方式：通过键找值
 * Map集合中的方法：
 *      Set<k> keySet() 返回映射中包含的键的Set视图
 *      实现步骤：
 *          1.使用Map集合中的方法keySet(),把Map集合所有的key取出来，存储到一个set集合中
 *          2.遍历set集合，获取map集合中的每一个key
 *          3.通过Map集合中的方法get(key)，通过key找value
 */
public class demo02KeySet {
    public static void main(String[] args) {
        //1.创建Map集合
        Map<String,Integer> map = new HashMap<>();
        //2.添加元素
        map.put("赵丽颖",168);
        map.put("杨颖",165);
        map.put("林志玲",178);

        //3.使用map集合中的keySet(),把Map集合中所有的key取出来，存储到一个set集合当中。
        Set<String> set =map.keySet();
        //4.遍历set集合，获取到Map集合中的每一个ke
        //使用迭代器遍历Set集合
        Iterator<String> it = set.iterator();
        while (it.hasNext()){
            String key = it.next();
            //3.通过Map集合中的方法get(key),通过key找到value
            Integer value = map.get(key);
            System.out.println(key+"="+value);
        }
        System.out.println("------------------------");
        //使用增强for遍历set结合
        for (String key : map.keySet()) {//用set也可以
            //2、通过map集合当中的get(key)，通过key找到值
            Integer value = map.get(key);
            System.out.println(key+","+value);

        }
    }
}
