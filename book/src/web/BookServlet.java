package web;

import org.apache.commons.dbutils.handlers.ScalarHandler;
import pojo.Book;
import pojo.Page;
import service.BookService;
import service.impl.BookServiceImp;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BookServlet extends BaseServlet {
    BookService bookservice=new BookServiceImp();
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = bookservice.queryBooks();
        req.setAttribute("books",books);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        bookservice.deleteBookById(Integer.parseInt(id));
       resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page");
    }
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book= WebUtils.CopyParamToBean(req.getParameterMap(),new Book());
        bookservice.addBook(book);
        System.out.println(req.getContextPath());
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page");
    }
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = WebUtils.CopyParamToBean(req.getParameterMap(), new Book());
        System.out.println(book);
        bookservice.updateBook(book);
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page");
    }
    protected void getbook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Book book = bookservice.queryBookById(Integer.parseInt(req.getParameter("id")));
        req.setAttribute("book",book);
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req,resp);
    }
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Integer pageNo=WebUtils.parseInt(req.getParameter("pageNo"),1);

        Page<Book> page = bookservice.pageservice(pageNo);
        page.setUrl("manager/bookServlet?action=page");
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }
}
