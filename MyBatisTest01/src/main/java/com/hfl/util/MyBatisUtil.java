package com.hfl.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtil {
    private static SqlSessionFactory sqlSessionFactory=null;
    static {
        //1.定义mybatis主配置文件的名称, 从类路径的根开始（target/clasess）
        String config= "mybatis.xml";
        //2.读取这个config表示的文件
        InputStream in= null;
        try {
            in = Resources.getResourceAsStream(config);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //3.创建SqlSession对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        sqlSessionFactory=sqlSessionFactoryBuilder.build(in);

    }

    /**
     *
     * @return SqlSession对象
     */
    public static SqlSession getSqlSession(){
        SqlSession sqlSession=null;
        if(sqlSessionFactory!=null){
            sqlSession=sqlSessionFactory.openSession();
        }
        return sqlSession;

    }
}
