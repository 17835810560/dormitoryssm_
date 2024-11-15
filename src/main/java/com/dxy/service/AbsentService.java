package com.dxy.service;

import com.dxy.entity.Absent;

import java.util.List;

/**
 * @author 杜老板
 * @Version 1.0
 */
public interface AbsentService {

    void save(Absent absent);

    List<Absent> list();

    List<Absent> search(String key, String value);
}
