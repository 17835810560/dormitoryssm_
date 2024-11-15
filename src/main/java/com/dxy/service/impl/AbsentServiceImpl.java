package com.dxy.service.impl;

import com.dxy.entity.Absent;
import com.dxy.mapper.AbsentMapper;
import com.dxy.mapper.BuildingMapper;
import com.dxy.mapper.DormitoryAdminMapper;
import com.dxy.service.AbsentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 杜老板
 * @Version 1.0
 */
@Service
public class AbsentServiceImpl implements AbsentService {
    @Autowired
    private AbsentMapper absentMapper;
    @Autowired
    private BuildingMapper buildingMapper;

    @Override
    public void save(Absent absent) {
        Integer buildingId = absent.getBuildingId();
        Integer dormitoryAdminId = buildingMapper.searchDormitoryAdminIdByBuildingId(buildingId);
        absent.setDormitoryAdminId(dormitoryAdminId);
        absentMapper.insert(absent);
    }

    @Override
    public List<Absent> list() {
       return absentMapper.list();
    }

    @Override
    public List<Absent> search(String key, String value) {
        List<Absent> absentList=null;
        if (value.equals("")){
            absentList=absentMapper.list();
        }
        switch (key){
            case "buildingName":
              absentList=  absentMapper.searchByBuildingName(value);
                break;
            case "dormitoryName":
                absentList= absentMapper.searchByDormitoryName(value);
                break;
        }
        return absentList;
    }
}
