package web;

import pojo.Book;
import pojo.Page;
import service.BookService;
import service.impl.BookServiceImp;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class ClientBookServlet extends BaseServlet {
    BookService bookservice = new BookServiceImp();

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
         Integer pageNo= WebUtils.parseInt(req.getParameter("pageNo"), 1);

        Page<Book> page = bookservice.pageservice(pageNo);
        page.setUrl("client/bookServlet?action=page");
        req.setAttribute("page", page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }
    protected void pageByPrice(HttpServletRequest req,HttpServletResponse resp)throws IOException,ServletException{
        Integer pageNo=WebUtils.parseInt(req.getParameter("pageNo"),1);
        Integer small =WebUtils.parseInt(req.getParameter("small"),0);
        Integer big =WebUtils.parseInt(req.getParameter("big"),Integer.MAX_VALUE);
        Page<Book> page = bookservice.queryBookByPrice(small, big, pageNo);
        StringBuilder sb=new StringBuilder("client/bookServlet?action=pageByPrice");
        if (req.getParameter("small")!=null){
            sb.append("&min=").append(req.getParameter("small"));
        }
        if (req.getParameter("big")!=null){
            sb.append("&big=").append(req.getParameter("big"));
        }
        page.setUrl(sb.toString());
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }
}
