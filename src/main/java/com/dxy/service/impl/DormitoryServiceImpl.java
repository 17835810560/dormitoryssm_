package com.dxy.service.impl;

import com.dxy.entity.Dormitory;
import com.dxy.mapper.DormitoryMapper;
import com.dxy.mapper.StudentMapper;
import com.dxy.service.DormitoryService;
import com.dxy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 杜老板
 * @Version 1.0
 */
@Service
public class DormitoryServiceImpl implements DormitoryService {
    @Autowired
    private DormitoryMapper dormitoryMapper;
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Dormitory> availableDormitory() {
        List<Dormitory> dormitoryList = dormitoryMapper.availableDormitory();
        return dormitoryList;
    }

    @Override
    public List<Dormitory> list() {
        List<Dormitory> dormitoryList = dormitoryMapper.list();
        return dormitoryList;
    }

    @Override
    public List<Dormitory> search(String key, String value) {
        List<Dormitory> dormitoryList = null;
        switch (key) {
            case "name":
                dormitoryList = dormitoryMapper.searchByName(value);
                break;
            case "telephone":
                dormitoryList = dormitoryMapper.searchByTelephone(value);
                break;
        }
        return dormitoryList;
    }

    @Override
    public void save(Dormitory dormitory) {
        try {
            dormitory.setAvailable(dormitory.getType());
            dormitoryMapper.insert(dormitory);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Dormitory dormitory) {
        dormitoryMapper.update(dormitory);
    }

    @Override
    public void delete(Integer dormitoryId) {
        try {
            List<Integer> studentIds = studentMapper.findByDormitoryId(dormitoryId);
            for (Integer studentId : studentIds) {
                List<Dormitory> dormitoryList = dormitoryMapper.availableDormitory();
                Integer availableDormitoryId = dormitoryList.get(0).getId();
                studentMapper.updateStudentDormitoryId(availableDormitoryId, studentId);
                dormitoryMapper.subAvailable(availableDormitoryId);
            }
            dormitoryMapper.delete(dormitoryId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Dormitory> searchByBuildingId(Integer buildingId) {
        return dormitoryMapper.searchByBuildingId(buildingId);
    }
}
