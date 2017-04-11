package com.hibernate.StatusCacheMapping.status;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**
 * Created by htc on 2017/4/11.
 */
public class Cache {
    private static SessionFactory sf;
    static {
        sf = new Configuration()
                .configure()
                .addClass(User.class)   // 测试时候使用
                .buildSessionFactory();
    }

    @Test
    public void testCache() throws Exception{
        Session session = sf.openSession();
        session.beginTransaction();
        User user = null;
        user = (User) session.get(User.class, 5);// 先检查缓存中是否有数据，如果有不查询数据库，直接从缓存中获取
        user = (User) session.get(User.class, 5);// 先检查缓存中是否有数据，如果有不查询数据库，直接从缓存中获取

        session.getTransaction().commit();
        session.close();
    }

    @Test
    public void flush() throws Exception {
        Session session = sf.openSession();
        session.beginTransaction();

        User user = null;
        user = (User) session.get(User.class, 5);
        user.setUserName("Jack");
        // 缓存数据与数据库同步
        session.flush();

        user.setUserName("Jack_new");

        session.getTransaction().commit();  // session.flush();
        session.close();
    }


    @Test
    public void clear() throws Exception {
        Session session = sf.openSession();
        session.beginTransaction();

        User user = null;
        // 查询
        user = (User) session.get(User.class, 5);
        // 清空缓存内容
//		session.clear(); // 清空所有
        session.evict(user);// 清除指定

        user = (User) session.get(User.class, 5);


        session.getTransaction().commit();  // session.flush();
        session.close();
    }


    @Test
    public void sessionTest() throws Exception {
        Session session1 = sf.openSession();
        session1.beginTransaction();
        Session session2 = sf.openSession();
        session2.beginTransaction();

        // user放入session1的缓存区
        User user = (User) session1.get(User.class, 2);
        // user放入session2的缓存区
        session2.update(user);

        // 修改对象
        user.setUserName("New Name");  // 2条update

        session1.getTransaction().commit();  // session1.flush();
        session1.close();
        session2.getTransaction().commit();  // session2.flush();
        session2.close();
    }


}
