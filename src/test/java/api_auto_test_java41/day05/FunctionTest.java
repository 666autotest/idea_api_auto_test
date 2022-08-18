package api_auto_test_java41.day05;

/**
 * @author qq音乐
 * @date 2022/6/28 - 0:09
 */
public class FunctionTest {
    public static void main(String[] args) {
        int[] classA = {65, 40, 66, 80, 90, 100, 45, 59};
        int[] classB = {60, 40, 68, 80, 95, 38, 45, 59};
        int[] classC = {65, 30, 68, 58, 93, 28, 45, 59};
        Function fun = new Function();
        fun.scorePass(classA);
        fun.scorePass(classB);
        fun.scorePass(classC);
    }
}

