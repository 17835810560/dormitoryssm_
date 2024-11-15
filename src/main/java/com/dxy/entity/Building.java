package com.dxy.entity;

import lombok.Data;

/**
 * @author 杜老板
 * @Version 1.0
 */
@Data
public class Building {
    private Integer id;
    private String name;
    private String introduction;
    private Integer adminId;
    private String adminName;
}
