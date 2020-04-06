package filter;

import utils.JdbcUtils;

import javax.servlet.*;
import java.io.IOException;

public class AllThredaFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            filterChain.doFilter(servletRequest,servletResponse);
            JdbcUtils.commitAndClose();
        }catch (Exception e){
            JdbcUtils.rollbackAndClose();
            throw new RuntimeException(e);
        }

    }

    @Override
    public void destroy() {

    }
}
