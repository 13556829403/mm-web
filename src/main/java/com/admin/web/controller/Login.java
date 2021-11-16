package com.admin.web.controller;

import com.admin.web.entity.User;
import com.admin.web.form.LoginForm;
import com.admin.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pub/v1")
public class Login {
    @Autowired
    private UserService userService;

    @GetMapping("login")
    @ResponseBody
    public Object login(Integer id){
        System.out.println("controller调用了");
        System.out.println(id);
        User user = userService.login(id);
        System.out.println(user);
        return user;
    }

    @PostMapping("login2")
    @ResponseBody
    public Object login2(@RequestBody LoginForm loginForm){
        System.out.println("controller调用了");
        System.out.println(loginForm);
        User user = userService.login2(loginForm);
        System.out.println(user);
        return user;
    }
}
