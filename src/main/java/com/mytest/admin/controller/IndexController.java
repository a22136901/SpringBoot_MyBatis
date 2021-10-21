package com.mytest.admin.controller;

import com.mytest.admin.bean.User;

import com.mytest.admin.servie.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @GetMapping (value = {"/","/login"})
    public String toLogin(){
        return "login";
    }

    @PostMapping("/login")
    public String login(HttpSession session){
        session.setAttribute("loginUser","temp");
        return "redirect:index";
    }

    @GetMapping("/index")
    public String toIndex(){
        return "index";
    }

    //mybatis的基本测试，在页面使用路径来查询。
    @ResponseBody
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") Integer id){
        return userService.getUserById(id);
    }
}
