package com.hibernate.query_secondCache_connectPool.query;

import org.hibernate.Query;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**
 * Created by htc on 2017/4/13.
 */
public class Page {
    private static SessionFactory sf;
    static {
        sf = new Configuration()
                .configure()
                .addClass(Dept.class)
                .addClass(Employee.class)   // 测试时候使用
                .buildSessionFactory();
    }


    // 分页查询
    @Test
    public void all(){
        Session session=sf.openSession();
        session.beginTransaction();

        Query query=session.createQuery("from Employee");

        //从记录数
        ScrollableResults scrollableResults=query.scroll();     //得到滚动的结果集
        scrollableResults.last();       //滚动到最后一行
        int totalCount=scrollableResults.getRowNumber()+1;      //得到滚到的记录书，即总记录书

        //设置分页
        query.setFirstResult(0);
        query.setMaxResults(3);

        //查询
        System.out.println(query.list());
        System.out.println("总记录数："+totalCount);

        session.getTransaction().commit();
        session.close();
    }
}

