package api_auto_test_java41.demoCollection;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * java.util.Iterator接口：迭代器（对集合进行遍历）
 * 有2个常用方法:
 *      boolean hasNext():如果有元素可以迭代，返回true.
 *          判断集合中还有没有下一个元素，有就返回true,没有返回false.
 *      E next():返回迭代的下一个元素
 *          取出集合中的下一个元素
 *      Iterator迭代器，是一个接口，我们无法直接使用，需要使用Iterator接口的实现类对象。
 *      获取实现类的方式比较特殊，collection中有一个方法，叫Iterator(),这个方法返回的就是迭代器的实现类对象,
 *      Iterator(E) Iterator() 返回在此collection的元素上进行迭代的迭代器。
 *
 *      迭代器的使用步骤（重点）：
 *      1.使用集合中的方法iterator()获取迭代器的实现类对象，使用Iterator接口接收。(多态)
 *      2.使用Iterator接口中的方法hasNext判断还有没有下一个元素
 *      3.使用Iterator接口中的方法next取出集合中的下一个元素
 *

 */
public class demo02Iterator {
    public static void main(String[] args) {
        //1.创建一个集合对象
        ArrayList<String> coll = new ArrayList<>();
        //2.往集合中添加元素
        coll.add("姚明");
        coll.add("科比");
        coll.add("麦迪");
        coll.add("詹姆斯");
        /**
         * 2.使用集合中Iterator()方法获取迭代器的实现类对象，使用Iterator接口接收（多态）。
         * 注意：Iterator<E>接口也有泛型，迭代器的泛型跟着集合走，集合是什么泛型，迭代器就是什么泛型
         */
        //多态   接口             实现类对象
        Iterator<String> it= coll.iterator();//获取迭代器的实现类对象，并会把指针(索引)指向集合中的-1索引

        /**
         *1.取出集合中的元素是一个重复的过程，所以用循环
         * 2.不知道集合中有多少元素，用while
         * 3.循环结束的条件，hasNext方法返回false
         *
         *
         */
        while (it.hasNext()){//判断集合中是否有下一个元素
            String e = it.next();//这里做了2件事：1.取出元素姚明 2.把指针向后移动一位
            System.out.println(e);
        }
        System.out.println("============");

        for(Iterator<String> it2 = coll.iterator();it2.hasNext();){
            String s = it2.next();
            System.out.println(s);

        }

/*
        //2.使用hasNext()方法取出集合中的下一个元素
        boolean b = it.hasNext();
        System.out.println(b);//true
        //3.使用next(方法取出集合中的下一个元素
        String s = it.next();
        System.out.println(s);//姚明

        //3-1.使用next(方法取出集合中的下一个元素
        String bb = it.next();
        System.out.println(bb);//科比*/
    }
}
