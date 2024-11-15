package com.dxy.service;

import com.dxy.entity.Dormitory;

import java.util.List;

/**
 * @author 杜老板
 * @Version 1.0
 */
public interface DormitoryService {
    public List<Dormitory> availableDormitory();

    List<Dormitory> list();

    List<Dormitory> search(String key, String value);

    void save(Dormitory dormitory);

    void update(Dormitory dormitory);

    void delete(Integer dormitoryId);

    List<Dormitory> searchByBuildingId(Integer buildingId);
}
