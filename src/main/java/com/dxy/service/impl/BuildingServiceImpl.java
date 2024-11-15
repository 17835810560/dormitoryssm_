package com.dxy.service.impl;

import com.dxy.entity.Building;
import com.dxy.entity.Dormitory;
import com.dxy.mapper.BuildingMapper;
import com.dxy.mapper.DormitoryMapper;
import com.dxy.mapper.StudentMapper;
import com.dxy.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 杜老板
 * @Version 1.0
 */
@Service
public class BuildingServiceImpl implements BuildingService {
    @Autowired
    private BuildingMapper buildingMapper;
    @Autowired
    private DormitoryMapper dormitoryMapper;
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Building> list() {
        List<Building> buildingList = buildingMapper.list();
        return buildingList;
    }

    @Override
    public List<Building> search(String key, String value) {
        List<Building> buildingList = null;
        switch (key) {
            case "name":
                buildingList = buildingMapper.findByName(value);
                break;
            case "introduction":
                buildingList = buildingMapper.findByIntroduction(value);
                break;
        }
        return buildingList;
    }

    @Override
    public void save(Building building) {
        try {
            buildingMapper.insert(building);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Building building) {
        try {
            buildingMapper.update(building);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            //根据楼宇id查询它包含的所有宿舍id
            List<Integer> dormitoryIds = dormitoryMapper.findByBuildingId(id);
            for (Integer dormitoryId : dormitoryIds) {
                //根据宿舍id查询它包含的所有学生id
                List<Integer> studentIds = studentMapper.findByDormitoryId(dormitoryId);
                for (Integer studentId : studentIds) {
                    List<Dormitory> dormitoryList = dormitoryMapper.availableDormitory();
                    Integer availableDormitoryId = dormitoryList.get(0).getId();
                    studentMapper.updateStudentDormitoryId(availableDormitoryId,studentId);
                    dormitoryMapper.subAvailable(availableDormitoryId);
                }
                dormitoryMapper.delete(dormitoryId);
            }
            buildingMapper.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
