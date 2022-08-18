package api_auto_test_java41.demoString;

/**
 *
 * String 当中与获取相关的方法
 * 1.length();获取字符串长度
 * 2.concat(String str):将当前字符串和参数字符串拼接成功，返回新的字符串
 * 3.charAt(int index):获取指定索引位置的单个字符，（索引从0开始）
 * 4.indexOf(String str):查找参数字符串在本地当中首次出现的索引位置，如果没有返回-1值。
 *
 *
 *
 *
 */
public class demo03StringGet {
    public static void main(String[] args) {
        //1.获取字符串长度
        int length = "afhfbjkwbfajvjka".length();
        System.out.println("字符串长度是："+length);

        //2.拼接字符串
        String str1 = "Hello";
        String str2 = "World";
        String str3 = str1.concat(str2);
        System.out.println(str1);//Hello，原封不动
        System.out.println(str2);//world,原封不动
        System.out.println(str3);//HelloWorld,新的字符串，

        //3.获取指定索引位置单个字符
        char ch = "Hello".charAt(1);
        System.out.println("在1号索引位置的字符是："+ch);

        //4.查找参数字符串在本地当中首次出现的索引位置，如果没有返回-1值。
    String original = "HelloWorld";
    int index = original.indexOf("llo");
    System.out.println("第一次索引值是："+index);
    System.out.println("第一次索引值".indexOf("abc"));//-1
    }

}
