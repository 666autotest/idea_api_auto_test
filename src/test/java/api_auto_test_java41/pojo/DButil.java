package api_auto_test_java41.pojo;

import java.sql.Connection;
import java.sql.DriverManager;

public class DButil {
    //1.定义数据库连接
    public static Connection getConnection() {
        //定义数据库连接
        //Oracle：jdbc:oracle:thin:@localhost:1521:DBName
        //SqlServer：jdbc:microsoft:sqlserver://localhost:1433; DatabaseName=DBName
        //MySql：jdbc:mysql://localhost:3306/DBName
        //1.数据量连接地址
        String url="jdbc:mysql://47.113.180.81/yami_shops?useUnicode=true&characterEncoding=utf-8&useSSL=true";
        //2.数据库用户名
        String user="lemon";
        //3.数据库用户名
        //注：这里的异常不能被抛出，因为这个方法要被其他使用者调用，所以只能内部处理。
        String password="lemon123";
        //定义数据库连接对象
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user,password);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void main(String[] args) {

    }
}


