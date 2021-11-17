package com.admin.web.mapper;

import com.admin.web.entity.User;
import com.admin.web.form.LoginForm;
import com.admin.web.form.QueryUsersForm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Queue;

/**
 * user数据层操作
 */
@Mapper
public interface UserMapper {
    /**
     * 登录
     * @param loginForm
     * @return
     */
    User login(LoginForm loginForm);

    /**
     * 查询用户列表
     * @param userName
     * @return
     */
    List<User> queryUserList(String userName);
}
