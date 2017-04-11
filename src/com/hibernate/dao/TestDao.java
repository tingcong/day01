package com.hibernate.dao;

import com.hibernate.dao.impl.EmployeesDaoImpl;
import com.hibernate.entity.Employees;
import org.junit.Test;

/**
 * Created by htc on 2017/4/11.
 */
public class TestDao {
    private IEmployeesDao empDao = new EmployeesDaoImpl();

    @Test
    public void testFindById() {
        System.out.println(empDao.findById(1));
    }

    @Test
    public void testGetAll() {
        System.out.println(empDao.getAll());
    }

    @Test
    public void testGetAllString() {
        System.out.println(empDao.getAll("张三3"));
    }

    @Test
    public void testGetPage() {
        System.out.println(empDao.getAll(4, 2));
    }

    @Test
    public void testSave() {
        empDao.save(new Employees());
    }

    @Test
    public void testUpdate() {
        Employees emp = new Employees();
        emp.setEmpId(5);
        emp.setEmpName("new jack");

        empDao.update(emp);
    }

    @Test
    public void testDelete() {
        empDao.delete(8);
    }

}
