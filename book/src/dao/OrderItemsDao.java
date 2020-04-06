package dao;

import pojo.OrderItems;

import java.util.List;

public interface OrderItemsDao {
    public void saveOrderItems(OrderItems orderItems);
    public List<OrderItems> queryOrdersByOrderId(String id);

}
