package com.page.entity;

import java.util.List;

/**
 * 封装分页的参数
 * Created by 聪 on 2017/4/9.
 */
public class PageBean<T> {
    // 当前页, 默认显示第一页
    private int currentPage=1;
    // 每页显示的行数(查询返回的行数), 默认每页显示4 行
    private int pageCount=4;
    // 总记录数
    private int totalCount;
    // 总页数 = 总记录数 / 每页显示的行数  (+ 1)
    private int totalPage;
    // 分页查询到的数据
    private List<T> pageData;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    // 返回总页数
    public int getTotalPage() {
        if(totalCount%pageCount==0){
            totalPage=totalCount%pageCount;
        }else{
            totalPage=totalCount%pageCount+1;
        }
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getPageData() {
        return pageData;
    }

    public void setPageData(List<T> pageData) {
        this.pageData = pageData;
    }
}
