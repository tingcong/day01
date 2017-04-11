package com.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Type;

import static java.lang.annotation.ElementType.*;

/**
 * 自定义注解（描述一个作者）
 * Created by htc on 2017/4/10.
 */

/**
 * @Target({
        TYPE,     类
        FIELD,     字段
        METHOD,  方法
        PARAMETER,   参数
        CONSTRUCTOR, 构造器
        LOCAL_VARIABLE  局部变量
        })

        // 元注解 - 2. 指定注解的声明周期
         @Retention(RetentionPolicy.SOURCE)    注解只在源码级别有效
         @Retention(RetentionPolicy.CLASS)      注解在字节码即别有效  默认值
         @Retention(RetentionPolicy.RUNTIME)   注解在运行时期有效

 */



//元注解   -   1.定义注解的可用范围
@Target({TYPE,FIELD,PARAMETER,CONSTRUCTOR,LOCAL_VARIABLE})
//@Target({METHOD,FIELD,TYPE})   指定只上用；

//元注解   -   2.指定注解的声明周期
@Retention(RetentionPolicy.RUNTIME)     //字节码级别有效
public @interface Author {
    String authorName() default "Jet";
    int age() default 30;
    String remark();
}
