package api_auto_test_java41.random;

import java.util.Random;

//随机生成一个136开头的手机号码
public class demo02RandomPhoneList {
    public static void main(String[] args) {
       //1.创建random对象
        Random r = new Random();
        //定义手机号码前3位，后边的8个数字用随机数生成
        String phoneList = "136";//因为后边要采用凭借方式，所以用String类型
        for (int i = 0; i < 8; i++) {
            int num = r.nextInt(9);
            phoneList=phoneList+num;
            System.out.println("136开头的手机号码是："+phoneList);
        }
    }

}
