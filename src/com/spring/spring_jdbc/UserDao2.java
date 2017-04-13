package com.spring.spring_jdbc;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

/**
 * Created by 聪 on 2017/4/13.
 */
public class UserDao2 {
    // IOC容器注入
    private DataSource dataSource;
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public void save() {
        try {
            String sql = "insert into t_dept(deptName) values('test');";
            Connection con = null;
            Statement stmt = null;
            // 连接对象
            con = dataSource.getConnection();
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
