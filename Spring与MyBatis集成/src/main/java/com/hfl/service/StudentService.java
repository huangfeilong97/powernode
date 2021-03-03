package com.hfl.service;

import com.hfl.entity.Student;

import java.util.List;

public interface StudentService {

    //添加学生
    int addStudent(Student student);
    
    //查找学生
    List<Student> queryStudents();
}
