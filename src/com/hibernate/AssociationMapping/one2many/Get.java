package com.hibernate.AssociationMapping.one2many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**
 * Created by htc on 2017/4/11.
 */
public class Get {

    private static SessionFactory sf;
    static {
        sf = new Configuration()
                .configure()
                .addClass(Dept.class)       // 测试时候使用
                .addClass(Employee.class)   // 测试时候使用
                .buildSessionFactory();
    }

    @Test
    public void get() {

        Session session = sf.openSession();
        session.beginTransaction();

        // 通过部门方，获取另外一方
		Dept dept = (Dept) session.get(Dept.class, 1);
		System.out.println(dept.getDeptName());
		System.out.println(dept.getEmps());// 懒加载

        // 通过员工房，获取另外一方
//        Employee emp = (Employee) session.get(Employee.class, 1);
//        System.out.println(emp.getEmpName());
//        System.out.println(emp.getDept().getDeptName());

        session.getTransaction().commit();
        session.close();
    }
}