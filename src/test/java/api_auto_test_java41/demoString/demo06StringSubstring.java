package api_auto_test_java41.demoString;

/**
 *
 * substring(int index):截取从参数位置一直到字符串末尾，返回新的字符串
 * substring(int begin, int end):截取从begin开始，一致到end结束，中间的字符串。
 * 备注：[begin,end),左闭右开区间（包含左边，不包含右边）
 *
 *注意字符串一定不会发生改变。
 *
 *
 */
public class demo06StringSubstring {
    public static void main(String[] args) {
    String str1 = "HelloWorld";
    String str2 = str1.substring(5);
    System.out.println(str1);//Helloorld
    System.out.println(str2);//world,新的字符串
    System.out.println(str1);//还是Helloorld，没有发生改变
    System.out.println("============");


     //下面这种写法，字符串仍然没有改变
    //下面有2个字符："Hello","Java"
    //strA当中保存的是地址值
    //本来地址值是Hello的ox666
    //后来地址值变成了Java的ox999
    //变得是地址值，不是字符串
    String strA = "Hello";
    System.out.println(strA);//Hello
    strA = "Java";
    System.out.println(strA);//Java

    }
}
