package com.spring.proxy.cglib_proxy;

/**
 * 目标对象
 *
 * Created by 聪 on 2017/4/13.
 */
public class UserDao  {

    public void save() {
        System.out.println("-----已经保存数据！！！------");
    }

}
