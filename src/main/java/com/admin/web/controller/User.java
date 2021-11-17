package com.admin.web.controller;

import com.admin.web.form.QueryUsersForm;
import com.admin.web.service.UserService;
import com.admin.web.utils.page.MyPageInfo;
import com.admin.web.utils.page.PageUtils;
import com.admin.web.utils.result.Result;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pri/v1")
public class User {
    @Autowired
    private UserService userService;

    @GetMapping("queryUserList")
    @ResponseBody
    public Object queryUserList(QueryUsersForm queryUsersForm){

        try{
            PageInfo<com.admin.web.entity.User> userPageInfo = userService.queryUserList(queryUsersForm);
            //返回数据列过多，自定义返回pageInfo
            MyPageInfo transition = PageUtils.transition(userPageInfo);
            return Result.success(transition);

        }catch (Exception e){
            System.out.println(e);
        }finally {
            return Result.error();
        }
    }
}
