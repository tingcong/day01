package com.spring.spring_transaction.spring_anno_tx;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 *  dao实现，使用Spring对jdbc支持功能
 *
 * Created by 聪 on 2017/4/13.
 */
@Repository
public class DeptDao {

    @Resource
    private JdbcTemplate jdbcTemplate;

    public void save(Dept dept){
        String sql = "insert into t_dept (deptName) values(?)";
        jdbcTemplate.update(sql,dept.getDeptName());
    }
}
