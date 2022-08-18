package api_auto_test_java41.day06;

/**
 * @author qq音乐
 * @date 2022/6/28 - 20:20
 * 面试题
 */
public class test {
    public static void main(String[] args) {
        reverseStr("abcdefg");
    }
    //3.编写一个类,提供一个函数实现字符串反转功能，比如传入字符串“abcdefg”返回字符串“gfedcba”（写成一个方法）
    public static void reverseStr(String str){
        //String str =;
        char[] result = str.toCharArray();
        String str2= "";
        for (int i = 0; i < result.length; i++) {
            str2=result[i] + str2;
        }
        System.out.println(str2);
    }

}
