package com.spring.anno2;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created by 聪 on 2017/4/12.
 */
//@Component("userAction")  // 加入IOC容器

//@Component

@Controller  // 控制层的组件
public class UserAction {

    @Resource
    private UserService userService;

    public String execute() {
        userService.save();
        return null;
    }
}
