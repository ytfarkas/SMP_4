package com.example.smp_4;

import java.util.ArrayList;

public class Deluxe extends Pizza {

    public Deluxe(Size size, boolean extraSauce, boolean extraCheese){
        this.size = size;
        this.sauce = Sauce.TOMATO;
        this.extraCheese = extraCheese;
        this.extraSauce = extraSauce;
        toppings.add(Topping.SAUSAGE);
        toppings.add(Topping.MUSHROOM);
        toppings.add(Topping.GREEN_PEPPER);
        toppings.add(Topping.PEPPERONI);
        toppings.add(Topping.ONION);
    }

    @Override
    public double price() {
        double price = 0;

        if (size.equals(Size.SMALL)) {
            price = 14.99;
        } else if (size.equals(Size.MEDIUM)) {
            price = 16.99;
        } else if (size.equals(Size.LARGE)) {
            price = 18.99;
        }
        if(extraCheese){
            price += 1.0;
        }
        if(extraSauce){
            price += 1.0;
        }
        return price;
    }
}
