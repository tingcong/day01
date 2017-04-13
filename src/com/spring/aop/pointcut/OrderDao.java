package com.spring.aop.pointcut;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 目标对象
 * Created by 聪 on 2017/4/13.
 */
@Component  //加入容器
@Scope("prototype")
public class OrderDao {
    public void save() {
        System.out.println("-----核心业务：保存！！！------");
    }
}
