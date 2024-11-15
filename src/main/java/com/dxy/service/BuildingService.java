package com.dxy.service;

import com.dxy.entity.Building;

import java.util.List;

/**
 * @author 杜老板
 * @Version 1.0
 */
public interface BuildingService {
    List<Building> list();

    List<Building> search(String key, String value);

    void save(Building building);

    void update(Building building);

    void delete(Integer id);
}
