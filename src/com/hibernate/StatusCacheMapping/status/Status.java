package com.hibernate.StatusCacheMapping.status;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**
 * Created by htc on 2017/4/11.
 */
public class Status {
    private static SessionFactory sf;
    static {
        sf = new Configuration()
                .configure()
                .addClass(User.class)   // 测试时候使用
                .buildSessionFactory();
    }


    //1. 对象状态的转换
    @Test
    public void testSaveSet() throws Exception {
        Session session = sf.openSession();
        session.beginTransaction();

        // 创建对象						【临时状态】
//		User user = new User();
//		user.setUserName("Jack22222");
        // 保存							【持久化状态】
//		session.save(user);
//		user.setUserName("Jack333333");  // 会反映到数据库

        // 查询
        User user = (User) session.get(User.class, 5);
        user.setUserName("Tomcat");// hibernate会自动与数据库匹配（一级缓存），如果一样就更新数据库

        session.getTransaction().commit();
        session.close();

        user.setUserName("Jack444444444");
        // 打印							【游离状态】
        System.out.println(user.getUserId());
        System.out.println(user.getUserName());
    }
}
