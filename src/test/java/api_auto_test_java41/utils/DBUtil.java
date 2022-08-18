package api_auto_test_java41.utils;

import javafx.collections.MapChangeListener;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static javafx.scene.input.KeyCode.O;

/**
 * @author qq音乐
 * @date 2022/7/22 - 17:55
 */
public class DBUtil {
    /**
     * 连接mysql数据库
     * @return connection连接对象
     */
    public static Connection getConnection(){
        //定义数据库连接
        //Oracle：jdbc:oracle:thin:@localhost:1521:DBName
        //SqlServer：jdbc:microsoft:sqlserver://localhost:1433; DatabaseName=DBName
        //MySql：jdbc:mysql://localhost:3306/DBName
        String url = "jdbc:mysql://mall.lemonban.com/yami_shops?useUnicode=true&characterEncoding=utf-8";
        String user="lemon";
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

    /**
     * 查询结果集单个字段的数据
     * @param sql 要执行的sql语句
     * @return    查询的结果
     * @throws SQLException
     */
    //ScalarHandler: 可以返回指定列的一个值或返回一个统计函数的值，比如count(1)。
    //ScalarHandler用来获得聚合函数的值,返回类型是Object,用Number来接收比较好
    public static Object querySingledata(String sql){
        //1.创建数据库连接对象
        Connection connection = getConnection();
        //2.生成QueryRunner对象
        QueryRunner queryRunner = new QueryRunner();
        //3.ScalarHandler回指定列的一个值或返回一个统计函数的值，比如count(1)。
        Object result = null;
        try {
            result = queryRunner.query(connection,sql,new ScalarHandler<Objects>());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    /**
     * 查询结果集所有数据
     * @param sql 要执行的sql语句
     * @return 查询的结果
     */
    public static List<Map<String,Object>> quaryAlldata(String sql){
        //1.创建数据库连接对象
        Connection connection = getConnection();
        //2.生成QueryRunner对象
        QueryRunner queryRunner = new QueryRunner();
        //3.将结果集中的每一行数据都封装到一个Map里，然后再存放到List
        List<Map<String,Object>> result= null;
        try {
            result = queryRunner.query(connection,sql,new MapListHandler());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }




    public static void main(String[] args) throws SQLException {
/*      //ScalarHandler用来获得聚合函数的值,返回类型是Object,用Number来接收比较好
//      ScalarHandler: 可以返回指定列的一个值或返回一个统计函数的值，比如count(1)。
        //1.创建数据库连接对象
        Connection connection = getConnection();
        //2.生成QueryRunner对象
        QueryRunner queryRunner = new QueryRunner();
        //3.通过queryRunner这个类的query方法来实现查询操作
        //重点:ScalarHandler:将结果集第一行的某一列放到某个对象中。
        Long result= queryRunner.query(connection,"select count(*) from tz_order;",new ScalarHandler<Long>());
        System.out.println("查询结果："+result);
*/


/*        //2-2:重点：MapHandler：将结果集中的第一行数据封装到一个Map里，key是列名，value就是对应的值。
        Connection connection = getConnection();
        QueryRunner queryRunner = new QueryRunner();
        Map<String, Object> result = queryRunner.query(connection,"select * from tz_order",new MapHandler());
        System.out.println("查询结果："+result);*/

        //2-3:MapListHandler：将结果集中的每一行数据都封装到一个Map里，然后再存放到List
/*        Connection connection = getConnection();
        QueryRunner queryRunner = new QueryRunner();
        List<Map<String, Object>> result= queryRunner.query(connection,"select * from tz_order where total>5",new MapListHandler());
        for (Map<String, Object> map:result) {
            //System.out.println(map);
            System.out.println("订单id为："+map.get("order_id"));
        }*/

    //=========================增删改==========================
/*        QueryRunner queryRunner = new QueryRunner();
        Connection connection = getConnection();
        //新增：
        int result =queryRunner.update(connection,"INSERT INTO tz_order VALUES ('1000000',1,'冰墩墩','f4d024ae5e004273850c13bd926d6507',3)");
        //删除
        int result1 =queryRunner.update(connection,"DELETE FROM tz_order WHERE order_id = 2");

        //修改:
        int result3 =queryRunner.update(connection,"UPDATE tz_order SET order_numbers=1000 WHERE order_id = 2;");*/
    }
    }

