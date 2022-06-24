package homeWork;

/**
 * @author qq音乐
 * @date 2022/6/23 - 18:22
 */

/*第一道作业:
1.基于面向对象的思想写一个简单的计算器类Calculator，定义四个函数，实现两个int类型数据的加减乘除，
通过创建对象，调用函数，完成两个整数3与4的加减乘除运算*/
public class Calculator {
    public int add(int x,int y){
        return x + y;
    }
    public int sub(int x,int y){
        return x - y;
    }
    public int mul(int x,int y){
        return x * y;
    }
    public int div(int x,int y){
        if(y == 0){
            System.out.println("被除数不能等于0");
            return 0;
        }
        else {
            return x / y;
        }
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.add(3,4);
        calculator.sub(3,4);
        calculator.mul(3,4);
        calculator.div(3,4);
    }
}
