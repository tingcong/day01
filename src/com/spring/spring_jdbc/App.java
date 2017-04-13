package com.spring.spring_jdbc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 聪 on 2017/4/13.
 */

public class App {

    // 容器对象
    ApplicationContext ac = new ClassPathXmlApplicationContext("com/spring/spring_jdbc/bean.xml");

    @Test
    public void testApp() throws Exception {
        UserDao ud = (UserDao) ac.getBean("userDao");
//		ud.save();
        System.out.println(ud.findById(1));
        System.out.println(ud.getAll());
    }
}
