package com.hfl;

import com.hfl.service.SomeService;
import com.hfl.service.handler.MyProxyHandler;
import com.hfl.service.impl.SomeServiceImpl;

import java.lang.reflect.Proxy;

public class Test1 {
    public static void main(String[] args) {
        /*SomeService someService=new SomeServiceImpl();
        someService.doSome();

        System.out.println("<===============================>");
        someService.doOther();*/

        //1.创建目标类
        SomeService someService=new SomeServiceImpl();

        MyProxyHandler handler=new MyProxyHandler(someService);

        //2.动态创建代理对象
        SomeService proxy=(SomeService) Proxy.newProxyInstance(someService.getClass().getClassLoader(),
                someService.getClass().getInterfaces(),handler);

        proxy.doSome();

        System.out.println("<===============>");

        proxy.doOther("abc");

    }

}
