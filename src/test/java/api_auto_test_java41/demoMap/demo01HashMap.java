package api_auto_test_java41.demoMap;

import java.util.HashMap;
import java.util.HashSet;

/**
 * java.util.Map<k,v>集合
 * Map集合的特点：
 *  1.Map集合是一个双列集合，一个元素包含2个值(一个Key,一个value).
 *  2.Map集合中的元素，key和value的数据类型可以相同，也可以不同
 *  3.Map集合中元素，key是不允许重复的，value可以重复
 *  4.Map集合中的元素，key和 value是对应
 *
 *  * HashMap集合的特点：是Map接口的实现类，底层是哈希表：查询速度特别快
 *
 *  *  1.HashMap集合是一个双列集合，一个元素包含2个值(一个Key,一个value).
 *  *  2.HashMap集合中的元素，key和value的数据类型可以相同，也可以不同
 *  *  3.HashMap集合中元素，key是不允许重复的，value可以重复
 *  *  4.HashMap集合中的元素，key和 value是对应
 *  *  5.HashMap是一个无序的集合，存储元素和取出元素顺序有可能不一致
 *
 * HashMap常用方法：
 * 1.entrySet():用来遍历集合
 * 2.keySet():用来遍历集合
 * 3.put():往集合中添加元素
 */
public class demo01HashMap {
    public static void main(String[] args) {
        show01();
    }

    /**
     *
     * pbulic V put(k key,v value):添加元素
     *  返回值 v
     *      存储键值对的时候，key不重复，返回v是null
     *      存储键值对时候，key重复,会使用新的value替换map中重复的value,返回被替换的value
     *
     *
     */

    public static void show01(){
        //1.创建HashMap集合对象
        HashMap<String,String> hashMap = new HashMap<>();

        //2.往集合中添加元素
        String v1 = hashMap.put("李晨","范冰冰1");
        System.out.println("V1:"+v1);//不重复，返回null


        //key重复,会使用新的value替换map中重复的value,返回被替换的value
        String v2 = hashMap.put("李晨","范冰冰2");
        System.out.println("V2:"+v2);//,key重复，范冰冰1

        System.out.println(hashMap);//{李晨=范冰冰2}

        //3.hashMap的value可以重复
        hashMap.put("杨过","小龙女");
        hashMap.put("尹志平","小龙女");
        hashMap.put("小猪","佩奇1");//后面添加的元素重复，前面的元素会被覆盖
        hashMap.put("小猪","佩奇2");
        System.out.println(hashMap);

        //4.remove():删除
        String remove1 = hashMap.remove("小龙女");
        System.out.println("remove1:"+remove1);//不存在元素返回null

        String remove2 = hashMap.remove("尹志平");
        System.out.println("remove2:"+remove2);//存在元素，删除成功
    }

}
