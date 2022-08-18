package api_auto_test_java41.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author 歪歪欧巴
 * @Description TODO
 * @date 2022/8/12 21:53
 * @Copyright 湖南省零檬信息技术有限公司. All rights reserved.
 */
public class PropertiesUtil {
    public static String readProperties(String filePath,String configName){
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //读取配置
        String result = properties.getProperty(configName);
        return result;
    }
}
