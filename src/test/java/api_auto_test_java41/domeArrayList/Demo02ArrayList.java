package api_auto_test_java41.domeArrayList;
/*三大集合类
 *Java的集合类是数据结构的实现，可以用来存储多个对象
 *ArrayList概述
 *本质：数组
 *容器支持的数据类型：引用类型 、不能支持基本的数据类型
 *容器特点
 *长度可变数组，提供很多方便的方法
 *有序、可重复
 *
 * 数组长度不可以发生改变
 * 但是ArrayList集合的长度可以随意发生变化。
 *
 * 注意：
 * 从jdk1.7+开始，右侧的尖括号内部可以不写内容，但是<>本身还是要写。
 * 泛型只能是引用类型，不能是基本数据类型，需使用基本数据类型包装类。
 * */

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Demo02ArrayList {
    public static void main(String[] args) {
        //创建集合
        //1.<E>代表泛型，也就是集合当中的元素类型。
        //2.泛型只能是应用类型，不能是基本数据类型。
        //对于ArrayLIst集合来说，直接打印得不到地址值，而是内容，如果内容为空，得到一个空的中括号[].
        ArrayList<String> list = new ArrayList<>();
        System.out.println(list);

        //2.往集合中添加元素
        list.add("刘亦非");
        list.add("迪丽热巴");
        list.add("迪丽热巴");//数据可重复
        System.out.println(list);

        //往集合中一次性添加多个元素
        //public static<T> boolean addall(collection<T c,^elements>)
        Collections.addAll(list,"c","b","a");
        System.out.println(list);//c,b,a

        //list(100); 错误写法！因为创建数组的时候，进括号泛型已经说明是字符串，添加元素必须是字符串

        //sort():将集合中的元素进行排序
        Collections.sort(list);
        System.out.println(list);//[a, b, c, 刘亦非, 迪丽热巴, 迪丽热巴]

        //shuffle():打乱集合中元素的顺序
        Collections.shuffle(list);

    }
}
