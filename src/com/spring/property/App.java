package com.spring.property;

import com.struts.UserAction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 聪 on 2017/4/12.
 */
public class App {
    //创建容器对象
    private ApplicationContext ac=new ClassPathXmlApplicationContext("com/spring/property/bean.xml");

    @Test
    public void testSet(){
        //从容器中获取
        User user= (User) ac.getBean("user");
        System.out.println(user);
    }

    @Test
    public void testExecuteAction() throws Exception {
        //从容器中获取Action
        UserAction userAction= (UserAction) ac.getBean("userAction");
        userAction.execute();
    }
}
