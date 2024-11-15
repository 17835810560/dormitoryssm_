package com.dxy.controller;

import com.dxy.entity.Absent;
import com.dxy.entity.Building;
import com.dxy.entity.Dormitory;
import com.dxy.entity.Student;
import com.dxy.mapper.StudentMapper;
import com.dxy.service.AbsentService;
import com.dxy.service.BuildingService;
import com.dxy.service.DormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author 杜老板
 * @Version 1.0
 */
@Controller
@RequestMapping("/absent")
public class AbsentController {
    @Autowired
    private AbsentService absentService;
    @Autowired
    private BuildingService buildingService;
    @Autowired
    private DormitoryService dormitoryService;
    @Autowired
    private StudentMapper studentMapper;

    @GetMapping("/init")
    public ModelAndView init() {

        List<Building> buildingList = buildingService.list();
        Integer buildingId = buildingList.get(0).getId();
        List<Dormitory> dormitoryList = dormitoryService.searchByBuildingId(buildingId);
        Integer dormitoryId = dormitoryList.get(0).getId();
        List<Student> studentList = studentMapper.searchByDormitoryId(dormitoryId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("buildingList", buildingList);
        modelAndView.addObject("dormitoryList", dormitoryList);
        modelAndView.addObject("studentList", studentList);
        modelAndView.setViewName("absentregister");
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(Absent absent) {
        absentService.save(absent);
        return "redirect:/absent/init";
    }

    @GetMapping("/list")
    public ModelAndView list() {
        List<Absent> absentList = absentService.list();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list", absentList);
        modelAndView.setViewName("absentrecord");
        return modelAndView;
    }
    @PostMapping("/search")
    public ModelAndView search(String key,String value){
        List<Absent> absentList = absentService.search(key,value);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list", absentList);
        modelAndView.setViewName("absentrecord");
        return modelAndView;
    }

}
