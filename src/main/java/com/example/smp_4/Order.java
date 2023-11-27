package com.example.smp_4;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.UUID;

public class Order {
    private int id;
    private ArrayList<Pizza> orderList;

    public Order(int id, ArrayList<Pizza> orderList){
        this.id = id;
        this.orderList = orderList;
    }
    public int getID(){
        return id;
    }

    public ArrayList<Pizza> getOrderList(){
        return orderList;
    }

    public void removePizza(int index){
        orderList.remove(index);
    }

    public void addToOrder(Pizza pizza){
        orderList.add(pizza);
    }

    public double getTotalPrice(){
        double total = 0;

        for(Pizza pizza : this.orderList){
            total += pizza.price();
        }
        total += total * 0.06625;
        return total;
    }

    public double getSubtotal(){
        double total = 0;

        for(Pizza pizza : this.orderList){
            total += pizza.price();
        }
        return total;
    }


}
