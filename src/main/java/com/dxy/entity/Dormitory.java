package com.dxy.entity;

import lombok.Data;

/**
 * @author 杜老板
 * @Version 1.0
 */
@Data
public class Dormitory {
    private Integer id;
    private Integer buildingId;
    private String buildingName;
    private String name;
    private Integer type;
    private Integer available;
    private String telephone;
}
