package api_auto_test_java41.demoString;

/**
 *
 * 1.定义一个方法，把数组{1,2,3，}，按照固定格式拼接成一个字符串。
 * 参照格式：[work1@work2@word3]
 *
 *分析：
 * 1.首先准备一个数组， int[] arr = {1,2,3}
 * 2.定义一个方法，用来将数组变成字符串
 *
 * 定义方法三要素：
 * 1.方法名：arrayToString
 * 2.参数列表：int[]
 * 3.格式：[work1@work2@word3]
 * 用到：for循环、字符串拼接、每个数组元素之前都有一个word,分隔使用#、区分是不是最后一个
 *4.调用方法，得到返回值，并打印结果字符串
 *
 *注意：字符串（+=）是拼接，不是累加
 */


public class demo07StringPractise {
    public static void main(String[] args) {

        String str11 ="[";
        str11+="work";
        System.out.println(str11);
    //1.定义一个数组
        int[] arr = {1,2,3};

        //8.打印输出
        System.out.println(arrayTOString(arr));
/*        String result = arrayTOString(arr);
        System.out.println(result);*/
    }
    //2.定义一个方法
    public static String arrayTOString(int[] arr){
        //3.定义一个变量=" [ "
        String str = "[";

        //4.获取元素，使用for循环
        for (int i = 0; i < arr.length; i++) {
           //6.判断最后一个元素，是拼接:]
            if (i == arr.length-1){
                str+="word"+arr[i]+"]";
           //7.如果不是最后一个元素则凭借[
            }else{
            //5.拼接字符串
            str+="word" +arr[i] + "#";
        }
    }
        return str;
    }
}
