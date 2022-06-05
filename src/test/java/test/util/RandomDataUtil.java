package test.util;

import com.github.javafaker.Faker;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Locale;

/**
 * @author luxi
 * @date 2021/10/25 0:39
 */
public class RandomDataUtil {
    public static void main(String[] args) {
/*      //1.使用faker库生存随机的数据(Locale.CANADA:指定地区为中国)
        Faker faker = new Faker(Locale.CHINA);
        //2.随机生成城市号
        System.out.println(faker.address().city());
        //3.随机生成完整的地址
        System.out.println(faker.address().fullAddress());
        //.随机生成一个名字
        System.out.println(faker.name().fullName());
        System.out.println(faker.name().firstName());
        System.out.println(faker.name().lastName());
 */
        getUnregisterName();
    }

    /**
     * 生成未注册的手机号码
     *
     * @return randomPhone
     */
    public static String getUnregisterPhone() {
        Faker faker = new Faker(Locale.CHINA);
        String randomPhone = faker.phoneNumber().cellPhone();
        String sql = "SELECT COUNT(*) FROM tz_user WHERE user_mobile='" + randomPhone + "';";
        System.out.println(randomPhone);
        while (true) {
            long count = (long) JDBCUtils.quarySingData(sql);
            //count == 0，手机号码违背注册
            if (count == 0) {
                break;
                //count == 1,手机号已被注册，需重新执行一次sql生成一个新的手机号
            } else if (count == 1) {
                randomPhone = faker.phoneNumber().cellPhone();
                sql = "SELECT COUNT(*) FROM tz_user WHERE user_mobile='" + randomPhone + "';";
            }
        }
        return randomPhone;
    }

    /**
     * 获取未注册的用户名
     *
     * @return randomName
     */
    public static String getUnregisterName() {
        Faker faker = new Faker();
        String randomName = faker.name().lastName();
        String sql = "SELECT COUNT(*) FROM tz_user WHERE user_name='" + randomName + "';";
        System.out.println(randomName);
        while (true) {
            long count = (long) JDBCUtils.quarySingData(sql);
            //count == 0，手机号码违背注册
            if (count == 0) {
                break;
                //count == 1,手机号已被注册，需重新执行一次sql生成一个新的手机号
            } else if (count == 1) {
                randomName = faker.phoneNumber().cellPhone();
                sql = "SELECT COUNT(*) FROM tz_user WHERE user_mobile='" + randomName + "';";
            }
        }
        return randomName;
    }
}