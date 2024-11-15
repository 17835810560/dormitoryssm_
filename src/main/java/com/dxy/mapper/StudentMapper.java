package com.dxy.mapper;

import com.dxy.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 杜老板
 * @Version 1.0
 */
public interface StudentMapper {
    public List<Student> list();

    List<Student> searchByNumber(String number);

    List<Student> searchByName(String name);

    void insert(Student student);

    void update(Student student);

    void delete(Integer id);

    List<Integer> findByDormitoryId(Integer dormitoryId);

    void updateStudentDormitoryId(@Param("dormitoryId") Integer availableDormitoryId,@Param("studentId") Integer studentId);

    List<Student> moveoutList();

    List<Student> moveoutSearchByNumber(String number);

    List<Student> moveoutSearchByName(String name);

    void updateStateByStudentId(String studentId);

    List<Student> searchByDormitoryId(Integer dormitoryId);
}
