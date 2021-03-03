import com.hfl.entity.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class MyTest02 {
    @Test
    public void test01(){
        System.out.println("=====test01========");
        String config="applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        //从容器中获取Student对象
        Student myStudent =  (Student) ac.getBean("Student");
        System.out.println("student对象="+myStudent);


        Date myDate = (Date) ac.getBean("mydate");
        System.out.println("myDate="+myDate);

    }

    @Test
    public void test02(){
        System.out.println("===test02===");
        String config="applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        //从容器中获取Student对象
        Student myStudent1 =  (Student) ac.getBean("myStudent1");
        Student myStudent2 =  (Student) ac.getBean("myStudent2");
        System.out.println("student1对象="+myStudent1);
        System.out.println("student2对象="+myStudent2);
    }
}
