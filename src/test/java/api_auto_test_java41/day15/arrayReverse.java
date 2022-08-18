package api_auto_test_java41.day15;

import java.util.Arrays;

/**
 * @author qq音乐
 * @date 2022/7/26 - 21:08
 * 求出数组中的最大值
 * 思路：类似比武招亲
 */
public class arrayReverse {
    public static void main(String[] args) {
    int[] arr = {1,2,3,4,5,6};
        for (int k = 0; k < arr.length; k++) {
            System.out.print(arr[k]);
        }

/*    int max=arr[0];//擂台
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max){//求最小值把>改成<即可
                max = arr[i];
            }
        }
        System.out.println("最大值："+max);
    }*/
    //数组
        //使用冒泡排序，相邻的2个数进行对比，符合条件的进行交换位置
/*        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j <arr.length-i-1; j++) {
                if (arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        System.out.println("排序后:"+ Arrays.toString(arr));*/

        //数组反转
        int start = 0;
        int end = arr.length-1;
        while(start < end){
           int temp = arr[start];
           arr[start] = arr[end];
           arr[end] = temp;
           start++;
           end--;
        }
        System.out.println(Arrays.toString(arr));
    }
}




