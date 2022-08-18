package api_auto_test_java41.day15;

import java.util.ArrayList;

/**
 * @author qq音乐
 * @date 2022/7/26 - 20:03
 * 题目：定义已指定格式打印集合的方法（ArrayList类型作为参数，用{}括起来，使用@分隔每个元素。
 * 格式参照 {元素@元素@元素}
 */
public class ListTest {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("刘亦菲");
        list.add("杨过");
        list.add("李莫愁");
        printArrayList(list);
    }

    /**
     * 方法定义3要素
     * 返回值类型：只是进行打印，没有参与运算，没有结果，用void
     * 方法名称：printArrayList
     * 参数列表：ArrayList
     */
    public static void printArrayList(ArrayList<String> list) {
        System.out.print("{");
        for (int i = 0; i < list.size(); i++) {
            String name = list.get(i);
            if (i == list.size() - 1) {
                System.out.println(name + "}");
            } else {
                System.out.print(name + "@");
            }

        }
    }

}