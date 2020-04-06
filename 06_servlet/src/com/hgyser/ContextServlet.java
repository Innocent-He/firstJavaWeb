package com.hgyser;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ContextServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        1、获取web.xml中配置的上下文参数context-param
        2、获取当前的工程路径，格式/工程路径
        3、获取工程部署后再服务器硬盘上的绝对路径
        4、ServelrtContext存在于整个web工程，且只有一个实例对象
         */

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletConfig().getServletContext();
        String username = context.getInitParameter("username");
        System.out.println(username);
        System.out.println(context.getContextPath());
        System.out.println(context.getRealPath("/"));
        context.setAttribute("key1","value1");
    }
}
