package com.hibernate.AssociationMapping.collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by htc on 2017/4/11.
 */
public class TestCollection {
    private static SessionFactory sf;
    static {
        sf = new Configuration()
                .configure()
                .addClass(User.class)   // 测试时候使用
                .buildSessionFactory();
    }

    //保存Set
    @Test
    public void saveSet() throws Exception{
        Session session=sf.openSession();
        session.beginTransaction();

        //地址Set
        Set<String> addressSet=new HashSet<String>();
        addressSet.add("江西");
        addressSet.add("深圳");
        //用户对象
        User user=new User();
        user.setUserName("Jack");
        user.setAddress(addressSet);

        //保存
        session.save(user);

        session.beginTransaction().commit();
        session.close();
    }

    //保存List
    @Test
    public void saveList() throws Exception{
        Session session=sf.openSession();
        session.beginTransaction();
        User user=new User();
        user.setUserName("Tom");

        //用户对象  --list
        user.getAddressList().add("广州");
        user.getAddressList().add("深圳");

        //保存
        session.save(user);

        session.getTransaction().commit();
        session.close();
    }

    //保存/Map
    @Test
    public void saveMap() throws Exception{
        Session session=sf.openSession();
        session.beginTransaction();
        User user=new User();
        user.setUserName("Tom");

        //用户对象  --list
        user.getAddressMap().put(Integer.toString(user.getUserId()),"广州");
        user.getAddressMap().put(Integer.toString(user.getUserId()),"深圳");

        //保存
        session.save(user);

        session.getTransaction().commit();
        session.close();
    }

    //获取
    @Test
    public void testGet() throws Exception{
        Session session=sf.openSession();
        session.beginTransaction();

        //获取
        User user= (User) session.get(User.class,3);    //及时加载
        System.out.println(user.getUserId());
        System.out.println(user.getUserName());

        // 当查询用户，同时可以获取用户关联的list集合的数据 (因为有正确映射)
        // 当使用到集合数据的使用，才向数据库发送执行的sql语句  (懒加载)
        System.out.println(user.getAddressList());

        session.beginTransaction().commit();
        session.close();
    }
}
