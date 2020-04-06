package com.ithgy;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        System.out.println("在柜台一查看的资料"+username);
        //柜台一盖章传递到2去查看
        req.setAttribute("key","柜台1的章");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/Servlet2");
        requestDispatcher.forward(req,resp);
    }
}
