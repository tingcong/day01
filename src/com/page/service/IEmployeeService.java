package com.page.service;

import com.page.entity.Employee;
import com.page.entity.PageBean;

/**
 * 业务逻辑层接口设计
 * Created by 聪 on 2017/4/10.
 */
public interface IEmployeeService {

    /**
     * 分页查询数据
     */
    public void getAll(PageBean<Employee> pb);
}
