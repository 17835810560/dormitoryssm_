package com.dxy.controller;

import com.dxy.entity.Dormitory;
import com.dxy.entity.Student;
import com.dxy.service.DormitoryService;
import com.dxy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author 杜老板
 * @Version 1.0
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private DormitoryService dormitoryService;

    @GetMapping("/list")
    public ModelAndView list() {
        List<Student> studentList = studentService.list();
        List<Dormitory> dormitoryList = dormitoryService.availableDormitory();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list", studentList);
        modelAndView.addObject("dormitoryList", dormitoryList);
        modelAndView.setViewName("studentmanager");
        return modelAndView;
    }

    @PostMapping("/search")
    public ModelAndView search(String key, String value) {
        List<Student> studentList = studentService.search(key, value);
        List<Dormitory> dormitoryList = dormitoryService.availableDormitory();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("list", studentList);
        modelAndView.addObject("dormitoryList", dormitoryList);
        modelAndView.setViewName("studentmanager");
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(Student student) {
        studentService.save(student);
        return "redirect:/student/list";
    }

    @PostMapping("/update")
    public String update(Student student) {
        studentService.update(student);
        return "redirect:/student/list";
    }

    @PostMapping("/delete")
    public String delete(Integer id, Integer dormitoryId) {
        studentService.delete(id, dormitoryId);
        return "redirect:/student/list";
    }
    @PostMapping("/findByDormitoryId")
    @ResponseBody
    public List findByDormitoryId(Integer dormitoryId){
        List<Student> studentList = studentService.searchByDormitoryId(dormitoryId);
        return studentList;
    }
}
