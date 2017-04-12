package com.spring.aop.manual_aop_2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 聪 on 2017/4/13.
 */
public class App {
    ApplicationContext ac=new ClassPathXmlApplicationContext("com/spring/aop/manual_aop_2/bean.xml");

    @Test
    public void TestApp(){
        //疑问：实现类能强转成对应的接口类型吗？？？
        IUserDao  userDao= (IUserDao) ac.getBean("userDao_proxy");
        System.out.println( ac.getBean("userDao_proxy"));
        userDao.save();
    }
}
