package api_auto_test_java41.day04;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @author qq音乐
 * @date 2022/7/11 - 23:05
 */
public class StringTest {
    public static void main(String[] args) {
        String str = "abcdef";
        //1.length()：获取字符串长度
        System.out.println(str.length());

        //2.charAt():获取某个字符
        char c = str.charAt(1);
        System.out.println(c);

        //3.replace()：字符串替换
        String str1 = "abcd";
        String str2 = "你好";
        String str3 = str2.replace("你好","helloword");
        String str4 = str1.replace("d","123");
        System.out.println(str3);
        System.out.println(str4);

        //4.split()：字符串拆分
        String[] str11 = str1.split("c");
        for (String st:str11) {
            System.out.println(st);
        }

        //5.substring()：截取字符串
        String str5 = "adcdefghijk";
        String str55 = str5.substring(1,3);
        System.out.println("字符串截取"+str55);

        //6.toCharArray()：将字符串变成一个字符数组
        String str6 = "abcd fgh";
        char[] ch = str6.toCharArray();
        System.out.println(ch);
        System.out.println("字符数组第一个索引值是："+ch[0]);
        HashSet<String> hashSet = new HashSet<String>();
        hashSet.add("hello");
        hashSet.add("word");
        Iterator<String> ite = hashSet.iterator();
        while(ite.hasNext()){
            System.out.println(ite.next());

        }

    }
}
