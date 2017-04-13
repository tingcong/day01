package com.hibernate.StatusCacheMapping.extends_1;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.util.List;

/**
 * Created by htc on 2017/4/13.
 */
public class App {
    private static SessionFactory sf;
    static {
        sf = new Configuration()
                .configure()
                .addClass(Cat.class)
                .buildSessionFactory();
    }

    @Test
    public void getSave() {

        Session session = sf.openSession();
        session.beginTransaction();

        // 保存
//		Cat cat = new Cat();
//		cat.setName("大花猫");
//		cat.setCatchMouse("抓小老鼠");
//		session.save(cat);

        // 获取时候注意：当写hql查询的使用，通过父类查询必须写上类的全名
        Query q = session.createQuery("from com.hibernate.StatusCacheMapping.extends_1.Animal");
        List<Animal> list = q.list();
        System.out.println(list);

        session.getTransaction().commit();
        session.close();

    }
}
