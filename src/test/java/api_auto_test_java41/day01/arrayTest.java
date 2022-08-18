package api_auto_test_java41.day01;

/**
 * @author qq音乐
 * @date 2022/7/25 - 1:45
 */
public class arrayTest {
    public static void main(String[] args) {
        //二维数组遍历
        String[][] arr41={
                {"小龙女","杨过"},
                {"奥特曼","小怪兽"},
                {"喜羊羊","灰太狼"}
        };
        for (int i = 0;i < arr41.length; i++) {
            //array41[i]是个数组，length是长度
            for (int j = 0; j <arr41[i].length ; j++) {
                System.out.print(arr41[i][j]+",");

            }
            System.out.println();
        }
    }
}
