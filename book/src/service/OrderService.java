package service;

import pojo.Cart;
import pojo.Order;
import pojo.OrderItems;

import java.util.List;

public interface OrderService {
    public String createOrder(Cart cart,Integer user_id);
    public List<Order> showAllOrders();
    public void sendOrder(String order_Id);
    public List<OrderItems> queryOrderDetail(String order_Id);
    public List<Order> showMyOrders(Integer user_id);
    public void receiveOrder(String order_id);

}
