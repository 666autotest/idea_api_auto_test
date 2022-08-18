package api_auto_test_java41.day12;

import java.util.Arrays;

/**
 * @author qq音乐
 * @date 2022/7/12 - 2:52
 */
public class BubbleSort {
    public static void main(String[] args) {
        //冒泡排序
        int[] items = new int[]{1,3,5,7,9,2,4,6,8,0};
        for (int i = 0; i < items.length-1; i++) {//1.外循环为排序的趟数
            for (int j = 0; j <items.length-i-1; j++) {//2.内循环为每趟比较的次数
                if (items[j] > items[j+1]){//3.比较相邻的元素，如果第一个比第二个大，就交换他们的位置
                    int tmp = items[j];
                    items[j] = items[j+1];
                    items[j+1] = tmp;
                }
            }
            }
            System.out.println("排序后:"+ Arrays.toString(items));
            }
        }


