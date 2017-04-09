package com.page.dao.impl;

import com.page.dao.IEmployeeDao;
import com.page.entity.Employee;
import com.page.entity.PageBean;
import com.page.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * 数据访问层实现
 *
 * Created by 聪 on 2017/4/10.
 */
public class EmployeeDao implements IEmployeeDao{

    @Override
    public void getAll(PageBean<Employee> pb) {
        //1. 获取当前页： 计算查询的起始行、返回的行数
        int currentPage=pb.getCurrentPage();
        int index=(currentPage-1)*pb.getPageCount();    // 查询的起始行
        int count=pb.getPageCount();    // 查询返回的行数

        //2. 查询总记录数;  设置到pb对象中
            int totalCount=this.getTotalCount();
            pb.setTotalCount(totalCount);
        /*
		 * 问题： jsp页面，如果当前页为首页，再点击上一页报错！
		 *              如果当前页为末页，再点下一页显示有问题！
		 * 解决：
		 * 	   1. 如果当前页 <= 0;       当前页设置当前页为1;
		 * 	   2. 如果当前页 > 最大页数；  当前页设置为最大页数
		 */
        // 判断
        if(pb.getCurrentPage()<=0){
            pb.setCurrentPage(1);   // 把当前页设置为1,即首页
        }else if(pb.getCurrentPage()>pb.getPageCount()){
            pb.setCurrentPage(pb.getPageCount());   // 把当前页设置为最大页数，即尾页
        }

        //3. 分页查询数据;  把查询到的数据设置到pb对象中
        String sql="select * from employee where limit ?,?";
        try {
            // 得到Queryrunner对象
            QueryRunner qr= JdbcUtils.getQueryRunner();
            // 根据当前页，查询当前页数据(一页数据)
            List<Employee> pageData=qr.query(sql,new BeanListHandler<Employee>(Employee.class),index,count);
            // 设置到pb对象中
            pb.setPageData(pageData);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getTotalCount() {
        String sql="select count(*) from employee";
        //创建QueryRunner对象
        QueryRunner qr=JdbcUtils.getQueryRunner();
        //执行查询，返回结果的第一行，第一列
        try {
            Long count=qr.query(sql,new ScalarHandler<Long>());
            return count.intValue();
        } catch (SQLException e) {
           throw new RuntimeException(e);
        }
    }
}
