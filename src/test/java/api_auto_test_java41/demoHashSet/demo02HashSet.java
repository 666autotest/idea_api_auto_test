package api_auto_test_java41.demoHashSet;

import java.util.HashSet;
import java.util.Iterator;

/**
 *set集合存储元素（String.Integer,student,person）必须重写Hashcode和equals方法
 * 使用HashSet存储数据一定要在实体类中定义HashCode()和equals()
 * 已保证同名同年龄的人只能存一次
 *
 * HashSet:无序，无索引，数据不可重复
 */
public class demo02HashSet {
    public static void main(String[] args) {
        //2.创建hashSet对象
        HashSet<String> hashSet = new HashSet<>();

        //2.通过add(),往集合中添加元素
        hashSet.add("Hello");
        hashSet.add("World");
        System.out.println(hashSet);

        //3.remove：移除集合中的指定元素元素
        boolean remove = hashSet.remove("你好");
        boolean remove1 = hashSet.remove("World");
        System.out.println(remove);//集合中不存该数据，返回false
        System.out.println(hashSet);//Hello

        //4.clear:移除集合中的所有元素
        hashSet.clear();
        System.out.println(hashSet);//返回[]

        //5.isEmpty:判空,如果此 set 不包含任何元素，则返回 true。
        boolean empty = hashSet.isEmpty();
        System.out.println(empty);//true

        hashSet.add("牛顿");
        hashSet.add("爱迪生");
        hashSet.add("爱迪生");//数据不可重复
        hashSet.add("窃瓦辛格");
        System.out.println(hashSet);//[爱迪生, 牛顿, 窃瓦辛格]

        //6.size（）：返回此 set 中的元素的数量
        int size = hashSet.size();
        System.out.println(size);

        System.out.println("=================");

        //7.Iterator:遍历集合
        Iterator<String> iterator = hashSet.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            System.out.println("迭代器遍历："+next);
        }
/*        //增强for循环遍历
        for (String s : hashSet) {
            System.out.println("增强for遍历："+s);


        }*/

    }

}