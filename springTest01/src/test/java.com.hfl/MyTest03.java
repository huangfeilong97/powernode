
import com.hfl.annoentity.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest03 {

    @Test
    public void test01(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("anno/applicationContext.xml");
        Student student=(Student) applicationContext.getBean("myStudent");
        System.out.println(student);
    }
}
