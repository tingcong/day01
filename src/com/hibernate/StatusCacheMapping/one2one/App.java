package com.hibernate.StatusCacheMapping.one2one;

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
                .addClass(IdCard.class)
                .addClass(User.class)   // 测试时候使用
                .buildSessionFactory();
    }

    @Test
    public void getSave() {

        Session session = sf.openSession();
        session.beginTransaction();

        // 用户
        User user = new User();
        user.setUserName("Jack");
        // 身份证
        IdCard idCard = new IdCard();
        idCard.setCardNum("441202XXX");
        idCard.setPlace("广州XXX");
        // 关系
        idCard.setUser(user);

        // ----保存----
        session.save(idCard);

        session.getTransaction().commit();
        session.close();

    }
}
