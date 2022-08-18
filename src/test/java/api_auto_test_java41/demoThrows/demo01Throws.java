package api_auto_test_java41.demoThrows;

import java.io.FileNotFoundException;

/**
 * throws关键字：异常处理地第一种方式，交给别人处理
 *  作用：
 *      当方法内部抛出异常对象时时候，那么我们就必须处理这个异常对象
 *      可以使用throws关键字处理异常对象，会把异常对象声明抛出给方法调用者（自己不处理交给别人处理，
 *      ）最终交给jvm处理-->中断处理-->异常后边代码不会继续执行
 *      使用格式：
 *          修饰符 返回值类型 方法名（参数列表） throws AAAException,888Exception……{
 *              throw new AAAException("产生异常原因");
 *              throw new AAAException("产生异常原因");
 *          }
 *注意：
 * 1.throws关键字必须写在方法声明处
 * 2.throws关键字后边生命异常
 * 3.方法内部抛出多少异常对象，那么throws后边必须声明多个异常，
 *   如果抛出的多个异常对象有父类子类关系，那么直接声明父类异常即可。
 * 4.调用了一个声明抛出异常的方法，我们就必须处理声明的异常。
 *   要么继续使用throws声明抛出，交给方法的调用者处理，最终交给jvm
 *   要么try……cath自己处理异常
 */
public class demo01Throws {
    public static void main(String[] args) throws FileNotFoundException {
        readFile("c:\\\\a.txt");
        /**
         * 如果传递的路径，不是。txt结尾
         * 那么我们就抛出异常对象，告知方法的调用者，文件的后缀名不对
         *
         *
         */
    }
        /**
         * 定义一个方法，对传递的文件路径进行合法性判断
         * 如果路径不是"c:\\a.txt",那么我们就抛出文件找不到异常对象，告知方法的调用者。
         *
         */
        public static void readFile(String fileName) throws FileNotFoundException {
            if (!fileName.equals("c:\\\\a.txt")){
                throw new FileNotFoundException("传递的文件路径后缀名不对");
        }
            System.out.println("路径没有问题，读取文件");
    }


}
