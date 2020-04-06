package test;

import dao.OrderDao;
import dao.impl.OrderDaoImpl;
import org.junit.Test;
import pojo.Order;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class OrderDaoImplTest {
    OrderDao orderDao=new OrderDaoImpl();
    @Test
    public void saveOrder() {

        Integer integer = orderDao.saveOrder(new Order("123", new Date(), 13.0, 0, 1));

    }

    @Test
    public void queryOrders() {
        List<Order> orders = orderDao.queryOrders();
        System.out.println(orders);
    }

    @Test
    public void changeOrderStatus() {
        orderDao.changeOrderStatus("0",2);
        System.out.println(orderDao.queryOrders());
    }

    @Test
    public void queryOrdersByUserId() {
        List<Order> order = orderDao.queryOrdersByUserId(1);
        System.out.println(order);
    }
}