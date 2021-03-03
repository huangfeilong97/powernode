package com.hfl.service.Impl;

import com.hfl.dao.StudentDao;
import com.hfl.entity.Student;
import com.hfl.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    @Override
    public int addStudent(Student student) {
        int result=studentDao.insertStudent(student);
        return result;
    }

    @Override
    public List<Student> findStudent() {
        List list=studentDao.selectStudent();
        return list;
    }
}
