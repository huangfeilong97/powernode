package com.hfl.jdbc;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
    模拟实现用户登录功能
    (预编译数据库操作对象的使用)
 */
public class JDBCTest08 {
    public static void main(String[] args) {
        //1.初始化用户输入界面
        Map<String,String> userinfo=initUI();
        //2.判断用户输入用户名与密码是否存在
        boolean loginSuccess=login(userinfo);
        if(loginSuccess){
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        }
    }

    /**
     * 判断登录是否成功
     * @param userinfo 用户输入的登录信息
     * @return 登录成功与否 （true：登录成功  false:登录失败）
     */
    private static boolean login(Map<String, String> userinfo) {
        String username=userinfo.get("username");
        String password=userinfo.get("password");
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;

        try {
            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接
            conn= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/powernode","root","123456");
            //3.获取预编译的数据库操作对象
            //sql语句的框架中，一个?，表示一个占位符，一个?将来接收一个值。注意：?不要用单引号括起来
            String sql="select * from t_user where username=? and password=?";
            // 程序执行到此处，会发送sql语句框架给DBMS，DBMS对sql语句框架进行预编译。
            ps=conn.prepareStatement(sql);
            // 给占位符?传值，第一个?的下标是1，第二个?的下标是2（JDBC中下标都从1开始）
            ps.setString(1,username);
            ps.setString(2,password);

            //4.执行SQL语句
             /*
             String sql="select * from t_user where username='"+username+"' and password='"+password+"'";
            可能发生SQL注入现象 例：password = as' or '1'='1
            sql=select * from t_user where username='"+username+"' and password='as' or '1'='1'
            执行结果固定
             */
            rs=ps.executeQuery();
            //5.处理结果集
            if(rs.next()){
                return true;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //6.释放资源
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
        return false;
    }

    /**
     * 初始化用户界面
     * @return 用户输入的用户名及密码
     */
    private static Map<String, String> initUI() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username=sc.nextLine();
        System.out.println("请输入密码：");
        String password=sc.nextLine();
        Map<String,String> userinfo=new HashMap<>();
        userinfo.put("username",username);
        userinfo.put("password",password);
        return userinfo;
    }
}
