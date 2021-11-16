package com.admin.web.service;

import com.admin.web.entity.User;
import com.admin.web.form.LoginForm;

public interface UserService {
    User login(Integer id);
    User login2(LoginForm loginForm);
}
