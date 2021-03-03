package com.hfl.controller;

import com.hfl.entity.Student;
import com.hfl.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class registerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String email = req.getParameter("email");

        //创建容器
        //ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");

        //String attr=WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE;
        //ApplicationContext ac=(ApplicationContext)getServletContext().getAttribute(attr);

        ApplicationContext ac=WebApplicationContextUtils.getWebApplicationContext(getServletContext());


        StudentService studentService=(StudentService)ac.getBean("studentService");
        Student student=new Student(null,name,email,Integer.valueOf(age));

        int result=0;
        result=studentService.addStudent(student);

        if(result==1){
            req.setAttribute("result","注册成功");
        }else {
            req.setAttribute("result","注册失败");
        }

        req.getRequestDispatcher("/result.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String email = req.getParameter("email");

        //创建容器
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService studentService=(StudentService)ac.getBean("studentService");

        Student student=new Student(null,name,email,Integer.valueOf(age));

        int result=0;
        result=studentService.addStudent(student);

        if(result==1){
            req.setAttribute("result","注册成功");
        }else {
            req.setAttribute("result","注册失败");
        }

        req.getRequestDispatcher("/result.jsp").forward(req,resp);


    }
}
