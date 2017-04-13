package com.spring.spring_transaction.spring_xml_tx;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 聪 on 2017/4/13.
 */
public class App {
    @Test
    public void testApp() throws Exception {
        //容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("com/spring/spring_transaction/spring_xml_tx/bean.xml");

        // 模拟数据
        Dept dept = new Dept();
        dept.setDeptName("测试： 开发部");

        DeptService deptService = (DeptService) ac.getBean("deptService");
        deptService.save(dept);

    }
}
