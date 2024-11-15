package com.dxy.entity;

import lombok.Data;

/**
 * @author 杜老板
 * @Version 1.0
 */

@Data
public class Student {
    private Integer id;
    private String number;
    private String name;
    private String gender;
    private Integer dormitoryId;
    private Integer oldDormitoryId;
    private String dormitoryName;
    private String state;
    private String createDate;
}
