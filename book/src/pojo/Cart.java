package pojo;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
    HashMap<Integer,CartItem> items=new LinkedHashMap<>();

    public Cart(HashMap<Integer, CartItem> items) {
        this.items = items;
    }

    public HashMap<Integer, CartItem> getItems() {
        return items;
    }

    public Cart() {
    }

    public void setItems(HashMap<Integer, CartItem> items) {
        this.items = items;
    }

    public void addItem(CartItem cartItem){
        CartItem Item = items.get(cartItem.getId());
        if (Item==null){
            items.put(cartItem.getId(),cartItem);
        }else {
            Item.setCount(Item.getCount()+1);
            Item.setTotalPrice(Item.getCount()*Item.getPrice());
        }
    }
    public void deleteItem(int id){
        items.remove(id);
    }
    public void clear(){
        items.clear();
    }
    public void update(int id,int count){
        CartItem cartItem = items.get(id);
        if (cartItem!=null){
            items.get(id).setCount(count);
            items.get(id).setTotalPrice(cartItem.getPrice()*cartItem.getCount());
        }
    }
    public int getTotalCount(){
        int totalCount=0;
        for (Map.Entry<Integer,CartItem> entry : items.entrySet()){
            totalCount+=entry.getValue().getCount();
        }
        return totalCount;
    }

    public Double getTotalCountPrice(){
        Double totalCountPrice=0.0;
        for (Map.Entry<Integer,CartItem> entry : items.entrySet()){
            totalCountPrice+=entry.getValue().getTotalPrice();
        }
        return totalCountPrice;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "items=" + items +
                ",totalPrice="+getTotalCountPrice()+
                ",totalcount="+getTotalCount()+
                '}';
    }
}
