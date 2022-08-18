package api_auto_test_java41.interview;
//打印1-100的和，奇数和，偶数和
public class demo02Sum {
    public static void main(String[] args) {
        int sum= 0;//1-100的和
        int odd = 0;//奇数
        int even = 0;//偶数
        for (int i = 0; i <= 100; i++) {
            sum += i;
            if (i % 2 == 0) {
                even += i;
            } else {
                odd += i;
            }
        }
        System.out.println("1-100的和：" + sum);
        System.out.println("1-100的偶数和：" + even);
        System.out.println("1-100的奇数和：" + even);
    }
}


