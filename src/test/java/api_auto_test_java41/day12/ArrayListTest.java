package api_auto_test_java41.day12;

import java.util.ArrayList;

/**
 * @author qq音乐
 * @date 2022/7/12 - 1:37
 */
public class ArrayListTest {
    public static void main(String[] args) {
        //1.普通for循环遍历
        ArrayList list = new ArrayList();
        list.add("hello");
        list.add("word");
        for(int i = 0;i< list.size();i++){
            System.out.println(list.get(i));
        }
        //2.增强式for循环遍历
        for(Object data: list){
            System.out.println(data);


        }


    }
}
