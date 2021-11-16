package com.admin.web.entity;

import java.util.Date;

public class User {
    private Integer id;
    private String userName;
    private String pwd;
    private Integer state;
    private Date createTime;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", pwd='" + pwd + '\'' +
                ", state=" + state +
                ", createTime=" + createTime +
                '}';
    }

    public User() {
    }

    public User(Integer id, String userName, String pwd, Integer state, Date createTime) {
        this.id = id;
        this.userName = userName;
        this.pwd = pwd;
        this.state = state;
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
