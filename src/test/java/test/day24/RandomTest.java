package test.day24;

import java.util.Random;

/**
 * @author luxi
 * random类用来生成随机数字。使用起来是三个步骤：
 * 1.导包
 * import java.util.Random
 *
 * 2.创建
 * Random r = new Random();//小括号当中留空
 *
 * 3.使用
 * 获取一个随机夫人int数字（范围是int所有范围）：int num =r.nextInt()
 * 获取一个随机的int数字(参数代表了范围，左闭右开区间)：int num =r.nextInt(3)
 * 实际上代表的含义是：[0,3],也就是0~2
 */
public class RandomTest {
    public static void main(String[] args) {
        Random r =new Random();
        int num = r.nextInt();
        System.out.println("随机数是"+num);
    }

}
