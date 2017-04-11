package com.hibernate;

import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import org.hibernate.cfg.Configuration;

/**
 * Created by htc on 2017/4/11.
 */
public class AutoCreateTable_ddl {

    // 自动建表
    @Test
    public void autoCreateTable() throws Exception{
        //创建配置管理类对象
        Configuration configuration=new Configuration();
        //加载主配置文件
        configuration.configure();
        //创建工具类对象
        SchemaExport export=new SchemaExport(configuration);
        //建表
        //第一个参数：是否在控制台打印建表语句
        //第二个参数：是否执行脚本
        export.create(true,true);
    }
}
