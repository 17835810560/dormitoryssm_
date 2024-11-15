package com.dxy.mapper;

import com.dxy.entity.Dormitory;

import java.util.List;

/**
 * @author 杜老板
 * @Version 1.0
 */
public interface DormitoryMapper {
    List<Dormitory> availableDormitory();

    void subAvailable(Integer dormitoryId);
    void addAvailable(Integer OlddormitoryId);
    List<Integer> findByBuildingId(Integer buildingId);

    void delete(Integer dormitoryId);

    List<Dormitory> list();

    List<Dormitory> searchByName(String name);

    List<Dormitory> searchByTelephone(String telephone);

    void insert(Dormitory dormitory);

    void update(Dormitory dormitory);

    List<Dormitory> searchByBuildingId(Integer buildingId);
}
