package com.page.service.impl;

import com.page.dao.IEmployeeDao;
import com.page.dao.impl.EmployeeDao;
import com.page.entity.Employee;
import com.page.entity.PageBean;
import com.page.service.IEmployeeService;

/**
 * Created by 聪 on 2017/4/10.
 */
public class EmployeeService implements IEmployeeService{

    // 创建Dao实例
    private IEmployeeDao employeeDao = new EmployeeDao();

    @Override
    public void getAll(PageBean<Employee> pb) {
        try {
            employeeDao.getAll(pb);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

