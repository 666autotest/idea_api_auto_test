package api_auto_test_java41.day06;


/**
 * @author qq音乐
 * @date 2022/6/28 - 19:40
 */
/*
    2.将如下字符串进行拆分
    Tom:20|Jack:22|Rose:24
    打印成如下形式：
    姓名：Tom，年龄：20岁
    姓名：Jack，年龄：22岁
    姓名：Rose，年龄：24岁*/

public class Split {
    public static void main(String[] args) {
        splitStr();
        reverseStr("abcdefg");
    }
    public static void splitStr(){
        String str = "Tom:20|Jack:22|Rose:24";
        String[] result1 = str.split("\\|");
        for (int i = 0; i < result1.length; i++) {
            String[] result2 = str.split(":");
            System.out.println("姓名："+result2[0]+", 年龄"+result2[1]);
        }
    }
    //3.编写一个类,提供一个函数实现字符串反转功能，比如传入字符串“abcdefg”返回字符串“gfedcba”（写成一个方法）
    public static void reverseStr(String str){
        char[] result = str.toCharArray();
        String str2= "";
        for (int i = 0; i < result.length; i++) {
            str2=result[i] + str2;
        }
        System.out.println(str2);
    }
}
