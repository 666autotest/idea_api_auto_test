package api_auto_test_java41.domeArrayList;

import java.util.ArrayList;
import java.util.Random;

/**
 * 练习题：
 * 生成6个1-33的随机整数，添加到集合，并遍历集合。
 *
 * 思路：
 * 1.需要6个数字，创建一个集合，<Integer>
 * 2.产生随机数，需要用到Random
 * 3.用循环6次，来产生随机数字，for循环
 * 4.循环内调用r.nextInt(int n),参数是33,0-32，整体+1才是33
 * 5把数字添加到集合，add
 * 6.遍历集合：for、size、get
 *
 *random类用来生存随机数，使用起来分3个步骤
 * 1.导包
 * import java.util.Random
 *
 * 2.创建
 * Random r = new Random;
 *
 * 3.使用
 * int num= r.nextInt();
 *注意：获取一个int数字(参数代表了范围，是左闭右开区间)，
 * 如：int num = r.nextInt(3),实际代表含义是[0,3),也就是012
 **/

public class Demo05ArrayListRandom {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 6; i++) {
            int num = r.nextInt(33)+1;
            list.add(num);
        }
        //遍历结合
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

}
