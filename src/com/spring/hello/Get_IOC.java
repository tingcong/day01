package com.spring.hello;


import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * Created by 聪 on 2017/4/11.
 */
public class Get_IOC {

    //通过工厂方式得到IOC容器创建的对象
    @Test
    public void testIOC() throws Exception{
        //手动创建对象
//        User user=new User();

        //现在把对象的创建交给Spring的IOC容器
        Resource resource=new ClassPathResource("com/spring/hello/applicationContext.xml");
        //创建容器对象（Bean的工厂），IOC容器=工厂类+applicationContext.xml
        BeanFactory factory=new XmlBeanFactory(resource);
        User user= (User) factory.getBean("user");

        System.out.println(user);
    }


    //(方便)直接得到IOC容器对象
    @Test
    public void testIOC_Q(){
        //得到IOC容器对象
        ApplicationContext ac=new ClassPathXmlApplicationContext("com/spring/hello/applicationContext.xml");
        //从容器中获取Bean
        User user= (User) ac.getBean("user");
        System.out.println(user);
    }
}
