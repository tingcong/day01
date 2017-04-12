package com.spring.aop.manual_aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 聪 on 2017/4/13.
 */
public class App {

    ApplicationContext ac=new ClassPathXmlApplicationContext("com/spring/aop/manual_aop/bean.xml");

    @Test
    public void testApp() {
        IUserDao userDao= (IUserDao) ac.getBean("userDao");
        userDao.save();
    }
}
