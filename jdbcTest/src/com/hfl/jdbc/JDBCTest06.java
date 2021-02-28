package com.hfl.jdbc;

import java.sql.*;

/**
 * 1.注册驱动
 * 2.获取数据库连接
 * 3.获取数据库操作对象(获取预编译的数据库操作对象）
 * 4.执行 sql语句
 * 5.处理结果集
 * 6.释放数据库资源
 */
public class JDBCTest06 {
    public static void main(String[] args) {
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;

        try{
            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            /*
            Driver类中的静态代码块：
            static{
                try {
                    DriverManager.registerDriver(new Driver());
                } catch (SQLException var1) {
                    throw new RuntimeException("Can't register driver!");
                }
            }
            类似以下注册驱动方法：
            java.sql.Driver driver=new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);

             */
            //2.获取数据库连接
            conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/powernode","root","123456");
            //3.获取数据库操作对象
            stmt=conn.createStatement();
            //4.执行 sql语句
            String sql ="select ename,sal from emp where sal>1500";
            rs=stmt.executeQuery(sql);
            //5.处理结果集
            while(rs.next()){
                System.out.println("员工："+rs.getString("ename")+",薪水："+rs.getDouble("sal"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //6.释放数据库资源
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(stmt!=null){
                try {
                    stmt.close();
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
}
