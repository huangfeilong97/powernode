package com.hfl.service.impl;

import com.hfl.service.SomeService;
import org.springframework.stereotype.Component;

@Component("someService")
public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome() {
        System.out.println("执行方法doSome");
    }

    @Override
    public String doOther(String s) {
        System.out.println("执行方法doOther");
        return s;
    }

    @Override
    public void doAspect(String s, Integer i) {
        System.out.println("执行目标类方法");
    }

    @Override
    public String doFirst(String name, Integer age) {
        System.out.println("====业务方法doFirst()====");
        return "doFirst";
    }
}
