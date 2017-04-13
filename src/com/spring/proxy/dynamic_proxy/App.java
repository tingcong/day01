package com.spring.proxy.dynamic_proxy;

/**
 * Created by 聪 on 2017/4/13.
 */
public class App {
    public static void main(String[] args) {
        // 目标对象
        IUserDao target = new UserDao();

        // 【原始的类型 class cn.itcast.b_dynamic.UserDao】
        System.out.println(target.getClass());

        // 给目标对象 创建代理对象
        IUserDao proxy= (IUserDao) new ProxyFactory(target).getProxyInstance();
        System.out.println(proxy.getClass());

        //执行方法  【代理对象】
        proxy.save();
    }
}