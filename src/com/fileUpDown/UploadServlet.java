package com.fileUpDown;

import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 聪 on 2017/4/10.
 */
public class UploadServlet  extends HttpServlet{
    //upload目录，保存上传的资源

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /*********文件上传组件： 处理文件上传************/


        try {
            // 1. 文件上传工厂
            FileItemFactory factory=new DiskFileItemFactory();
            // 2. 创建文件上传核心工具类
            ServletFileUpload upload=new ServletFileUpload(factory);

            // 一、设置单个文件允许的最大的大小： 30M
            upload.setFileSizeMax(30*13024*1024);

            // 二、设置文件上传表单允许的总大小: 80M
            upload.setSizeMax(80*1024*1024);

            // 三、 设置上传表单文件名的编码
            // 相当于：request.setCharacterEncoding("UTF-8");
            upload.setHeaderEncoding("UTF-8");

            // 3. 判断： 当前表单是否为文件上传表单
            if(upload.isMultipartContent(req)){

            }
                // 4. 把请求数据转换为一个个FileItem对象，再用集合封装

            // 遍历： 得到每一个上传的数据

            // 判断：普通文本数据
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
