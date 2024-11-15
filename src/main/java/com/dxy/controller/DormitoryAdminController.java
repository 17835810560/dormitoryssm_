package com.dxy.controller;

import com.dxy.entity.DormitoryAdmin;
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
@RequestMapping("/dormitoryAdmin")
public class DormitoryAdminController {
    @Autowired
    private DormitoryAdminService dormitoryAdminService;
    @GetMapping("/list")
    public ModelAndView list(){
        ModelAndView modelAndView = new ModelAndView();
        List<DormitoryAdmin> list = dormitoryAdminService.list();
        modelAndView.addObject("list",list);
        modelAndView.setViewName("adminmanager");
        return modelAndView;
    }
    @PostMapping("/search")
    public ModelAndView search(String key,String value){
        List<DormitoryAdmin> dormitoryAdmins = dormitoryAdminService.search(key, value);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list", dormitoryAdmins);
        modelAndView.setViewName("adminmanager");
        return modelAndView;
    }
    @PostMapping("/save")
    public String save(DormitoryAdmin dormitoryAdmin){
        dormitoryAdminService.save(dormitoryAdmin);
        return "redirect:/dormitoryAdmin/list";
    }
    @PostMapping("/delete")
    public String delete(Integer id){
        dormitoryAdminService.delete(id);
        return "redirect:/dormitoryAdmin/list";
    }
    @PostMapping("/update")
    public String update(DormitoryAdmin dormitoryAdmin){
        dormitoryAdminService.update(dormitoryAdmin);
        return "redirect:/dormitoryAdmin/list";
    }
}
