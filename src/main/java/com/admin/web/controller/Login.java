package com.admin.web.controller;

import com.admin.web.entity.User;
import com.admin.web.form.LoginForm;
import com.admin.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pub/v1")
public class Login {
    @Autowired
    private UserService userService;

    @PostMapping("login")
    public Object login(@RequestBody LoginForm loginForm){
        System.out.println(loginForm.toString());
        User user = userService.login(loginForm);
        return user;
    }
}
