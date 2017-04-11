package com.spring.hello;

/**
 * Created by 聪 on 2017/4/11.
 */
public class User {
    private int id;
    private String name;

    public User() {
        super();
        System.out.println("--------User对象已创建！-----------");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
