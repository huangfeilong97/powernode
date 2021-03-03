package com.hfl.controller;

import com.hfl.entity.Student;
import com.hfl.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService service;

    //注册功能
    @RequestMapping("/addStudent")
    public ModelAndView addStudent(Student student){
        ModelAndView mv=new ModelAndView();
        int result=service.addStudent(student);
        if(result>0){
            mv.addObject("msg","注册成功");
            mv.setViewName("result");
        }else{
            mv.addObject("msg","注册失败");
            mv.setViewName("result");
        }
        return mv;
    }

    //查找学生
    @RequestMapping("/findStudent")
    @ResponseBody
    public List<Student> findStudent(){
        List<Student> list=service.findStudent();
        return list;
    }
}
