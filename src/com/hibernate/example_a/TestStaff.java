package com.hibernate.example_a;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.util.Date;

/**
 * Created by htc on 2017/4/11.
 */
public class TestStaff {
    private static SessionFactory sf;
    static {
        sf=new Configuration()
                .configure()
                .addClass(Staff.class)  //（测试） 会自动加载映射文件：Employee.hbm.xml
                .buildSessionFactory();
    }

    @Test
    public void save() throws Exception{
        Staff staff=new Staff();
        staff.setEmpName("郭夏琴");
        staff.setWorkDate(new Date());
        staff.setDesc("秒睡");

        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();
        session.save(staff);
        tx.commit();
        session.close();
    }
}
