package com.hibernate.query_secondCache_connectPool.second_cache;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**
 * Created by htc on 2017/4/13.
 */
public class App {
    private static SessionFactory sf;
    static {
        sf = new Configuration()
                .configure()
                .addClass(Dept.class)
                .addClass(Employee.class)   // 测试时候使用
                .buildSessionFactory();
    }


    // 1. 测试二级缓存的使用
    // 没有/有用 二级缓存
    @Test
    public void testCache(){
        Session session=sf.openSession();
        session.beginTransaction();
        //a.查询一次
        Dept dept= (Dept) session.get(Dept.class,1);
        dept.getEmps().size();  //集合
        session.getTransaction().commit();
        session.close();

        System.out.println("- - - - - - - -");

        // 第二个session
        Session session1=sf.openSession();
        session1.beginTransaction();
        // a. 查询一次
        dept= (Dept) session1.get(Dept.class,1);    // 二级缓存配置好； 这里不查询数据库
        dept.getEmps().size();

        session1.getTransaction().commit();
        session1.close();
    }

    @Test
    public void listCache(){
        Session session=sf.openSession();
        session.beginTransaction();

        // HQL查询  【setCacheable  指定从二级缓存找，或者是放入二级缓存】
        Query query=session.createQuery("from Dept").setCacheable(true);
        System.out.println(query.list());
        session.getTransaction().commit();
        session.close();

        Session session1=sf.openSession();
        session1.beginTransaction();
        query=session1.createQuery("from Dept").setCacheable(true);
        System.out.println(query.list()); // 不查询数据库： 需要开启查询缓存
        session1.getTransaction();
        session1.close();
    }
}
