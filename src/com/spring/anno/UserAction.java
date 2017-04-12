package com.spring.anno;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by 聪 on 2017/4/12.
 */
@Component("userAction")
public class UserAction {
    @Resource(name = "userService")
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    public String execute() {
        userService.save();
        return null;
    }
}
