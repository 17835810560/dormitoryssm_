package com.dxy.controller;

import com.dxy.entity.DormitoryAdmin;
import com.dxy.entity.Moveout;
import com.dxy.entity.Student;
import com.dxy.mapper.StudentMapper;
import com.dxy.service.MoveoutService;
import com.dxy.service.StudentService;
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
@RequestMapping("/moveout")
public class MoveoutController {
    @Autowired
    private MoveoutService moveoutService;

    @GetMapping("/list")
    public ModelAndView list() {
        List<Student> studentList = moveoutService.list();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list", studentList);
        modelAndView.setViewName("moveoutregister");
        return modelAndView;
    }

    @PostMapping("/search")
    public ModelAndView search(String key, String value) {
        List<Student> studentList = moveoutService.search(key, value);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list", studentList);
        modelAndView.setViewName("moveoutregister");
        return modelAndView;
    }

    @PostMapping("/register")
    public String register(Moveout moveout) {
        moveoutService.register(moveout);
        return "redirect:/moveout/list";
    }

    @GetMapping("/record")
    public ModelAndView record() {
        List<Moveout> moveoutList = moveoutService.record();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list", moveoutList);
        modelAndView.setViewName("moveoutrecord");
        return modelAndView;
    }
    @PostMapping("/recordSearch")
    public ModelAndView recordSearch(String key,String value){
        List<Moveout> moveoutList = moveoutService.recordSearch(key,value);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list", moveoutList);
        modelAndView.setViewName("moveoutrecord");
        return modelAndView;
    }
}
