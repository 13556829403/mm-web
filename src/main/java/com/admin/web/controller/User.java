package com.admin.web.controller;

import com.admin.web.form.QueryUsersForm;
import com.admin.web.service.UserService;
import com.admin.web.utils.page.MyPageInfo;
import com.admin.web.utils.page.PageUtils;
import com.admin.web.utils.result.Result;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pri/v1")
@Api(value = "/pri/v1" ,tags = {"用户模块"})
public class User {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "查询用户列表",httpMethod = "GET" , notes = "需要token")
    @GetMapping("queryUserList")
    @ResponseBody
    public Object queryUserList(QueryUsersForm queryUsersForm){
            PageInfo<com.admin.web.entity.User> userPageInfo = userService.queryUserList(queryUsersForm);
            //返回数据列过多，自定义返回pageInfo
            MyPageInfo transition = PageUtils.transition(userPageInfo);
            return Result.success(transition);
    }

    @ApiOperation(value = "用户添加",httpMethod = "POST" , notes = "需要token")
    @PostMapping("addUser")
    @ResponseBody
    public Object addUser(User user){

        return null;
    }
}
