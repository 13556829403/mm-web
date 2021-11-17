package com.admin.web.service;

import com.admin.web.entity.User;
import com.admin.web.form.LoginForm;
import com.admin.web.form.QueryUsersForm;
import com.github.pagehelper.PageInfo;

public interface UserService {
    String login(LoginForm loginForm);

    PageInfo<User> queryUserList(QueryUsersForm queryUsersForm);
}
