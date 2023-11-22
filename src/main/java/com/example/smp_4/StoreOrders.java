package com.example.smp_4;

import java.util.ArrayList;

public class StoreOrders {
    private ArrayList<Order> storeOrderList;
    private static int nextOrderNumber;

    public StoreOrders(){
        storeOrderList = new ArrayList<Order>();
        nextOrderNumber = 0;
    }

    public void addOrder(Order order){
        storeOrderList.add(order);
    }
    public int getNextOrderNumber(){
        return nextOrderNumber;
    }
    public ArrayList<Order> getStoreOrderList() {
        return storeOrderList;
    }
}
