package com.admin.web.form;

/**
 * 登录表单
 */
public class LoginForm {
    private String userName;
    private String pwd;

    @Override
    public String toString() {
        return "LoginForm{" +
                "userName='" + userName + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }

    /* mybatis中直接使用实体类，必须要有无参构造 */
    public LoginForm() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
