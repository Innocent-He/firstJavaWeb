package test;

import org.junit.Test;
import pojo.Cart;
import pojo.CartItem;

import static org.junit.Assert.*;

public class CartTest {
    Cart cart=new Cart();
    @Test
    public void addItem() {

        cart.addItem(new CartItem(3,"魏丹怡",3,12,36));
        cart.addItem(new CartItem(1,"魏丹怡",3,12,36));
        cart.addItem(new CartItem(2,"魏丹怡",3,12,36));
        System.out.println(cart);
    }

    @Test
    public void deleteItem() {
        cart.addItem(new CartItem(3,"魏丹怡",3,12,36));
        cart.addItem(new CartItem(1,"魏丹怡",3,12,36));
        cart.addItem(new CartItem(2,"魏丹怡",3,12,36));
        cart.deleteItem(3);
        System.out.println(cart);
    }

    @Test
    public void clear() {
        cart.addItem(new CartItem(1,"魏丹怡",3,12,36));
        cart.addItem(new CartItem(2,"魏丹怡",3,12,36));
        cart.clear();
        System.out.println(cart);
    }

    @Test
    public void update() {

        cart.addItem(new CartItem(3,"魏丹怡",3,12,36));
        cart.update(3,13);
        System.out.println(cart);
    }
}