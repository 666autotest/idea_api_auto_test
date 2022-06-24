package homeWork;


public class Homework_day02 {
    public static void main(String[] args) {
        //第一题:打印直角三角形
        /**
         * *
         * * *
         * * * *
         * * * * **/
        for (int i = 1; i <= 5; i++) {			//控制行，外面执行一次里面执行全部。
            for (int j = 1; j <= i; j++) {		//控制列
                System.out.print("*");
            }
            System.out.println();
        }

        //第二题
       /* 打印下面的数据（for循环嵌套实现）
          1 2 3
          4 5 6
          7 8 9
         */

        int num =1;
        for(int i=0 ;i <3; i++){
            for(int j=1; j <=3;j++){
                System.out.print(num+" ");
                num++;
            }
            System.out.println();
        }

        //第三题：求0-100偶数和，求0-100奇数和
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i <=100; i++) {
            if(i%2 == 0) {	//偶数
                sum1 +=i;
            }else {			//奇数
                sum2 +=i;
            }
        }
        System.out.println("偶数和：" + sum1);
        System.out.println("奇数和：" + sum2);
    }
}
