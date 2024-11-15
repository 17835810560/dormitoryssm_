package com.dxy.service;

import com.dxy.entity.Moveout;
import com.dxy.entity.Student;

import java.util.List;

/**
 * @author 杜老板
 * @Version 1.0
 */
public interface MoveoutService {
    List<Student> list();

    List<Student> search(String key, String value);

    void register(Moveout moveout);

    List<Moveout> record();


    List<Moveout> recordSearch(String key, String value);
}
