package com.dxy.mapper;

import com.dxy.entity.SystemAdmin;

/**
 * @author 杜老板
 * @Version 1.0
 */
public interface SystemAdminMapper {
    SystemAdmin findByUsername(String username);
}
