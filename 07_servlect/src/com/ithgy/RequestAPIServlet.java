package com.ithgy;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class RequestAPIServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求体的字符集为UTF-8，从而解决post中文乱码的问题
        //在获取请求调用之前才有效
        req.setCharacterEncoding("UTF-8");
        System.out.println("URI:"+req.getRequestURI());
        System.out.println("URL:"+req.getRequestURL());
        System.out.println("客户端IP地址:"+req.getRemoteHost());
        System.out.println("获取请求头User+Agent:"+req.getHeader("user-Agent"));
        System.out.println("请求的方式"+req.getMethod());
        String username = req.getParameter("username");
        String pass=req.getParameter("password");
        String[] hobbies = req.getParameterValues("hobby");
        System.out.println("用户名"+username);
        System.out.println("密码"+pass);
        System.out.println("爱好"+ Arrays.asList(hobbies));
    }
}
