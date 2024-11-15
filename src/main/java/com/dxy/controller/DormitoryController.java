package com.dxy.controller;

import com.dxy.entity.Building;
import com.dxy.entity.Dormitory;
import com.dxy.entity.Student;
import com.dxy.mapper.StudentMapper;
import com.dxy.service.BuildingService;
import com.dxy.service.DormitoryService;
import com.dxy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 杜老板
 * @Version 1.0
 */
@Controller
@RequestMapping("/dormitory")
public class DormitoryController {
    @Autowired
    private DormitoryService dormitoryService;
    @Autowired
    private BuildingService buildingService;
    @Autowired
    private StudentService studentService;

    @GetMapping("/list")
    public ModelAndView list() {
        List<Dormitory> dormitoryList = dormitoryService.list();
        List<Building> buildingList = buildingService.list();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list", dormitoryList);
        modelAndView.addObject("buildingList", buildingList);
        modelAndView.setViewName("dormitorymanager");
        return modelAndView;
    }

    @PostMapping("/search")
    public ModelAndView search(String key, String value) {
        List<Dormitory> dormitoryList = dormitoryService.search(key, value);
        List<Building> buildingList = buildingService.list();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list", dormitoryList);
        modelAndView.addObject("buildingList", buildingList);
        modelAndView.setViewName("dormitorymanager");
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(Dormitory dormitory) {
        dormitoryService.save(dormitory);
        return "redirect:/dormitory/list";
    }

    @PostMapping("/update")
    public String update(Dormitory dormitory) {
        dormitoryService.update(dormitory);
        return "redirect:/dormitory/list";
    }

    @PostMapping("/delete")
    public String delete(Integer id) {
        dormitoryService.delete(id);
        return "redirect:/dormitory/list";
    }

    @PostMapping("/findByBuildingId")
    @ResponseBody
    public List findByBuildingId(Integer buildingId) {
        List<Dormitory> dormitoryList = dormitoryService.searchByBuildingId(buildingId);
        ArrayList list = new ArrayList();
        if (dormitoryList.size() > 0) {
            List<Student> studentList = studentService.searchByDormitoryId(dormitoryList.get(0).getId());
             list.add(dormitoryList);
             list.add(studentList);
        }else {
            list.add(new ArrayList<>());
            list.add(new ArrayList<>());
        }
        return list;
    }

}
