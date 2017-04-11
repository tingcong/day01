package com.hibernate.compositeKey;

import java.io.Serializable;

/**
 * 复合主键类
 *
 * Created by htc on 2017/4/11.
 */
public class CompositeKeys implements Serializable {
    private String userName;
    private String address;
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

}

