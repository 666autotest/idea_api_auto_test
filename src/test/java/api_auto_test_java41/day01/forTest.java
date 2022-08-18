package api_auto_test_java41.day01;

/**
 * @author qq音乐
 * @date 2022/7/25 - 3:06
 */
public class forTest {
    public static void main(String[] args) {
/*打印左直角三角形1
*
**
***
****
/*        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }*/


/*打印倒直角三角形2
*****
****
***
**
*
*/
/*
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5 - i; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
*/



            //打印右直角三角形3
/*                         *
                          **
                         ***
                        ****
                      ******/
           for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5 - i; j++) {
                    System.out.print("0");
                }
                for (int j = 0; j < i + 1; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }

        //打印直角三角形4
/*         *****
            ****
             ***
              **
               */
/*        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 5 - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }*/
    }
}



