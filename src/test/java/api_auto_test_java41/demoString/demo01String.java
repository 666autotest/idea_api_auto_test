package api_auto_test_java41.demoString;

/**
 * java.lang.String类代表字符串。
 * 注意：程序当中所有双引号字符串，都是String类的对象。（就算没有new也是）
 *
 * 字符串特点：
 * 1.字符串内容永不可变。(重点)
 * 2.正因为字符串不可改变，所以字符串是可以共享使用
 * 3.字符串相当于char[]字符数组，但是底层原来是byte[]字节数组
 * 4.字符串是常量；它们的值在创建之后不能更改
 *
 * 创建字符串的常见3+1方式
 *
 *
 */
public class demo01String {
    public static void main(String[] args) {
        //1.使用空参构造
        String str1 = new String();
        System.out.println("第一个字符串："+str1);//输出空

        //2.根据字符串数组创建字符串
        char[] charArray = {'A','B','C'};
        String str2 = new String(charArray);
        System.out.println("第二个字符串："+str2);

        //3.根据字节数组创建字符串
        byte[] byteArray ={97,98,99};
        String str3 = new String(byteArray);
        System.out.println("第三个字符串："+str3);

        //4.直接创建
        String str4 = "Hello";
        System.out.println("第四个字符串："+str4);

    }

}
