package api_auto_test_java41.demoString;

/**
 * 1.==基本数据类型比较的是值，引用类型比较的是地址值。
 * 2.如果需要字符串的内容比较，equals()
 *
 *方法1：
 * pbulic boolean equals(Object obj):参数可以是任何对象，只有参数是一个字符串并且内容相同的才会给true,否则返回false
 * 注意事项：
 * 1.任何对象都能用Object进行接收。
 * 2.equals方法具有对称性，也就是a.equals(b)和 b.equals()效果一样。
 * 3.如果比较双方一个常量一个变量，推荐把常量字符串写在前面
 * 推荐："abc".equals(str)  不推荐：str.equals("abc")
 *
 * 方法1：
 *  * pbulic boolean equalsIgnorcose(String str):忽略大小写，进项内容比较
 *
 * */


public class demo02StringEquals {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "Hello";
        char[] charArray = {'H','e','l','l','o'};
        String str3 = new String(charArray);

        System.out.println(str1.equals(str2));//true
        System.out.println(str2.equals(str3));//true
        System.out.println(str3.equals("Hello"));//true
        System.out.println("Hello".equals(str3));//true
        System.out.println("=================");

        String strA = "JAVA";
        String stra = "java";
        System.out.println(strA.equals(stra));//false：严格区分大小写
        System.out.println(strA.equalsIgnoreCase(stra));//true：忽略区分大小写

        //注意：只有英文字母区分大小写，其他都不区分大小写
        System.out.println("abc一123".equalsIgnoreCase("abc壹123"));//false
    }
}
