package web;

import pojo.Cart;
import pojo.Order;
import pojo.OrderItems;
import pojo.User;
import service.OrderService;
import service.impl.OrderServiceImpl;
import utils.JdbcUtils;
import utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class OrderServlet extends BaseServlet {
        OrderService service= new OrderServiceImpl();

    protected void submit(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Cart cart =(Cart) req.getSession().getAttribute("cart");
        User user =(User) req.getSession().getAttribute("user");
        String orderId = service.createOrder(cart, user.getId());
        req.setAttribute("orderId",orderId);
        req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req,resp);
    }
    protected void showMyOrder(HttpServletRequest req,HttpServletResponse resp)throws IOException,ServletException{
        User user =(User) req.getSession().getAttribute("user");
        List<Order> orders = service.showMyOrders(user.getId());
        req.getSession().setAttribute("orders",orders);
        req.getRequestDispatcher("/pages/order/order.jsp").forward(req,resp);
    }

    protected void findDetail(HttpServletRequest req,HttpServletResponse resp)throws IOException,ServletException{
        List<OrderItems> orderItems = service.queryOrderDetail(req.getParameter("id"));
        req.getSession().setAttribute("orderItems",orderItems);
        req.getRequestDispatcher("/pages/order/orderDetail.jsp").forward(req,resp);
    }
    protected void showAllOrder(HttpServletRequest req,HttpServletResponse resp)throws IOException,ServletException{
        List<Order> allOrders = service.showAllOrders();
        req.getSession().setAttribute("allOrders",allOrders);
        req.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(req,resp);
    }
    protected void sendOrder(HttpServletRequest req,HttpServletResponse resp)throws IOException,ServletException{

        String order_id = req.getParameter("id");
        service.sendOrder(order_id);
        resp.sendRedirect(req.getHeader("Referer"));
    }
    protected void receiveOrder(HttpServletRequest req,HttpServletResponse resp)throws IOException,ServletException{
        String order_id = req.getParameter("id");
        service.receiveOrder(order_id);
        resp.sendRedirect(req.getHeader("Referer"));
    }
}
