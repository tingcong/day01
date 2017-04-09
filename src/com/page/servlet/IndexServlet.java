package com.page.servlet;

import com.page.entity.Employee;
import com.page.entity.PageBean;
import com.page.service.IEmployeeService;
import com.page.service.impl.EmployeeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  控制层开发
 * Created by 聪 on 2017/4/10.
 */
@WebServlet("/page/IndexServlet.htm")
public class IndexServlet  extends HttpServlet {

    // 创建Service实例
    private IEmployeeService employeeService = new EmployeeService();
    // 跳转资源
    private String uri;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            //1. 获取“当前页”参数；  (第一次访问当前页为null)
            String currPage=req.getParameter("currentPage");
            //判断
            if(currPage==null || "".equals(currPage.trim())){
                currPage="1";   //第一次访问，设置当前页为1
            }
            //转换
            int currentPage=Integer.parseInt(currPage);

            //2. 创建PageBean对象，设置当前页参数； 传入service方法参数
            PageBean<Employee> pageBean=new PageBean<Employee>();
            pageBean.setCurrentPage(currentPage);

            //3. 调用service
            employeeService.getAll(pageBean);   //dao向pageBean填充数据

            //4. 保存pageBean对象，到request域中
            req.setAttribute("pageBean",pageBean);

            //5. 跳转
            uri="/static/page/list.jsp";
        } catch (Exception e) {
            e.printStackTrace();  // 测试使用
            // 出现错误，跳转到错误页面；给用户友好提示
            uri = "/static/error/error.jsp";
        }

        req.getRequestDispatcher(uri).forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
