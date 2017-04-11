package com.hibernate.entity;

import com.hibernate.entity.Employees;
import com.page.entity.Employee;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import org.hibernate.cfg.Configuration;
import java.util.Date;
import java.util.List;

/**
 * Created by htc on 2017/4/11.
 */
public class TestQuery {

    private static SessionFactory sf;
    static {
		/*
		//1. 创建配置管理类对象
		Configuration config = new Configuration();
		// 加载配置文件  (默认加载src/hibernate.cfg.xml)
		config.configure();
		//2. 根据加载的配置管理类对象，创建SessionFactory对象
		sf = config.buildSessionFactory();
		*/

        // 创建sf对象
		sf=new Configuration().configure().buildSessionFactory();
    }

    @Test
    public void TestSave() throws Exception{
        Employees employees=new Employees();
        employees.setEmpName("班长");
        employees.setWorkDate(new Date());
        // 获取加载配置文件的管理类对象
        Configuration configuration=new Configuration();
        configuration.configure();       // 默认加载src/hibenrate.cfg.xml文件
        // 创建session的工厂对象
        SessionFactory sessionFactory=configuration.buildSessionFactory();
        // 创建session (代表一个会话，与数据库连接的会话)
        Session session=sessionFactory.openSession();
        // 开启事务
        Transaction transaction=session.beginTransaction();
        //保存-数据库
        session.save(employees);
        // 提交事务
        transaction.commit();
        // 关闭
        session.close();
        sessionFactory.close();
    }

    //1.保存对象
    @Test
    public void save() throws Exception{
        //对象
        Employees employees=new Employees();
        employees.setEmpName("张三123");
        employees.setWorkDate(new Date());

        //根据session的工厂，创建session对象
        Session session=sf.openSession();
        // 开启事务
        Transaction transaction=session.beginTransaction();
        //-----执行操作-----
        session.save(employees);
        // 提交事务/ 关闭
        transaction.commit();
        session.close();
    }

    //更新
    @Test
    public void update() throws Exception{
        // 对象
        Employee emp = new Employee();
//        emp.setEmpId(1000000);
        emp.setEmpName("张三3");

        // 创建session
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        //-------执行操作-------
        // 没有设置主键，执行保存；有设置主键，执行更新操作; 如果设置主键不存在报错！
        //  session.update(emp);
        session.saveOrUpdate(emp);
        tx.commit();
        session.close();
    }

    //HQL查询 【适合有数据库基础的】
    @Test
    public void Query() throws Exception{
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

        //主键查询
        Employees employees= (Employees) session.get(Employees.class,5);
        System.out.println(employees);

        //HQL查询全部
        Query query=session.createQuery("from Employees");
        List<Employees> list=query.list();
        System.out.println(list);

        tx.commit();
        session.close();
    }

    //QBC查询，query by criteria   完全面向对象的查询
    @Test
    public void QBC() throws Exception{
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

        Criteria criteria=session.createCriteria(Employees.class);
        //查询全部  criteria.list()返回的是ArrayList
        List<Employees> list=criteria.list();
        System.out.println(list);

        //条件查询
        criteria.add(Restrictions.eq("empId",1));
        List<Employees> list_l= criteria.list();
        System.out.println(list_l);

        tx.commit();
        session.close();
    }

    //SQL查询
    @Test
    public void SQL() throws Exception{
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();

        // 把每一行记录封装为对象(指定的对象类型)数组，再添加到list集合
        SQLQuery sqlQuery=session.createSQLQuery("SELECT * from employees").addEntity(Employees.class);
        List list=sqlQuery.list();

        System.out.println(list);

        tx.commit();;
        session.close();
    }
}
