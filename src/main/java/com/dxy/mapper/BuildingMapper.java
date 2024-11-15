package com.dxy.mapper;

import com.dxy.entity.Building;

import java.util.List;

/**
 * @author 杜老板
 * @Version 1.0
 */
public interface BuildingMapper {
    List<Building> list();

    List<Building> findByName(String value);

    List<Building> findByIntroduction(String value);

    void insert(Building building);

    void update(Building building);

    void delete(Integer id);

    Integer searchDormitoryAdminIdByBuildingId(Integer buildingId);
}
