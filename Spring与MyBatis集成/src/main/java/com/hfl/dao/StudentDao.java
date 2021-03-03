package com.hfl.dao;

import com.hfl.entity.Student;

import java.util.List;

public interface StudentDao {
    //插入学生
    int insertStudent(Student student);
    
    //查找所有学生
    List<Student> selectStudents();
}
