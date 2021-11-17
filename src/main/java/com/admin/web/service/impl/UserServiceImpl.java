package com.admin.web.service.impl;

import com.admin.web.entity.User;
import com.admin.web.form.LoginForm;
import com.admin.web.form.QueryUsersForm;
import com.admin.web.mapper.UserMapper;
import com.admin.web.service.UserService;
import com.admin.web.utils.CommonUtils.JwtUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public String login(LoginForm loginForm) {
        User user = userMapper.login(loginForm);
        if (user == null){
            return null;
        }else {
            String token = JwtUtils.geneJsonWebToken(user);
            return token;
        }

    }

    @Override
    public PageInfo<User> queryUserList(QueryUsersForm queryUsersForm) {
        // 使用分页插件
        PageHelper.startPage(queryUsersForm.getPageNum(), queryUsersForm.getPageSize());
        List<User> users = userMapper.queryUserList(queryUsersForm.getUserName());
        PageInfo<User> userPageInfo = new PageInfo<>(users);
        return userPageInfo;
    }


}
