package test.util;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author luxi
 * @date 2021/10/25 0:39
 */
public class JDBCUtils {
    /**
     * 连接MYSQL数据库
     *
     * @return Connection 连接对象
     */
    public static Connection getConnection() {
        //定义数据库连接
        //Oracle：jdbc:oracle:thin:@localhost:1521:DBName
        //SqlServer：jdbc:microsoft:sqlserver://localhost:1433; DatabaseName=DBName
        //MySql：jdbc:mysql://localhost:3306/DBName
        String url = "jdbc:mysql://mall.lemonban.com/yami_shops?useUnicode=true&characterEncoding=utf-8";
        String user = "lemon";
        String password = "lemon123";
        //定义数据库连接对象
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void main(String[] args) throws SQLException {
        //0.创建数据库连接
        Connection connection = getConnection();
        //1.生成QueryRUnner对象
        QueryRunner queryRunner = new QueryRunner();
        //2.调用query方法来实现查询操作
        //2.多条结果集
        //List<Map<String,Object>> Datas = queryRunner.query(connection,"select * from tz_sms_log", new MapListHandler());
        //System.out.println(Datas.get(0));//获取到第一条数据
        //System.out.println(Datas.get(0).get("mobile_code"));//获取到mobile_code字段
        //2-2.一条结果集
        //Map<String,Object> Datas =queryRunner.query(connection,"select * from tz_sms_log where id = 8",new MapHandler());
        //System.out.println(Datas);
        //2-3.单个字段数据
        //数据类型按查询的字段来定义
        String code = queryRunner.query(connection, "select mobile_code from tz_sms_log where id = (select MAX(id) from tz_sms_log);", new ScalarHandler<>());
        System.out.println(code);
        System.out.println(quarySingData("select mobile_code from tz_sms_log where id = (select MAX(id) from tz_sms_log);"));
        System.out.println(quaryonedata("select mobile_code from tz_sms_log where id = (select MAX(id) from tz_sms_log);"));

    }
    //将数据库查询方法封装

    /**
     * 查询单个字段数据
     *
     * @param sql 执行sql语句
     * @return 结果
     */
    public static Object quarySingData(String sql) {
        //参数化替换
        sql=Environment.replacParams(sql);
        Connection connection = getConnection();
        QueryRunner queryRunner = new QueryRunner();
        Object data = null;
        //"select mobile_code from tz_sms_log where id = (select MAX(id) from tz_sms_log);
        try {
            data = queryRunner.query(connection,sql, new ScalarHandler<>());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return data;
    }

    /**
     * 查询结果集中的一条数据
     * @param sql 执行sql语句
     * @return 结果
     */
    public static Map<String, Object> quaryonedata(String sql) {
        Connection connection = getConnection();
        QueryRunner queryRunner = new QueryRunner();
        Map<String, Object> data = null;
        //"select mobile_code from tz_sms_log where id = (select MAX(id) from tz_sms_log);"
        try {
            data = queryRunner.query(connection,sql, new MapHandler());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return data;
    }
}
