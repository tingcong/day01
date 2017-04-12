package com.spring.anno2;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by 聪 on 2017/4/12.
 */
//@Component("userService")  // userService加入ioc容器

//@Component

@Service   // 表示业务逻辑层的组件
public class UserService {

//	@Resource					//  根据类型查找 【在容器中要确保该类型只有一个变量】

    @Resource(name = "userDao")  // 根据名称查找
    private UserDao userDao;  // 去容器中招UserDao类型的变量，找到后就赋值

    public void save() {
        userDao.save();
    }
}
