package api_auto_test_java41.interview;

/**
 * 一个方法可以有0、1、多个参数，但是返回值只能有一个或0，不能有多个返回值
 * 如果希望一个方法中产生多个结果数据进行返回，怎么办？
 * 解决方案：使用数组

 */

public class demo01calculate {
    public static void main(String[] args) {
        int[] result = calculate(10,20);
        System.out.println("总和："+result[0]);
        System.out.println("平均数："+result[1]);



    }
    public static int[] calculate(int a,int b){
        int sum = a+b;//求和
        int avg = sum/2;//平均数
        //2个结果都希望返回
        //需要一个数组来保存这2个数据
        int[] arr = new int [2];
        arr[0] = sum;
        arr[1] = avg;
        return arr;
    }
}
