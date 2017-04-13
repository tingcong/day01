package com.spring.aop.pointcut;

import com.spring.aop.aop_xml.IUserDao;
import com.spring.aop.aop_xml.OrderDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 聪 on 2017/4/13.
 */
public class App {

    ApplicationContext ac =
            new ClassPathXmlApplicationContext("com/spring/aop/aop_xml/bean.xml");

    // 目标对象有实现接口，spring会自动选择“JDK代理”
    @Test
    public void testApp() {
        com.spring.aop.aop_xml.IUserDao userDao = (IUserDao) ac.getBean("userDao");
        System.out.println(userDao.getClass());//$Proxy001
        userDao.save();
    }

    // 目标对象没有实现接口， spring会用“cglib代理”
    @Test
    public void testCglib() {
        OrderDao orderDao = (OrderDao) ac.getBean("orderDao");
        System.out.println(orderDao.getClass());
        orderDao.save();
    }
}
