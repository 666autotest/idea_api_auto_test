package api_auto_test_java41.demoHashSet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * java.util.Set接口 extends collection接口
 * Set接口的特点：
 * 1.不允许元素重复
 * 2.没有索引，没有带索引的方法，也就不能使用普通for循环遍历
 * java.util.HashSet集合 implements Set接口
 * HashSet特点：
 * 1：不允许存储重复的元素
 * 2：没有索引，没有带索引的方法就不能使用普通for循环遍历
 * 3.是一个无序的集合，存元素和取出元素的顺序有可能不一致
 * 4.底层是一个哈希表机构（查询速度非常快）
 *
 *泛型是一种未知的数据类型，当我们不知道使用什么诗句类型的时候，可以使用泛型。
 * 泛型可以看出是一种变量，用来接收数据类型
 * E e：element元素
 * T t Type 类型
 * 创建集合的时候，会确定数据类型
 *
 */
public class demo01Set {
    public static void main(String[] args) {
        //1.创建HashSet对象
        Set<Integer>  set = new HashSet<>();
        //2.使用add方法往集合中添加元素
        set.add(1);
        set.add(1);
        set.add(2);
        set.add(3);
        //3.使用迭代器遍历集合
        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()){
            Integer n = iterator.next();
            System.out.println(n);

        }
        //4.增强for遍历set结合
        System.out.println("==============");
        for (Integer i : set) {
            System.out.println(i);

        }
    }

}

