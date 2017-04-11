package com.hibernate.compositeKey;

/**
 * Created by htc on 2017/4/11.
 */
public class User {

    // 联合(复合)主键：名字跟地址，不会重复
    private CompositeKeys keys;
    private int age;

    public CompositeKeys getKeys() {
        return keys;
    }
    public void setKeys(CompositeKeys keys) {
        this.keys = keys;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}

