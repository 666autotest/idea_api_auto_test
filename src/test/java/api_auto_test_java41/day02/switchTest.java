package api_auto_test_java41.day02;

/**
 * @author qq音乐
 * @date 2022/7/25 - 0:58
 *
 * 语法：swith的字面值跟case的字面值相等，就执行case语句，
 * 如果所有的case跟switch的字面值不相等，就执行default语句
 */
public class switchTest {
    public static void main(String[] args) {
        int day = 1;//表示周三
        switch (day){
            case 1:
                System.out.println("写代码");
                break;
            case 2:
                System.out.println("看电影");
                break;
            case 3:
                System.out.println("打篮球");
                break;
            case 4:
                System.out.println("逛街");
                break;
            case 5:
                System.out.println("爬山");
                break;
            default:
                System.out.println("不在范围内");

            }
        }

}
