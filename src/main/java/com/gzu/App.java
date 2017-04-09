package com.gzu;
import java.sql.*;


/**
 * Hello world!
 *
 */
public class App {
    public static final String URL = "jdbc:mysql://114.215.150.201/yjun";
    public static final String USER = "yjun";
    public static final String PASS = "123456";
    private static Connection conn;

    public static void main(String[] args) {
        //加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("驱动加载成功");
            conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("数据库连接成功");
        } catch (ClassNotFoundException e) {
            System.err.println("驱动加载失败");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("连接错误");
            e.printStackTrace();
        }

        //数据查询块
        //查询数据库的sql语句
        String sql = "select * from student";
        //获得Statement
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                String name = result.getString("name");
                System.out.print(name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}