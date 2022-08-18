package api_auto_test_java41.day15;

/**
 * @author qq音乐
 * @date 2022/7/26 - 20:24
 * 一个方法可以有0、1、多个参数，但是返回值只能有0或者1个，不能有多个返回值。
 * 如果希望一个方法中产生多个返回值，用数组。
 */
public class arrayTest {
    public static void main(String[] args) {
/*        int[] result = calcuate(10,20,30);
        System.out.println(result[0]);
        System.out.println(result[1]);*/
        int[] arr  = {1,2,3};
        System.out.println(arr[1]);
        System.out.println(arr.length);

    }
    public static int[] calcuate( int a,int b,int c){
        int sum = a+b+c;
        int avg = sum/3;

        int[] array = new int[2];
        array[0] = sum;
        array[0] = avg;

        return array;
    }

}
