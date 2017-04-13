package com.hibernate.StatusCacheMapping.component;

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
                .addClass(Car.class)
                .buildSessionFactory();
    }

    @Test
    public void getSave() {

        Session session = sf.openSession();
        session.beginTransaction();

        // 轮子
        Wheel wheel = new Wheel();
        wheel.setSize(38);
        wheel.setCount(4);
        // 汽车
        Car car = new Car();
        car.setName("BMW");
        car.setWheel(wheel);

        // 保存
        session.save(car);

        session.getTransaction().commit();
        session.close();

    }

}
