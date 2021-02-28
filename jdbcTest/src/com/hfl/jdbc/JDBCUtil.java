package com.hfl.jdbc;

import java.sql.*;

/*
    JDBC工具类，简化JDBC编程
*/
public class JDBCUtil {
    /**
     * 工具类中的构造方法是私有的
     * 因为工具类中的方法都是静态的，直接通过类名去调即可。
     */
    private JDBCUtil(){

    }

    /**
     * 静态代码块，类加载的时候执行
     * 把注册驱动程序的代码放在静态代码块中，避免多次获取连接对象时重复调用
     */
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    /**
     * 获取数据库连接
     * @return
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/powernode","root","123456");

    }
    /**
     * 释放数据库资源
     */
    public static void close(Connection conn, Statement ps, ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(ps!=null){
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }



}
