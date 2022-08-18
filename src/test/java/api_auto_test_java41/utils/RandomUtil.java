package api_auto_test_java41.utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class RandomUtil {
    /**
     * 随机生成没有注册过的手机号码
     */
    public static String getUnregisterPhone() {
        //1.创建faker对象
        Faker faker = new Faker(Locale.CHINA);
        String randomPhone;
        Object result;
        while (true) {
            //2.通过faker的phoneNumber()方法获取到随机手机号码
            randomPhone = faker.phoneNumber().cellPhone();
            //3.查询数据库，验证手机号码是否被注册
            result = DBUtil.querySingledata("select count(*) from tz_user where user_mobile=" + randomPhone + "");
            if ((Long) result == 1) {
                //用户已被注册，继续循环
                continue;
            } else {
                //用户没被注册，跳出循环
                break;
            }
        }
        return randomPhone;
    }

    /**
     * 随机生成未注册过的用户名
     * @return
     */
    public static String getUnregisterUser() {
        //1.创建faker对象
        Faker faker = new Faker();
        String randomName;
        Object result;
        while (true) {
            //2.通过faker的phoneNumber()方法获取到随机手机号码
            randomName = faker.name().firstName();
            //3.查询数据库，验证手机号码是否被注册
            result = DBUtil.querySingledata("SELECT COUNT(*) FROM tz_user WHERE user_name='"+randomName+"'");
            if ((Long) result == 1) {
                //用户已被注册，继续循环
                continue;
                //用户名4-16位
            } else if (randomName.length() >= 4){
                //用户没被注册，跳出循环
                break;
            }
        }
        return randomName;
    }

    public static void main(String[] args) {
        System.out.println(getUnregisterUser());
    }
}
