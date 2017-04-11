package com.hibernate.compositeKey;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**
 * Created by htc on 2017/4/11.
 */
public class TestUser {
    private static SessionFactory sf;
    static  {
        // 创建sf对象
        sf = new Configuration()
                .configure()
                .addClass(User.class)  //（测试） 会自动加载映射文件：Employee.hbm.xml
                .buildSessionFactory();
    }

    //1. 保存对象
    @Test
    public void testSave() throws Exception {
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        // 对象
        CompositeKeys keys = new CompositeKeys();
        keys.setAddress("广州棠东");
        keys.setUserName("Jack");
        User user = new User();
        user.setAge(20);
        user.setKeys(keys);

        // 保存
        session.save(user);


        tx.commit();
        session.close();
    }

    @Test
    public void testGet() throws Exception{
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        //构建主键再查询
        CompositeKeys keys = new CompositeKeys();
        keys.setAddress("广州棠东");
        keys.setUserName("Jack");

        // 主键查询
        User user= (User) session.get(User.class,keys);
        if(user!=null){
            System.out.println(user.getKeys().getUserName()+" "+user.getKeys().getAddress()+" "+user.getAge());
        }

        tx.commit();
        session.close();
    }
}
