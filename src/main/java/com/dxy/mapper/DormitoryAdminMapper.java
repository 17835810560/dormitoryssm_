package com.dxy.mapper;

import com.dxy.entity.DormitoryAdmin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 杜老板
 * @Version 1.0
 */
public interface DormitoryAdminMapper {
    DormitoryAdmin findByUsername(String username);
    List<DormitoryAdmin> list();
    List<DormitoryAdmin> searchByUsername(String value);
    List<DormitoryAdmin> searchByName(String value);
    List<DormitoryAdmin> searchByTelephone(String value);
    void save(DormitoryAdmin dormitoryAdmin);

    void deleteById(Integer id);

    void update(DormitoryAdmin dormitoryAdmin);

}
