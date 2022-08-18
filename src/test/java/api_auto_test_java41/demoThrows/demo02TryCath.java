package api_auto_test_java41.demoThrows;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * try……cath:异常处理的第二种方式，自己处理异常
 * 格式：
 * try{
 *     可能产生异常的代码
 *    }cath(定义一个异常变量，用来接受try中抛出的异常对象){
 *        异常处理逻辑，产生异常对象之后，怎么处理异常对象
 *        一般在工作中会把异常信息记录到一个日志中
 *    }
 *  cath(异常类名 变量名){
 *  }
 *注意：1.try中可能抛出对各异常对象，那么就可以使用多个catch来处理这些异常
 *     2.如果try中没有产生异常，那么就不会执行catch中异常的处理逻辑，执行玩try中的代码，继续执行try^catch之后的代码
 */
public class demo02TryCath {

    public static void main(String[] args) {
        try {
            //可能产生的异常
            readFile("c:\\\\a.txt");
        }catch (IOException e){//try中抛出什么异常对象，cath就地敬意什么异常变量，用来接收这个异常对象
            //异常的处理逻辑，产生异常对象之后，怎么处理异常对象
            System.out.println("cath-传递的文件后缀不是.txt");
        }
        System.out.println("后续代码");
    }
    public static void readFile(String fileName) throws FileNotFoundException {
        if (!fileName.equals("c:\\\\a.txt")){
            throw new FileNotFoundException("传递的文件路径路径不对:\\\\a.txt");
        }
        System.out.println("路径没有问题，读取文件");
    }
}
