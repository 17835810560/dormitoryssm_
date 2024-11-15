package com.dxy.entity;

import lombok.Data;

/**
 * @author 杜老板
 * @Version 1.0
 */
@Data
public class Moveout {
    private Integer id;
    private String studentId;
    private String studentName;
    private String dormitoryId;
    private String dormitoryName;
    private String reason;
    private String createDate;
}
