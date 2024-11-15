package com.dxy.service.impl;

import com.dxy.entity.Student;
import com.dxy.mapper.DormitoryMapper;
import com.dxy.mapper.StudentMapper;
import com.dxy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author 杜老板
 * @Version 1.0
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private DormitoryMapper dormitoryMapper;
    @Override
    public List<Student> list() {
        List<Student> studentList = studentMapper.list();
        return studentList;
    }

    @Override
    public List<Student> search(String key, String value) {
        List<Student> studentList=null;
        switch (key){
            case "number":
               studentList = studentMapper.searchByNumber(value);
                break;
            case "name":
                studentList = studentMapper.searchByName(value);
                break;
        }
        return studentList;
    }

    @Override
    public void save(Student student) {
        try {
            student.setState("入住");
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String newDate = simpleDateFormat.format(date);
            student.setCreateDate(newDate);
            studentMapper.insert(student);
            dormitoryMapper.subAvailable(student.getDormitoryId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Student student) {
        try {
            studentMapper.update(student);
            if (student.getDormitoryId()!=student.getOldDormitoryId()){
                dormitoryMapper.subAvailable(student.getDormitoryId());
                dormitoryMapper.addAvailable(student.getOldDormitoryId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id, Integer dormitoryId) {
        try {
            dormitoryMapper.addAvailable(dormitoryId);
            studentMapper.delete(id);
        } catch (Exception e) {e.printStackTrace();

        }
    }

    @Override
    public List<Student> searchByDormitoryId(Integer id) {
        List<Student> studentList = studentMapper.searchByDormitoryId(id);
        return studentList;
    }
}
