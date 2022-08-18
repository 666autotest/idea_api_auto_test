package api_auto_test_java41.day04;
import java.lang.*;
/**
 * @author qq音乐
 * @date 2022/6/29 - 20:24
 */
public class StringBufferTest {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        //1.添加
/*        sb.append("hello");
        sb.append("World");*/
        sb.append("abcdefg");
        //2.字符串反转sb.reverse()
        System.out.println(sb.reverse());
        //3.字符串替换sb.replace
        //System.out.println(sb.replace(0,1,"110"));
    }

}
