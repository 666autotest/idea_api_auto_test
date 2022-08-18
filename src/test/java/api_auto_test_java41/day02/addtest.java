package api_auto_test_java41.day02;

/**
 * @author qq音乐
 * @date 2022/7/25 - 23:31
 */
public class addtest {
        public static int add(int a, int b) {
        return a + b;
        }
        public static float sub(int a, int b) {
        return a - b;
        }
        public static float mul(int a, int b) {
        return a * b;
        }
        public static float div(int a, int b) {
            return a / b;
        }
        public static void main(String[] args) {

        System.out.println("加 = " + add(1, 2));
        System.out.println("减 = " + sub(3,4));
        System.out.println("乘 = " + mul(5,6));
        System.out.println("除 = " + div(7,8));

        }
    }

