package com.spring.spring_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Created by 聪 on 2017/4/13.
 */
public class UserDao1 {

    /*
     *  保存方法
     *  需求优化的地方：
     *  	1. 连接管理
     *  	2. jdbc操作重复代码封装
     */
    public void save() {
        try {
            String sql = "insert into t_dept(deptName) values('test');";
            Connection con = null;
            Statement stmt = null;
            Class.forName("com.mysql.jdbc.Driver");
            // 连接对象
            con = DriverManager.getConnection("jdbc:mysql://123.207.44.63:3306/java", "root", "hutingcong");
            // 执行命令对象
            stmt =  con.createStatement();
            // 执行
            stmt.execute(sql);

            // 关闭
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
