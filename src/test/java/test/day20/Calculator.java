package test.day20;

/**
 * @author luxi
 * @date 2021/10/25 0:39
 */
/**
 * @author luxi
 * @date 2021/10/25 0:39
 * 需求：给予面向对象思想写一个简单的计算器类，定义四个函数，实现两个int类型的加减乘除，
 * 通过定义对象，调用函数，完成两个整数的3与4的加减乘除。
 */
public class Calculator {
    public int add(int x, int y) {
        return x + y;
    }
    public int sub(int x,int y){
        return x-y;
    }
    public int mul(int x,int y){
        return x*y;
    }
    public int div(int x,int y) {
        if (y == 0) {
            System.out.println("被除数不能等于0");
            return 0;
        } else {
            return x / y;
        }
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.add(100,200);
        calculator.sub(100,200);
        calculator.mul(100,200);
        calculator.div(100,200);

    }
}