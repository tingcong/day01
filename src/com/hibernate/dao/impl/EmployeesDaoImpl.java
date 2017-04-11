package com.hibernate.dao.impl;

import com.hibernate.HibernateUtils;
import com.hibernate.dao.IEmployeesDao;
import com.hibernate.entity.Employees;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

/**
 * Created by htc on 2017/4/11.
 */
public class EmployeesDaoImpl implements IEmployeesDao {
    @Override
    public void save(Employees emp) {
        Session session=null;
        Transaction tx=null;
        try {
            session= HibernateUtils.getSession();
            tx=session.beginTransaction();
            //执行保存操作
            session.save(emp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            tx.commit();
            session.close();
        }
    }

    @Override
    public void update(Employees emp) {
        Session session = null;
        Transaction tx = null;

        try {
            session=HibernateUtils.getSession();
            tx=session.beginTransaction();
            session.update(emp);
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }finally {
            tx.commit();;
            session.close();
        }
    }

    @Override
    public Employees findById(Serializable id) {
        Session session = null;
        Transaction tx = null;

        try {
            session=HibernateUtils.getSession();
            tx=session.beginTransaction();
            //主键查询
            return (Employees) session.get(Employees.class,id);
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }finally {
            tx.commit();
            session.close();
        }
    }

    @Override
    public List<Employees> getAll() {
        Session session = null;
        Transaction tx = null;
        try {
            session=HibernateUtils.getSession();
            tx=session.beginTransaction();
            //HQL查询
            Query query=session.createQuery("from Employees");
            return query.list();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }finally {
            tx.commit();
            session.close();
        }
    }

    @Override
    public List<Employees> getAll(String employeeName) {
        Session session = null;
        Transaction tx = null;
        try {
            session=HibernateUtils.getSession();
            tx=session.beginTransaction();
            Query query=session.createQuery("from Employees where empName=?");
            //主义：参数索引从0 开始
            query.setParameter(0,employeeName);
            //执行查询
            return query.list();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }finally {
            tx.commit();
            session.close();
        }
    }

    @Override
    public List<Employees> getAll(int index, int count) {
        Session session = null;
        Transaction tx = null;

        try {
            session=HibernateUtils.getSession();
            tx=session.beginTransaction();
            Query query=session.createQuery("from Employees");
            //设置分页参数
            query.setFirstResult(index);    //查寻的起始行
            query.setMaxResults(count);     //查询返回的行数

            List<Employees> list=query.list();
            return list;
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }finally {
            tx.commit();
            session.close();
        }

    }

    @Override
    public void delete(Serializable id) {
        Session session = null;
        Transaction tx = null;

        try {
            session=HibernateUtils.getSession();
            tx=session.beginTransaction();
            //先更具id查询对象，在判断删除
            Object obj=session.get(Employees.class,id);
            if(obj!=null){
                session.delete(obj);
            }
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }finally {
            tx.commit();
            session.close();
        }
    }
}
