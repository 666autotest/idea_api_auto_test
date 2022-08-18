package api_auto_test_java41.random;

/*random:获取随机数
步骤：
    1.导包、创建、使用*/

import java.util.Random;

public class demo01Random {
    public static void main(String[] args) {
        int n = 3;
        //1.创建random对象
        Random r = new Random();
        //获取随机数
/*        int num = r.nextInt(10);
        System.out.println(num);*/
        for (int i = 0; i < 6; i++) {//6代表个数、即长度
            int result = r.nextInt(3)+1;//注意左闭右开区间，所以+1
            System.out.println(result);

        }

    }
}
