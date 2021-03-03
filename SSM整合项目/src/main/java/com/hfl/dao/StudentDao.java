package com.hfl.dao;

import com.hfl.entity.Student;

import java.util.List;

public interface StudentDao {
    int insertStudent(Student student);

    List<Student> selectStudent();
}
