package com.spring.create_obj;

/**
 * Created by 聪 on 2017/4/12.
 */
// 工厂，创建对象
public class ObjectFactory {

    // 实例方法创建对象
    public User getInstance() {
        return new User(100,"工厂：调用实例方法");
    }

    // 静态方法创建对象
    public static User getStaticInstance() {
        return new User(101,"工厂：调用静态方法");
    }
}

