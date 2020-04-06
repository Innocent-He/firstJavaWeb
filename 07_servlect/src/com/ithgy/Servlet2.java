package com.ithgy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        System.out.println("在柜台而查看材料"+username);

        //查看柜台一是否盖章

        Object key = req.getAttribute("key");
        System.out.println("查看章"+key);

        System.out.println("处理自己的业务");
    }
}
