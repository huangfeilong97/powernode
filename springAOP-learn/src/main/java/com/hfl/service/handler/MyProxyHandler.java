package com.hfl.service.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

public class MyProxyHandler implements InvocationHandler {
    //目标类
    private Object target;

    public MyProxyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object res=null;

        System.out.println("当前时间"+(new Date()));
        //调用目标类方法
        res=method.invoke(target,args);

        if("doOther".equals(method.getName())){

            System.out.println("提交事务");
        }

        return res;
    }
}
