package com.hfl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTest09 {
    public static void main(String[] args) {

        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            //注册驱动，获取连接
            conn=JDBCUtil.getConnection();
            //获取预编译数据库操作对象
            String sql="select * from dept";
            ps=conn.prepareStatement(sql);
            //执行SQL语句
            rs=ps.executeQuery();
            //处理结果集
            while(rs.next()){
                System.out.println(rs.getString("deptno")+":"+rs.getString("dname")+":"+rs.getString("loc"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtil.close(conn,ps,rs);
        }
    }
}
