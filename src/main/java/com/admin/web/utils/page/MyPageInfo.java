package com.admin.web.utils.page;

import java.io.Serializable;

public class MyPageInfo implements Serializable {
    private static final long serialVersionUID = 3604972003323899999L;

    // 查询总数
    private int total;

    // 查询开始页面
    private int pageNum;

    // 查询数量
    private int pageSize;

    // 当前页数量
    private int size;

    // 数据主体
    private Object list;

    @Override
    public String toString() {
        return "MyPageInfo{" +
                "total=" + total +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", size=" + size +
                ", list=" + list +
                '}';
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Object getList() {
        return list;
    }

    public void setList(Object list) {
        this.list = list;
    }
}
