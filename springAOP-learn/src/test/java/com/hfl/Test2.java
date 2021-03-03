package com.hfl;

import com.hfl.service.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {

    @Test
    public void test1(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        SomeService someService=(SomeService)applicationContext.getBean("someService");
        //someService.doAspect("hh",8);
        //System.out.println("<=================================>");
        //String s=new String("abc");//s 0x1111
        //String s1=someService.doOther(s);
        //System.out.println(s1);
        //System.out.println("<=================================>");
        //someService.doSome();

        System.out.println("<=================================>");
        String rs = someService.doFirst("zhangsan",2);
        System.out.println("返回值"+rs);
    }
}
