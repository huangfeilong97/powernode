package com.hfl.service;

import com.hfl.entity.Student;

import java.util.List;

public interface StudentService {

    int addStudent(Student student);

    List<Student> queryStudents();
}
