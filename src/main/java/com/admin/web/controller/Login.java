package com.admin.web.controller;

import com.admin.web.entity.User;
import com.admin.web.form.LoginForm;
import com.admin.web.service.UserService;
import com.admin.web.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/pub/v1")
public class Login {

    @Autowired
    private UserService userService;

    @PostMapping("login")
    @ResponseBody
    public Object login(@RequestBody LoginForm loginForm){
        User user = userService.login(loginForm);

        if (null == user){
            return  Result.error("登录失败");
        }

        return Result.success(user);
    }

}
