package com.hibernate.StatusCacheMapping.entends_3;

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
                .addClass(Animal.class)
                .buildSessionFactory();
    }

    @Test
    public void getSave() {

        Session session = sf.openSession();
        session.beginTransaction();

        // 保存
        Cat cat = new Cat();
        cat.setName("大花猫");
        cat.setCatchMouse("抓小老鼠");

        Monkey m = new Monkey();
        m.setName("猴子");
        m.setEatBanana("吃10个香蕉");

        // 保存
        session.save(cat);
        session.save(m);

        session.getTransaction().commit();
        session.close();

    }
}
