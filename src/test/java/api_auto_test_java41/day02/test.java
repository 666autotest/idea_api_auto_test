package api_auto_test_java41.day02;

/**
 * @author qq音乐
 * @date 2022/7/24 - 23:46
 */
public class test {

    public static void main(String[] args) {
        //打印倒直角三角形
/*        for (int i = 0; i <= 5; i++) {			//控制行，外面执行一次里面执行全部。
            for (int j = 5; j >= i; j--) {		//控制列
                System.out.print(" *");
            }
            System.out.println();//内循环循环完一次，换行一次
        }*/
        System.out.println("===========================");


        ////打正方形

/*                for (int i = 0; i < 5; i++) {		//控制行，外面执行一次里面执行全部。
                for (int j = 0; j < 5; j++) {		//控制列
                System.out.print(" *");
            }
            System.out.println();//内循环循环完一次，换行一次
        }

        System.out.println("====================");*/

        //打印右直角三角形
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5 - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    }

