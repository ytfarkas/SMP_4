package com.example.smp_4;

import java.util.ArrayList;

public class StoreOrders {
    private ArrayList<Order> storeOrderList;
    private static int nextOrderNumber;

    public StoreOrders(){
        storeOrderList = new ArrayList<Order>();
        nextOrderNumber = 1;
    }

    public void addOrder(Order order){
        storeOrderList.add(order);
        nextOrderNumber++;
    }

    public int getCurrentOrderNumber(){
        return  nextOrderNumber;
    }
    public ArrayList<Order> getStoreOrderList() {
        return storeOrderList;
    }
}
