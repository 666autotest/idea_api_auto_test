package api_auto_test_java41.day07;

import java.util.ArrayList;

/**
 * @author qq音乐
 * @date 2022/6/30 - 1:04
 */
public class ArrayListDemoTest {
    public static void main(String[] args) {
        //1.创建arraylist对象
        ArrayList<String > arraylist  = new ArrayList<>();
        //2.添加数据
        arraylist.add("hello");
        arraylist.add("work");
        arraylist.add("test");
        //3.取得对应的数据==》通过索引(重0开始)
        //System.out.println(arraylist.get(0));
        //4.获取所有数据(for循环遍历)，可通过索引获取元素
/*        for (int i = 0; i < arraylist.size(); i++) {
            System.out.println(arraylist.get(i));
        */

/*        //4-2:增强式for循环,可遍历数组和集合(foreach)
        //缺点：不能通过索引获取元素
*/
/*        //5.移除元素
        arraylist.remove(0);
        for (String data:arraylist){
            System.out.println(data);
        }*/
        //6.通过对应的值来移除
        arraylist.remove("hello");
        for (String data:arraylist){
            System.out.println(data);
        }
        //7.修改元素
        arraylist.set(1,"123456");
        System.out.println(arraylist.get(1));
        }


    }



