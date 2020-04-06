package test;

import dao.impl.OrderItemsImpl;
import org.junit.Test;
import pojo.OrderItems;

import java.util.List;

import static org.junit.Assert.*;

public class OrderItemsImplTest {
    OrderItemsImpl dao=new OrderItemsImpl();
    @Test
    public void saveOrderItems() {
        dao.saveOrderItems(new OrderItems(null, "养猪大全", 13, 11.2, 131.2, "123"));
    }

    @Test
    public void queryOrdersByOrderId() {
        List<OrderItems> orderItems = dao.queryOrdersByOrderId("15840961046731");
        System.out.println(orderItems);
    }
}