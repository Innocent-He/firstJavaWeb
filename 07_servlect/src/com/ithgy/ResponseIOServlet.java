package com.ithgy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseIOServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //resp.setCharacterEncoding("UTF-8");
        //resp.setHeader("Content-Type","text/html;charset=UTF-8");
        //同时使用服务器和浏览器都使用UTF-8，此方法一定要在获取流，对象之前调用才有效
        resp.setContentType("text/html;charset=UTF-8");
        System.out.println(resp.getCharacterEncoding());
        PrintWriter writer = resp.getWriter();
        writer.write("wohenshuai帅");

    }
}
