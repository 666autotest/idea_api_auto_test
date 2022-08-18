package api_auto_test_java41.day02;


public class Homework_day02 {
    public static void main(String[] args) {
        int [][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }



        //第一题:打印直角三角形
        /*
         *
         * *
         * * *
         * * * *
         * * * * *
         * */
        for (int i = 1; i <= 5; i++) {			//控制行，外面执行一次里面执行全部。
            for (int j = 1; j <= i; j++) {		//控制列
                System.out.print(" *");
            }
            System.out.println();//内循环循环完一次，换行一次
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

        //第三题：求0-100偶数和，求0-100奇数和(add，sub,mul,div)
        int even = 0;
        int odd = 0;
        for (int i = 0; i <=100; i++) {
            if(i%2 == 0) {	//偶数
                even +=i;
            }else {			//奇数
                odd +=i;
            }
        }
        System.out.println("偶数和：" + even);
        System.out.println("奇数和：" + odd);
    }

}
