package com.hibernate.dao;

import com.hibernate.entity.Employees;

import java.io.Serializable;
import java.util.List;

/**
 * Created by htc on 2017/4/11.
 */
public interface IEmployeesDao {
    void save(Employees emp);
    void update(Employees emp);
    Employees findById(Serializable id);
    List<Employees> getAll();
    List<Employees> getAll(String employeeName);
    List<Employees> getAll(int index, int count);
    void delete(Serializable id);

}
