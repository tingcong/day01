package com.hibernate.StatusCacheMapping.extends_2;

import com.hibernate.StatusCacheMapping.extends_1.Animal;

/**
 * Created by htc on 2017/4/13.
 */
public class Cat extends Animal {

    // 抓老鼠
    private String catchMouse;

    public String getCatchMouse() {
        return catchMouse;
    }

    public void setCatchMouse(String catchMouse) {
        this.catchMouse = catchMouse;
    }

}
