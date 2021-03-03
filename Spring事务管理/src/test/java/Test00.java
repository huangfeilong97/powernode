import com.hfl.service.BuyService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test00 {

    @Test
    public void test1(){
        String config="applicationContext.xml";
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(config);

        BuyService service=(BuyService)applicationContext.getBean("buyService");
        service.buy(1005,10);

    }

}
