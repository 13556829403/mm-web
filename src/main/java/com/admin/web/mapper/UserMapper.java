package com.admin.web.mapper;

import com.admin.web.entity.User;
import com.admin.web.form.LoginForm;
import org.apache.ibatis.annotations.Mapper;

/**
 * user数据层操作
 */
@Mapper
public interface UserMapper {
    User login(Integer id);

    User login2(LoginForm loginForm);
}
