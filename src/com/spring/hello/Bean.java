package com.spring.hello;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 聪 on 2017/4/12.
 */
public class Bean {

    /**
     * 1) 对象创建： 单例/多例
     * 	scope="singleton", 默认值， 即 默认是单例	【service/dao/工具类】
     *  scope="prototype", 多例； 				【Action对象】
     *
     * 2) 对象什么时候创建?
     * 	  scope="prototype"  在用到对象的时候，才创建对象。
     *    scope="singleton"  在启动(容器初始化之前)， 就已经创建了bean，且整个应用只有一个。
     * 3)对象是否延迟创建
     * 	  lazy-init="false"  默认为false,  不延迟创建，即在启动时候就创建对象
     * 	  lazy-init="true"   延迟初始化， 在用到对象的时候才创建对象
     *    （只对单例有效）
     * 4) 创建对象之后，初始化/销毁
     * 	  init-method="init_user"       【对应对象的init_user方法，在对象创建之后执行 】
     *    destroy-method="destroy_user"  【在调用容器对象的destriy方法时候执行，(容器用实现类)】
     *    */
    @Test
    public void getIOC(){
        //得到IOC容器对象
        ApplicationContext ac=new ClassPathXmlApplicationContext("com/spring/hello/applicationContext.xml");
        System.out.println("-------IOC容器创建成功！-------");

        // 从容器中获取bean
        User user_1= (User) ac.getBean("user");
        User user_2= (User) ac.getBean("user");
        System.out.println(user_1+"\n"+user_2);

        //销毁容器对象
    }


}
