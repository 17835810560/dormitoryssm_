package com.dxy.mapper;

import com.dxy.entity.Moveout;

import java.util.List;

/**
 * @author 杜老板
 * @Version 1.0
 */
public interface MoveoutMapper {

    void insert(Moveout moveout);

    List<Moveout> record();

    List<Moveout> recordSearchByStudentName(String studentName);

    List<Moveout> recordSearchByDormitoryName(String dormitoryName);
}
