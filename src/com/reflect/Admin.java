package com.reflect;

/**
 * Created by htc on 2017/4/10.
 */
public class Admin {
    // Field
    private int id = 1000;
    private String name = "匿名";

    // Constructor
    public Admin(){
        System.out.println("Admin.Admin()");
    }
    public Admin(String name){
        System.out.println("Admin.Admin()" + name);
    }

    // Method
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
