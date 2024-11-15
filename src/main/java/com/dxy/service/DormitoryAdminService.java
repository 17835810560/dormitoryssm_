package com.dxy.service;

import com.dxy.entity.DormitoryAdmin;

import java.util.List;

/**
 * @author 杜老板
 * @Version 1.0
 */
public interface DormitoryAdminService {
    List<DormitoryAdmin> list();
    List<DormitoryAdmin> search(String key,String value);

    void save(DormitoryAdmin dormitoryAdmin);

    void delete(Integer id);

    void update(DormitoryAdmin dormitoryAdmin);
}
