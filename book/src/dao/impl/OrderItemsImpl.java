package dao.impl;

import dao.OrderItemsDao;
import pojo.OrderItems;

import java.util.List;

public class OrderItemsImpl extends BaseDao implements OrderItemsDao {
    @Override
    public void saveOrderItems(OrderItems orderItems) {
        String sql="insert into t_order_item(name,count,price,total_price,order_id)values(?,?,?,?,?)";
        update(sql,orderItems.getName(),orderItems.getCount(),orderItems.getPrice(),orderItems.getTotal_price(),orderItems.getOrder_id());
    }

    @Override
    public List<OrderItems> queryOrdersByOrderId(String id) {
        String sql="select * from t_order_item where order_id=?";
        return queryForList(OrderItems.class,sql,id);
    }
}
