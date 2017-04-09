package com.page.dao;

import com.page.entity.Employee;
import com.page.entity.PageBean;

/**
 * 数据访问层，接口设计
 *
 * Created by 聪 on 2017/4/10.
 */
public interface IEmployeeDao {
    /**
     * 分页查询数据
     */
    public void getAll(PageBean<Employee> pb);

    /**
     * 查询总记录数
     */
    public int getTotalCount();
}
