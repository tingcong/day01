package com.spring.create_obj;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 聪 on 2017/4/12.
 */
public class App {

    @Test
    public void testIOC() throws  Exception{
        // 创建IOC容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("com/spring/create_obj/bean.xml");
        // 获取容器中的对象
        User user_1 = (User) ac.getBean("user_1");
        System.out.println(user_1);

        User user_2 = (User) ac.getBean("user_2");
        System.out.println(user_2);

        User user_3 = (User) ac.getBean("user_3");
        System.out.println(user_3);

        User user_4 = (User) ac.getBean("user_4");
        System.out.println(user_4);

        User user_5 = (User) ac.getBean("user_5");
        System.out.println(user_5);
    }
}
