package com.dxy.controller;

import com.dxy.entity.Building;
import com.dxy.entity.DormitoryAdmin;
import com.dxy.service.BuildingService;
import com.dxy.service.DormitoryAdminService;
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
@RequestMapping("/building")
public class BuildingController {
    @Autowired
    private BuildingService buildingService;
    @Autowired
    private DormitoryAdminService dormitoryAdminService;
    @GetMapping("/list")
    public ModelAndView list() {
        List<Building> buildingList = buildingService.list();
        List<DormitoryAdmin> dormitoryAdminList = dormitoryAdminService.list();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list", buildingList);
        modelAndView.addObject("dormitoryAdminList",dormitoryAdminList);
        modelAndView.setViewName("buildingmanager");
        return modelAndView;
    }
    @PostMapping("/search")
    public ModelAndView search(String key,String value){
      List<Building> buildingList=  buildingService.search(key,value);
        List<DormitoryAdmin> dormitoryAdminList = dormitoryAdminService.list();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list", buildingList);
        modelAndView.addObject("dormitoryAdminList",dormitoryAdminList);
        modelAndView.setViewName("buildingmanager");
        return modelAndView;
    }
    @PostMapping("/save")
    public String save(Building building){
        buildingService.save(building);
        return "redirect:/building/list";
    }
    @PostMapping("/update")
    public String update(Building building){
        buildingService.update(building);
        return "redirect:/building/list";
    }
    @PostMapping("/delete")
    public String delete(Integer id){
        buildingService.delete(id);
        return "redirect:/building/list";
    }
}
