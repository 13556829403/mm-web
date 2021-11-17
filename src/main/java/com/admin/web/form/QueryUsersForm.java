package com.admin.web.form;

/**
 * 用户查询参数
 */
public class QueryUsersForm {
    private String userName;
    private int pageNum;
    private int pageSize;

    @Override
    public String toString() {
        return "QueryUsersForm{" +
                "userName='" + userName + '\'' +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
