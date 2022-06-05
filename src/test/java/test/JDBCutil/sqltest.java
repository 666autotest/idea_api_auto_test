package test.JDBCutil;

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
public class sqltest {
    public static Connection getconnection(){
        String sqlurl="jdbc:mysql://api.lemonban.com/futureloan?useUnicode=true&characterEncoding=utf-8";
        String username="future";
        String password="123456";
        Connection connection=null;
        try {
            connection = DriverManager.getConnection(sqlurl,username,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;


    }

    public static Object querysinger() {



        Connection getconnection = getconnection();
        String querysinger="select count(*) from member where id=2";
        QueryRunner queryRunner=new QueryRunner();
        Object query2=null;
        try {
            query2 = queryRunner.query(getconnection, querysinger, new ScalarHandler<Object>());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return query2;


    }
//********************查询单个sql的***********************************************

    public static Map<String, Object> queryone() {



        Connection getconnection = getconnection();
        String querysinger="select mobllephone from member where id=2";
        QueryRunner queryRunner=new QueryRunner();
        Map<String, Object> query=null;
        try {
            query = queryRunner.query(getconnection, querysinger, new MapHandler());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return query;


    }



//********************查询所有sql信息的***********************************************

    public static List<Map<String, Object>> queryall() {



        Connection getconnection = getconnection();
        String querysinger="select *from member where id<10";
        QueryRunner queryRunner=new QueryRunner();
        List<Map<String, Object>> query3=null;
        try {
             query3 = queryRunner.query(getconnection, querysinger, new MapListHandler());
            System.out.println(query3);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return query3;



    }


    //*******************************新增/修改*****************************************
    public static void update() {
    Connection getconnection = getconnection();
    String sqlstr="update member set reg_name ='213' where id=202132";
    QueryRunner queryRunner=new QueryRunner();
    try {
        queryRunner.update(getconnection,sqlstr);
    } catch (SQLException throwables) {
        throwables.printStackTrace();
    }


}

    public static void main(String[] args) {
        sqltest.queryall();


    }


}
