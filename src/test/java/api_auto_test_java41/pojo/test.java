package api_auto_test_java41.pojo;

/**
 * @author qq音乐
 * @date 2022/7/26 - 4:57
 */
public class test {
    int a ;
    String b ;
    //空参构造
    public test() {
    }
    //有参构造
    public test(int a, String b) {
        this.a = a;
        this.b = b;
    }

    //set()设置，get()获取
    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

}
