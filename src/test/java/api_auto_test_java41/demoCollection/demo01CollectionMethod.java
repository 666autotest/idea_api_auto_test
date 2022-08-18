package api_auto_test_java41.demoCollection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 集合概述：集合是java中提供的一种容器，可以用来存放多个数据。
 * 集合和数组的区别：
 * 1.数组的长度是固定的，集合的长度是可变的。
 * 2.数组中存储的同一类型的元素，可以存储基本类型数据。集合存储的是对象，而且对象的类型可以不一致，
 *
 *
 * ArrayList和HashSet的区别：
 * 共同点：都是同一个父接口：Collection
 * ArrayList：
 * 1.有序的集合(存储和取出元素顺序相同)
 * 2.允许存储重复的元素
 * 3.有索引，可以通过普通for循环遍历
 *
 * HashSet：
 * 1.不允许存储重复的元素
 * 2.没有无序
 * 2.没有索引，不能使用普通for循环遍历
 * 注意：LinkedHashSet集合是有序的。
 *
 * collection是所有单例集合的共性方法（Vector、ArrayList、LinkedList、TreeSet、HashSet、LinkHashSet）
 * collection集合共性方法
 * public boolean add(E e):把给定的对象添加到集合当中
 * pbulic void clear():情况集合中的所有元素
 * public boolean remove(E e):删除集合当中指定的对象
 * public boolean contains(E e):判断当前集合当中是否包含给定的对象。
 * public boolean isEmpty():判断当前集合是否为空
 * public int size():返回集合中元素的个数
 * pbulic ObjectP[] toArray():把集合当中的元素，存储到数组中
 *
 */
public class demo01CollectionMethod {
    public static void main(String[] args) {
        //1.创建集合对象可以使用多态
        Collection<String> coll = new ArrayList<>();
        System.out.println(coll);//输出[],重写了toString方法

/*        public boolean add(E e):把给定的对象添加到集合当中。
        返回值是一个boolean,一般返回都是true，所以可以不用写。
        */

        //2.添加对象:add
        Boolean b1= coll.add("张三");
        System.out.println("b1:"+b1);//true
        System.out.println(coll);//张三
        coll.add("李四");
        coll.add("王五");
        coll.add("赵六");
        System.out.println(coll);//[张三, 李四, 王五, 赵六]

        //3.删除对象:remove
        boolean b2 = coll.remove("赵六");
        System.out.println("b2:"+b2);//true
        System.out.println(coll);//[张三, 李四, 王五]

        //3-1，删除不存在的元素，返回false
        boolean b3 = coll.remove("赵四"); //false
        System.out.println("b3:"+b3);
        System.out.println(coll);//[张三, 李四, 王五]

        //4.判断集合中是否包含某个对象contains
        boolean b4 = coll.contains("李四");
        System.out.println("b4:"+b4);//true


        boolean b5 = coll.contains("赵四");
        System.out.println("b5:"+b5);//false

        //5.isEmpty:判空
        boolean b6 = coll.isEmpty();
        System.out.println("b6:"+b6);//false

        //6.size():返回集合中元素的个数
        int size = coll.size();
        System.out.println("size:"+size);//size:3

        //7.pbulic Object[] toArray():把集合中的元素，存储到数组中
        Object[] arr = coll.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);

        //8.clear:清空集合中的所有元素。但是不删除元素，集合还存在
        coll.clear();
        System.out.println(coll);//输出[]
            System.out.println(coll.isEmpty());//b2:true
        }
    }
}
