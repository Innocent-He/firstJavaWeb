package web;
import com.google.gson.Gson;
import pojo.Book;
import pojo.Cart;
import pojo.CartItem;
import service.BookService;
import service.impl.BookServiceImp;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CartServlet extends BaseServlet {


    private BookService bookService = new BookServiceImp();
    protected void alterCount(HttpServletRequest req,HttpServletResponse resp)throws IOException {
        int count = WebUtils.parseInt(req.getParameter("count"), 0);
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        cart.update(id,count);
        resp.sendRedirect(req.getHeader("Referer"));
    }
    protected void clear(HttpServletRequest req,HttpServletResponse resp)throws  IOException{
        Cart cart =(Cart) req.getSession().getAttribute("cart");
        cart.clear();
        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void delete(HttpServletRequest req,HttpServletResponse resp)throws  IOException{
        Cart cart =(Cart) req.getSession().getAttribute("cart");
        int id = WebUtils.parseInt(req.getParameter("id"), -1);
        cart.deleteItem(id);
        resp.sendRedirect(req.getHeader("Referer"));
    }
    /**
     * 加入购物车
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求的参数 商品编号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        // 调用bookService.queryBookById(id):Book得到图书的信息
        Book book = bookService.queryBookById(id);
        // 把图书信息，转换成为CartItem商品项
        CartItem cartItem = new CartItem(book.getId(),book.getName(),1,book.getPrice(),book.getPrice());
        // 调用Cart.addItem(CartItem);添加商品项
        Cart cart =(Cart) req.getSession().getAttribute("cart");
        if (cart==null){
            cart=new Cart();
            req.getSession().setAttribute("cart",cart);
        }

        cart.addItem(cartItem);
        // 最后一个添加的商品名称
        req.getSession().setAttribute("lastshop",cartItem);
        // 重定向回原来商品所在的地址页面s
        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void ajaxAddItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求的参数 商品编号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        // 调用bookService.queryBookById(id):Book得到图书的信息
        Book book = bookService.queryBookById(id);
        // 把图书信息，转换成为CartItem商品项
        CartItem cartItem = new CartItem(book.getId(),book.getName(),1,book.getPrice(),book.getPrice());
        // 调用Cart.addItem(CartItem);添加商品项
        Cart cart =(Cart) req.getSession().getAttribute("cart");
        if (cart==null){
            cart=new Cart();
            req.getSession().setAttribute("cart",cart);
        }
        cart.addItem(cartItem);
        req.getSession().setAttribute("lastName", cartItem.getName());
        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("count",cart.getTotalCount());
        resultMap.put("lastTime",cartItem.getName());
        Gson gson=new Gson();
        String resultJson = gson.toJson(resultMap);
        resp.getWriter().write(resultJson);
    }
}