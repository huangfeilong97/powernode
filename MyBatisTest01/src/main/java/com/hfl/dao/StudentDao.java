package com.hfl.dao;

import com.hfl.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {
    //查找所有学生信息
    List<Student> selectStudents();

    //插入一条学生信息
    int insertStudent(Student student);

    //模糊查询
    List<Student> selectLike(@Param("like") String str);
}
