package com.dxy.service;

import com.dxy.entity.Student;

import java.util.List;

/**
 * @author 杜老板
 * @Version 1.0
 */
public interface StudentService {
    public List<Student> list();

    List<Student> search(String key, String value);

    void save(Student student);

    void update(Student student);

    void delete(Integer id, Integer dormitoryId);


    List<Student> searchByDormitoryId(Integer id);
}
