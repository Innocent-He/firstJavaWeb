package dao;


import pojo.Order;

import java.util.List;

public interface OrderDao {
    public Integer saveOrder(Order order);
    public List<Order> queryOrders();
    public void changeOrderStatus(String orderId,Integer status);
    public List<Order> queryOrdersByUserId(Integer id);
}
