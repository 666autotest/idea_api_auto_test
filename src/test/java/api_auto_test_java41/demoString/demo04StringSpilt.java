package api_auto_test_java41.demoString;

/**
 * 分割字符创方法
 * pbulic String[] spilt(String regex):按照参数规则，将字符串切分称为若干部分
 *
 *注意事项：
 * spilt方法的参数是一个正则表达式，今后学习
 * 今天要注意：如果按照英文句点"."进行切割，必须写"\\."
 *
 *
 *
 *
 *
 */
public class demo04StringSpilt {
    public static void main(String[] args) {

    String str1 = "aaa,bbb,ccc";
    String[] arr = str1.split(",");//切割后返回的是数组
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("==============");

        //按照英文句点"."进行切割，必须写"\\."
        String str3 = "XXX.YYY.ZZZ";
        String[] arr3 = str3.split("\\.");
        for (int i = 0; i < arr3.length; i++) {
            System.out.println(arr3[i]);
        }

}
}