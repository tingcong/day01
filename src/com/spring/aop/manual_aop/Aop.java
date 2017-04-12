package com.spring.aop.manual_aop;

import org.junit.Test;
import org.springframework.stereotype.Component;

/**
 * Created by 聪 on 2017/4/13.
 */
@Component  //加入IOC容器
public class Aop {
    @Test
    // 重复执行的代码
    public void begin(){
        System.out.println("开始事务/异常");
    }
    public void commite(){
        System.out.println("提交事务/关闭");
    }
}
