package api_auto_test_java41.demoString;

/**
 *
 * char[] tocharArray():将当前字符串拆分成字符串数组作为返回值
 * getBytes():获取当前字符串底层的字节数组
 * replace(charSequence oldString newString)
 * 将所有出现的老字符串替换成新的字符串。返回替换之后的新字符串
 *
 *
 *
 *
 *
 *
 */
public class demo05StringConvert {
    public static void main(String[] args) {
        //1.转换成字符数组
        char[] chars = "Hello".toCharArray();
        System.out.println(chars[0]);//H
        System.out.println(chars.length);//5
        System.out.println("================");

        //2.转换成字节数组
        byte[] bytes = "abc".getBytes();
        for (int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]);//97,98,99


        //3.字符串内容替换
        String str1 = "How do you do?";
        String str2 = str1.replace("o","*");
        System.out.println(str1);
        System.out.println(str2);
        System.out.println("=============");


        String lang1 = "会不会玩呀！你大爷的！你大爷的！！！";
        String lang2 = lang1.replace("你大爷的","****");
        System.out.println(lang2);
        }


    }
}
