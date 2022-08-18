package api_auto_test_java41.domeArrayList;


import java.util.Arrays;

/**
 *
 * 题目：、
 * 使用Arrays相关api，讲一个随机数进行排序、倒叙输出
 *
 **/
public class demo10ArrayPrint {
    public static void main(String[] args) {


    String str= "123abc456";
    //1.升序用:sort
    //2.必须是一个数组才能使用Arrays.sort方法
    //3.String-->数组，用toCharray
    char[] chars = str.toCharArray();
    Arrays.sort(chars);//对字符串进行升序

     //4.倒着遍历
        //倒叙：即从最后一个元素，逆着排序，
        //数组最后一个元素是chars.length-1，以此类推chars.length-1-1，……
        for (int i = chars.length-1; i >= 0; i--) {
            System.out.println(chars[i]);

        }
}
}