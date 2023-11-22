package com.example.smp_4;
import java.util.UUID;

public class Order {
    private int id;
    private Pizza[] orderList;

    public Order(int id, Pizza[] orderList){
        this.id = id;
        this.orderList = orderList;
    }

    public int getID(){
        return id;
    }

    public Pizza[] getOrderList(){
        return orderList;
    }


}
