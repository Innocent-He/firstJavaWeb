package service.impl;

import dao.BookDao;
import dao.OrderDao;
import dao.OrderItemsDao;
import dao.impl.BookDaoImpl;
import dao.impl.OrderDaoImpl;
import dao.impl.OrderItemsImpl;
import pojo.*;
import service.OrderService;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class OrderServiceImpl implements OrderService {
    OrderDao dao=new OrderDaoImpl();
    OrderItemsDao itemdao=new OrderItemsImpl();
    BookDao bookDao=new BookDaoImpl();
    @Override
    public String createOrder(Cart cart, Integer user_id) {
        String orderId = String.valueOf(System.currentTimeMillis()) + user_id;
        Order order=new Order(orderId,new Date(),cart.getTotalCountPrice(),0,user_id);
        dao.saveOrder(order);
        for (Map.Entry<Integer, CartItem> entry:cart.getItems().entrySet()){
            CartItem cartItem = entry.getValue();
            OrderItems orderItems=new OrderItems(null,cartItem.getName(),cartItem.getCount(),cartItem.getPrice(),cartItem.getTotalPrice(),orderId);
            itemdao.saveOrderItems(orderItems);
            Book book = bookDao.queryBookById(cartItem.getId());
            book.setSales( book.getSales() + cartItem.getCount() );
            book.setStock( book.getStock() - cartItem.getCount() );
            bookDao.updateBook(book);
        }

        return orderId;
    }

    @Override
    public List<Order> showAllOrders() {
        List<Order> orders = dao.queryOrders();
        return orders;
    }

    @Override
    public void sendOrder(String order_Id) {
        dao.changeOrderStatus(order_Id,1);
    }

    @Override
    public List<OrderItems> queryOrderDetail(String order_Id) {
        return  itemdao.queryOrdersByOrderId(order_Id);
    }

    @Override
    public List<Order> showMyOrders(Integer user_id) {
       return dao.queryOrdersByUserId(user_id);
    }

    @Override
    public void receiveOrder(String order_id) {
        dao.changeOrderStatus(order_id,2);
    }
}
