package com.admin.web.form;

/**
 * 登录表单
 */
public class LoginForm {
    private String userName;
    private String pwd;

    public LoginForm() {
    }

    public LoginForm(String userName, String pwd) {
        this.userName = userName;
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "LoginForm{" +
                "userName='" + userName + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
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
