package filter;

import utils.JdbcUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ManagerFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest) servletRequest;
        Object user = req.getSession().getAttribute("user");
        if (user==null){
            System.out.println("还未登陆");
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,servletResponse);
        }else{

                filterChain.doFilter(req, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
