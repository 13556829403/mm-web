package com.admin.web.utils.page;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;

public class PageUtils {

    public static MyPageInfo transition(PageInfo pageInfo){

        // 创建自定义对象
        MyPageInfo myPageInfo = new MyPageInfo();

        // 重新赋值
        myPageInfo.setTotal((int) pageInfo.getTotal());
        myPageInfo.setPageNum(pageInfo.getPageNum());
        myPageInfo.setPageSize(pageInfo.getPageSize());
        myPageInfo.setSize(pageInfo.getSize());
        myPageInfo.setList(pageInfo.getList());

        ObjectMapper objectMapper = new ObjectMapper();
        //返回
        return myPageInfo;
    }
}
