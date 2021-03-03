import com.github.pagehelper.PageHelper;
import com.hfl.dao.StudentDao;
import com.hfl.entity.Student;
import com.hfl.util.MyBatisUtil;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.util.List;

public class MyTest02 {
    @Test
    public void testSelect(){
        /**
         * List<Student> studentList  = dao.selectStudents(); 调用
         * 1.dao对象，类型是StudentDao，全限定名称是：com.bjpowernode.dao.StudentDao
         *   全限定名称 和 namespace 是一样的。
         *
         * 2.方法名称， selectStudents， 这个方法就是 mapper文件中的 id值 selectStudents
         *
         * 3.通过dao中方法的返回值也可以确定MyBatis要调用的SqlSession的方法
         *    如果返回值是List ，调用的是SqlSession.selectList()方法。
         *    如果返回值 int ，或是非List的， 看mapper文件中的 标签是<insert>，<update> 就会调用
         *    SqlSession的insert， update等方法
         *
         *  mybatis的动态代理： mybatis根据 dao的方法调用，获取执行sql语句的信息。
         *     mybatis根据你的dao接口，创建出一个dao接口的实现类， 并创建这个类的对象。
         *     完成SqlSession调用方法， 访问数据库。
         *
         */
        SqlSession sqlSession= MyBatisUtil.getSqlSession();
        /**
         * 使用mybatis的动态代理机制， 使用SqlSession.getMapper(dao接口)
         * getMapper能获取dao接口对应的实现类对象。
         */
        StudentDao dao=sqlSession.getMapper(StudentDao.class);//返回的是dao实现类

        // 获取第 1 页，3 条内容
        //紧跟在这个方法后的第一个 MyBatis 查询方法会被进行分页
        PageHelper.startPage(1,3);
        List<Student> studentList=dao.selectStudents();

        studentList.forEach(student -> System.out.println(student));

        sqlSession.close();

    }
    @Test
    public void testInsert(){
        SqlSession sqlSession= MyBatisUtil.getSqlSession();
        /**
         * 使用mybatis的动态代理机制， 使用SqlSession.getMapper(dao接口)
         * getMapper能获取dao接口对应的实现类对象。
         */
        StudentDao dao=sqlSession.getMapper(StudentDao.class);//返回的是dao实现类
        Student student=new Student(8,"关于","dy@qq.com",32);
        int insertStudent=dao.insertStudent(student);
        sqlSession.commit();

        System.out.println("插入"+insertStudent+"人");

        sqlSession.close();
    }

    @Test
    public void testSelectLike(){
        SqlSession sqlSession= MyBatisUtil.getSqlSession();
        /**
         * 使用mybatis的动态代理机制， 使用SqlSession.getMapper(dao接口)
         * getMapper能获取dao接口对应的实现类对象。
         */
        StudentDao dao=sqlSession.getMapper(StudentDao.class);//返回的是dao实现类

        String like="张%";
        List list=dao.selectLike(like);

        list.forEach(o -> System.out.println(o));

        sqlSession.close();
    }
}
