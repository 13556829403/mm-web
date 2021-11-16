package com.admin.web.service.impl;

import com.admin.web.entity.User;
import com.admin.web.form.LoginForm;
import com.admin.web.mapper.UserMapper;
import com.admin.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(LoginForm loginForm) {
        System.out.println(1);
        return userMapper.login(loginForm);
    }

}
