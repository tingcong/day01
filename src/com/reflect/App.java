package com.reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射技术
 * Created by htc on 2017/4/10.
 */
public class App {
    // 1. 创建对象
    @Test
    public void testInfo() throws Exception{
        //类全名
        String className="com.reflect.Admin";
        //得到类字节码
        Class<?> clazz=Class.forName(className);
        //创建对象1：默认构造函数简写
        Admin admin= (Admin) clazz.newInstance();

        //创建对象2：通过带参数构造器创建对象
        Constructor<?> constructor=clazz.getDeclaredConstructor(String.class);
        Admin admin1= (Admin) constructor.newInstance("java");

    }

    @Test
    //2. 获取属性名称、值
    public void testField() throws Exception{
        //类全名
        String className="com.reflect.Admin";
        //得到类字节码
        Class<?> clazz=Class.forName(className);
        //对象
        Admin admin= (Admin) clazz.newInstance();

        //获取所有的属性名称
        Field[] fields=clazz.getDeclaredFields();
        //遍历：输出每一个属性名称、值
        for(Field f: fields){
            //设置强制访问
            f.setAccessible(true);
            //名称
            String name=f.getName();
            //值
            Object value=f.get(admin);
            System.out.println(name+": "+value);
        }
    }


    @Test
    //3. 反射获取方法
    public void testMedthod() throws Exception{
        //类全名
        String className="com.reflect.Admin";
        //得到类字节码
        Class<?> clazz=Class.forName(className);
        //对象
        Admin admin= (Admin) clazz.newInstance();
        //获取方法对象 public int getId()
        Method method=clazz.getDeclaredMethod("getId");

        //调用方法
        Object r_value= method.invoke(admin);
        System.out.println(r_value);
    }
}
