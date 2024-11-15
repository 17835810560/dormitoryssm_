package com.dxy.service.impl;

import com.dxy.entity.Moveout;
import com.dxy.entity.Student;
import com.dxy.mapper.DormitoryMapper;
import com.dxy.mapper.MoveoutMapper;
import com.dxy.mapper.StudentMapper;
import com.dxy.service.MoveoutService;
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
public class MoveoutServiceImpl implements MoveoutService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private MoveoutMapper moveoutMapper;
    @Autowired
    private DormitoryMapper dormitoryMapper;

    @Override
    public List<Student> list() {
        return studentMapper.moveoutList();
    }

    @Override
    public List<Student> search(String key, String value) {
        List<Student> studentList = null;
        switch (key) {
            case "number":
                studentList = studentMapper.moveoutSearchByNumber(value);
                break;
            case "name":
                studentList = studentMapper.moveoutSearchByName(value);
                break;
        }
        return studentList;
    }

    @Override
    public void register(Moveout moveout) {
        try {
            //在moveout表添加学生迁出信息
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String newDate = simpleDateFormat.format(new Date());
            moveout.setCreateDate(newDate);
            moveoutMapper.insert(moveout);
            //修改学生表学生的状态
            String studentId = moveout.getStudentId();
            studentMapper.updateStateByStudentId(studentId);
            //学生所在宿舍的可用床位数量加一
            String dormitoryIdStr = moveout.getDormitoryId();
            Integer dormitoryId = Integer.parseInt(dormitoryIdStr);
            dormitoryMapper.addAvailable(dormitoryId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Moveout> record() {
        List<Moveout> moveoutList = moveoutMapper.record();
        return moveoutList;
    }



    @Override
    public List<Moveout> recordSearch(String key, String value) {
        List<Moveout> moveoutList = null;
        switch (key) {
            case "studentName":
                moveoutList=moveoutMapper.recordSearchByStudentName(value);
                break;
            case "dormitoryName":
                moveoutList=moveoutMapper.recordSearchByDormitoryName(value);
                break;
        }
        return moveoutList;
    }
}
