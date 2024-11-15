package com.dxy.mapper;

import com.dxy.entity.Absent;

import java.util.List;

/**
 * @author 杜老板
 * @Version 1.0
 */
public interface AbsentMapper {

    void insert(Absent absent);

    List<Absent> list();

    List<Absent> searchByBuildingName(String buildingName);

    List<Absent> searchByDormitoryName(String dormitoryName);
}
