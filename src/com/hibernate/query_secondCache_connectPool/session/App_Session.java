package com.hibernate.query_secondCache_connectPool.session;

import com.hibernate.query_secondCache_connectPool.second_cache.Dept;
import com.hibernate.query_secondCache_connectPool.second_cache.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**
 * Created by htc on 2017/4/13.
 */
public class App_Session {
    private static SessionFactory sf;
    static {
        sf = new Configuration()
                .configure()
                .addClass(Dept.class)
                .addClass(Employee.class)   // 测试时候使用
                .buildSessionFactory();
    }

    @Test
    public void testSession() throws Exception{
        //openSession:  创建Session, 每次都会创建一个新的session
        Session session=sf.openSession();
        Session session1=sf.openSession();
        System.out.println(session==session1);
        session.close();
        session1.close();


        //getCurrentSession 创建或者获取session
        // 线程的方式创建session
        // 一定要配置：<property name="hibernate.current_session_context_class">thread</property>
        Session session2=sf.getCurrentSession();//创建session,绑定到线程
        Session session3=sf.getCurrentSession();//从当前访问线程获取session
        System.out.println(session2==session3);

        //关闭 【以线程方式创建的session，可以不用关闭；线程结束session自动关闭】
        //session3.close();
        //session4.close(); 报错，因为同一个session已经关闭了！
    }
}
