package com.spring.proxy.cglib_proxy;

/**
 * Created by 聪 on 2017/4/13.
 */
public class App {
    public static void main(String[] args) {
        //目标对象
        UserDao target=new UserDao();
        System.out.println(target.getClass());

        //代理对象
        UserDao proxy= (UserDao) new ProxyFactory(target).getProxyInstance();
        System.out.println(proxy.getClass());

        //执行代理对象的方法
        proxy.save();
    }
}
