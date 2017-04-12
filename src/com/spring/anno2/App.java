package com.spring.anno2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 聪 on 2017/4/12.
 */
public class App {
    // 创建容器对象
    private ApplicationContext ac =
            new ClassPathXmlApplicationContext("cn/itcast/e_anno2/bean.xml");

    @Test
    public void testExecuteAction() {
        // 从容器中获取Action
        UserAction userAction = (UserAction) ac.getBean("userAction");
        userAction.execute();
    }
}
