package api_auto_test_java41.demoCollection;

import java.util.ArrayList;

/**
 * 增强式for：
 * 增强式for循环（也成foreach）是jdK1.5以后出的一个高级for循环，
 * 专门用来遍历数组和集合的，它的内部实现原理其实就是Iterator迭代器,
 * 所以遍历过程中，不能对集合中的元素进行增删操作。
 *格式：
 * for(元素数据类型 变量：collection集合或数组){
 *     //写操作代码
 * }
 */
public class demo03Foreach {
    public static void main(String[] args) {
        demo01();
        demo02();

    }
        private static void demo01(){
            //1.定义一个数组
            int[] arr = {3, 5, 7, 55};
            System.out.println(arr);//地址值
            //2.使用增强式for循环遍历
            for (int i : arr) {
                System.out.println("arr:"+i);
        }
    }
    private static void demo02(){
        ArrayList<String> list =new ArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        System.out.println(list);//直接打印

       //遍历输出集合中的元素
        System.out.println("list:");
        for (String s:list) {
            System.out.println(s);
        }
    }
}