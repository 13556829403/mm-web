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
    public User login(Integer id) {
        System.out.println("service调用了");
        return userMapper.login(id);
    }

    @Override
    public User login2(LoginForm loginForm) {
        return userMapper.login2(loginForm);
    }

}
