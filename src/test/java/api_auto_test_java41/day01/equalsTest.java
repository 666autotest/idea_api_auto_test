package api_auto_test_java41.day01;

import org.testng.annotations.Test;

/**
 * @author qq音乐
 * @date 2022/7/23 - 21:04
 *
 * 面试题：==和equals的区别?
 * 1.==：是操作符，对于基本数据类型比较的是值，引用数据类型比较的是地址值。
 * 2.equals 是Object类中的方法，基本数据类型无法调用。
 * 3.equals默认使用==号，重写之后一般比较的是内容(String)。
 * 注意：equal会用==比较两个类型在内存中的地址是否一样，如果一样，则直接返回true,如果不一样则直接往下走，再判断是否为String类型，
 * 如果不是，则强转为String类型，再将字符串数组拆分为单个字符，一一比较，有一个不相同，则返回false,否则返回true.
 */
public class equalsTest {
    public static void main(String[] args) {
/*
        String str = "abc";
        String str1 = "abc";
        String abc = new String ("abc");
        String abc1 = new String ("abc");

        System.out.println(str==str1);//true
        System.out.println(abc==abc1);//false
*/

        int n=3;
        int m=3;

        System.out.println(n==m);

        String str = new String("hello");
        String str1 = new String("hello");
        String str2 = new String("hello");

        System.out.println(str1==str2);//true,n==m结果为true，这个很容易理解，变量n和变量m存储的值都为3，肯定是相等的。
                                        //对于这8种基本数据类型的变量，变量直接存储的是“值”，因此在用关系操作符==来进行比较时，
                                        // 比较的就是 “值” 本身。要注意浮点型和整型都是有符号类型的，而char是无符号类型的


        str1 = str;
        str2 = str;
        System.out.println(str1==str2);//true
/*        //对于非基本数据类型的变量，在一些书籍中称作为 引用类型的变量。
        // 比如上面的str1就是引用类型的变量，引用类型的变量存储的并不是 “值”本身，而是于其关联的对象在内存中的地址.
        String str1;
        这句话声明了一个引用类型的变量，此时它并没有和任何对象关联。
        而 通过new String("hello")来产生一个对象（也称作为类String的一个实例），并将这个对象和str1进行绑定：
        str1= new String("hello");
        那么str1指向了一个对象（很多地方也把str1称作为对象的引用），此时变量str1中存储的是它指向的对象在内存中的存储地址，并不是“值”本身，也就是说并不是直接存储的字符串"hello"。这里面的引用和C/C++中的指针很类似。
        因此在用==对str1和str2进行第一次比较时，得到的结果是false。因此它们分别指向的是不同的对象，也就是说它们实际存储的内存地址不同。
        而在第二次比较时，都让str1和str2指向了str指向的对象，那么得到的结果毫无疑问是true。*/
    }
    @Test
    public void equals(){
            // TODO Auto-generated method stub

            String str1 = new String("hello");
            String str2 = new String("hello");

            System.out.println(str1.equals(str2));//true

        int a=4;
        int b=3;
        float c = (float) a/b;
        System.out.print(c);//输出：1
/*        如果没有对equals方法进行重写，则比较的是引用类型的变量所指向的对象的地址；
        诸如String、Date等类对equals方法进行了重写的话，比较的是所指向的对象的内容。*/



        }
    }

