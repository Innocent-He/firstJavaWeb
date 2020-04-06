package dao.impl;

import dao.OrderDao;
import pojo.Order;

import java.util.List;

public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public Integer saveOrder(Order order) {
        String sql="insert into t_order (order_id,create_time,price,status,user_id) values(?,?,?,?,?)";
         return update(sql,order.getOrder_id(),order.getCreate_time(),order.getPrice(),order.getStatus(),order.getUser_id());
    }

    @Override
    public List<Order> queryOrders() {
        String sql="select * from t_order";
        return queryForList(Order.class,sql);
    }

    @Override
    public void changeOrderStatus(String orderId, Integer status) {
        String sql="update t_order set status=? where order_id=?";
        update(sql,status,orderId);
    }

    @Override
    public List<Order> queryOrdersByUserId(Integer id) {
        String sql="select * from t_order where user_id=?";
        return queryForList(Order.class,sql,id);
    }
}
