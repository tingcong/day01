package com.spring.auto;

import com.spring.property.UserService;

/**
 * Created by 聪 on 2017/4/12.
 */
public class UserAction {
    // Service: springIOC容器注入
    private UserService userService;
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String execute() {
        userService.save();
        return null;
    }
}
