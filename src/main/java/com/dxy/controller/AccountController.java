package com.dxy.controller;

import com.dxy.dto.AccountDto;
import com.dxy.entity.SystemAdmin;
import com.dxy.form.AccountForm;
import com.dxy.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @author 杜老板
 * @Version 1.0
 */
@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/login")
    public ModelAndView login(AccountForm accountForm, HttpSession session) {
        AccountDto accountDto = accountService.login(accountForm);
        ModelAndView modelAndView = new ModelAndView();
        switch (accountDto.getCode()) {
            case -1:
                modelAndView.addObject("usernameError", "账号输入错误");
                modelAndView.setViewName("login");
                break;
            case -2:
                modelAndView.addObject("passwordError", "密码输入错误");
                modelAndView.setViewName("login");
                break;
            case 0:
                if (accountForm.getType().equals("systemAdmin")) {
                    session.setAttribute("systemAdmin", accountDto.getAdmin());
                    modelAndView.setViewName("systemadmin");
                } else {
                    session.setAttribute("dormitoryAdmin", accountDto.getAdmin());
                    modelAndView.setViewName("dormitoryadmin");
                }
                break;
        }
        return modelAndView;
    }
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "login";
    }
}
