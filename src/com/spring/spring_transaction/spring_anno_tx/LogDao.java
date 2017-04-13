package com.spring.spring_transaction.spring_anno_tx;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by 聪 on 2017/4/13.
 */


// 测试： 日志传播行为
@Repository
public class LogDao {
    @Resource
    private JdbcTemplate jdbcTemplate;

    // 始终开启事务
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void insertLog() {
        jdbcTemplate.update("insert into log_ values('在保存Dept..')");
    }
}
