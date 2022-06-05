package test.day24;



import java.util.Random;
import java.util.Scanner;

/**
 * 题目：用代码模拟猜字小游戏
 *
 * 思路：
 * 1.首先需要产生一个人随机数字，并且一旦产生不在变化。用random的nextInt()方法
 * 2.需要键盘录入，所以用Scanner
 * 3.获取键盘输入的数字，用Scanner当中的nextInt()方法
 * 4.已经得到2个数字，判断(if)一下：
 *      如果太大了，提示太大，并重试
 *      如果太小了，提示太小，并重试
 *      如果猜中了，游戏结束
 * 5.重试就是再来一次，循环次数不确定，用while(true).
 */

public class RandomGameTest {
    public static void main(String[] args) {
        Random r =new Random();
//*

        int randomNum=r.nextInt(100)+1;//[1,100]
        Scanner sc =new Scanner(System.in);
        while(true){
            System.out.println("请输入你要猜测的数字：");
            int guessNum = sc.nextInt();//键盘输入猜测的数字

            if(guessNum > randomNum){
                System.out.println("太大了，请重试！");
            }else if(guessNum < randomNum){
                System.out.println("太小了，请重试！");
            }else{
                System.out.println("恭喜你，猜中了！");
                break;
            }
        }
        System.out.println("游戏结束！");
    }
}
