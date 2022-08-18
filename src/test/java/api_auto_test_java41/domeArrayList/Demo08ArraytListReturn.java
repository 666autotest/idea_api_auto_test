package api_auto_test_java41.domeArrayList;

import java.util.ArrayList;
import java.util.Random;

/**
 * 题目：
 * 用一个大集合存入20个随机数字，然后赛选出其中的偶数元素，放到小集合当中
 * 需要使用自定义的方法来实现赛选
 *
 * 分析:
 * 1.需要创建一个大集合，用来存储数字<integer>
 * 2.随机数字就用Random nextInt
 * 3.循环20次，把随机数字放入大集合：for循环、add方法
 * 4.定义一个方法，用来进行筛选
 * 赛选：根据大集合，赛选符合要求的元素，得到小集合
 * 三要素：
 * 返回值类型：Arraylist小集合（里面元素个数不确定）
 * 方法名称：getSmallList
 * 参数列表：ArrayList小集合（装着20个随机数）
 * 5.判断（if）是偶数：num%2==0
 * 6.如果是偶数放到小集合当中，否则不放
 *
 *
 *
 *
 */
public class Demo08ArraytListReturn {
    public static void main(String[] args) {
        //1.创建集合对象
        ArrayList<Integer> bigList = new ArrayList<>();
        //2.创建Random随机数对象
        Random r = new Random();
        //循环20次用：20.fori
        for (int i = 0; i < 20; i++) {
          //3.获取随机数
            int num = r.nextInt(100)+1;//1~100
            bigList.add(num);
        }
        //8.通过小集合接收大集合里的偶数
        ArrayList<Integer> smallList = getSmallList(bigList);
        //9.遍历输出
        System.out.println("偶数总共有："+smallList.size());
        for (int i = 0; i < smallList.size(); i++) {
            System.out.println(smallList.get(i));
        }
    }
    //4.创建方法，接受大集合参数，返回小集合参数
    public static ArrayList<Integer> getSmallList(ArrayList<Integer> bigList){
        //5.创建一个小集合，用来装偶数的结果
        ArrayList<Integer> smallList = new ArrayList<>();
        for (int i = 0; i < bigList.size(); i++) {
            int num = bigList.get(i);
            //6.判断大集合，如果是偶数则装入小集合
            if (num % 2 ==0){
                smallList.add(num);
            }
        }
        //7.返回一个集合
        return  smallList;
    }
}
