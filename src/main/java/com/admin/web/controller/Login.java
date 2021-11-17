package com.admin.web.controller;

import com.admin.web.form.LoginForm;
import com.admin.web.service.UserService;
import com.admin.web.utils.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@Api(value = "/pub/v1" ,tags = {"登录模块"})
@RequestMapping("/pub/v1")
public class Login {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "登录",httpMethod = "POST" , notes = "使用表单登录")
    @PostMapping("login")
    @ResponseBody
    public Object login(@RequestBody LoginForm loginForm){
        String token = userService.login(loginForm);

        if (null == token){
            return  Result.error("登录失败");
        }

        Map result = new HashMap<String, String>();
        result.put("token",token);

        System.out.println(result);
        return Result.success(result);
    }



}
