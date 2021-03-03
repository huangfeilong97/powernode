package com.hfl.service.Impl;

import com.hfl.dao.StudentDao;
import com.hfl.entity.Student;
import com.hfl.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public int addStudent(Student student) {
        int result=studentDao.insertStudent(student);
        return result;
    }

    @Override
    public List<Student> queryStudents() {
        return null;
    }
}
