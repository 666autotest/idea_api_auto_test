package api_auto_test_java41.day17;

/**
 * super关键子的三种用法
 * 1.在子类成员方法中，访问父类的成员变量
 * 2.在子类成员方法中，访问父类成员方法
 * 3.在子类构造方法中，访问父类的构造方法5
 *
 */
public class ZI extends Fu{

    int b = 100;
    public void mothoZi(){
        System.out.println(super.num);//访问父类成员变量
    }
    public void mothod(){
        super.method();//访问父类成员方法
        System.out.println("子类方法");
    }
}
