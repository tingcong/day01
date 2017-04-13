package com.spring.aop.aop_xml;

import com.spring.aop.manual_aop.IUserDao;
import org.springframework.stereotype.Component;

/**
 * 目标对象
 *
 * Created by 聪 on 2017/4/13.
 */
@Component  //加入IOC容器
public class UserDao implements IUserDao {

    @Override
    public void save() {
        System.out.println("-----核心业务：保存！！！------");
    }
}
