package com.spring.aop.manual_aop;

import org.junit.Test;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 目标对象
 *
 * Created by 聪 on 2017/4/13.
 */
@Component  //容器
public class UserDao implements IUserDao{

    //重复执行代码形成的类
    @Resource
    private Aop aop;

    @Test
    @Override
    public void save() {
        aop.begin();
        System.out.println("-----核心业务：保存！！！------");
        aop.commite();
    }
}
