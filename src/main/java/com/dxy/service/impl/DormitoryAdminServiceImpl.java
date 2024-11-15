package com.dxy.service.impl;

import com.dxy.entity.DormitoryAdmin;
import com.dxy.mapper.DormitoryAdminMapper;
import com.dxy.service.DormitoryAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 杜老板
 * @Version 1.0
 */
@Service
public class DormitoryAdminServiceImpl implements DormitoryAdminService {
    @Autowired
    private DormitoryAdminMapper dormitoryAdminMapper;

    @Override
    public List<DormitoryAdmin> list() {
        List<DormitoryAdmin> list = dormitoryAdminMapper.list();
        return list;
    }

    @Override
    public List<DormitoryAdmin> search(String key, String value) {
        List<DormitoryAdmin> dormitoryAdmins=null;
       switch (key){
           case "username":
               dormitoryAdmins = dormitoryAdminMapper.searchByUsername(value);
               break;
           case "name":
               dormitoryAdmins = dormitoryAdminMapper.searchByName(value);
               break;
           case "telephone":
               dormitoryAdmins=dormitoryAdminMapper.searchByTelephone(value);
               break;
       }
       return dormitoryAdmins;
    }

    @Override
    public void save(DormitoryAdmin dormitoryAdmin) {
        try {
            dormitoryAdminMapper.save(dormitoryAdmin);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            dormitoryAdminMapper.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(DormitoryAdmin dormitoryAdmin) {
        try {
            dormitoryAdminMapper.update(dormitoryAdmin);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
