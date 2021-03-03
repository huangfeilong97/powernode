import com.hfl.entity.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.io.Resources;
import org.junit.Test;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyTest01 {
    @Test
    public void testSelect() throws IOException {
        //1.定义mybatis主配置文件的名称, 从类路径的根开始（target/clasess）
        String config= "mybatis.xml";
        //2.读取这个config表示的文件
        InputStream in=Resources.getResourceAsStream(config);
        //3.创建SqlSession对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory=sqlSessionFactoryBuilder.build(in);
        SqlSession sqlSession=sqlSessionFactory.openSession();

        //4.【重要】指定要执行的sql语句的标识。  sql映射文件中的namespace + "." + 标签的id值
        String sqlmapper="com.hfl.dao.StudentDao"+"."+"selectStudents";
        //5.【重要】执行sql语句，通过namespace.id找到语句
        List<Student> list= sqlSession.selectList(sqlmapper);
        //6.处理结果
        list.forEach(student -> System.out.println(student));

        String sql2="com.hfl.dao.StudentDao.insertStudent";
        Student student=new Student(5,"张飞","zhangfei@qq.com",20);
        int result=sqlSession.insert(sql2,student);

        //mybatis默认不是自动提交事务的， 所以在insert ，update ，delete后要手工提交事务
        sqlSession.commit();
        System.out.println("执行insert的结果="+result);

        //7.关闭sqlSession
        sqlSession.close();

    }

}
