package com.example.smp_4;

import java.util.ArrayList;

public class Deluxe extends Pizza {
    public void deluxePizza() {
        setToppings(Topping.SAUSAGE);
        setToppings(Topping.PEPPERONI);
        setToppings(Topping.GREEN_PEPPER);
        setToppings(Topping.ONION);
        setToppings(Topping.MUSHROOM);
        Sauce();

    }

    public void size() {
        //Do we need to work on the UI for this?
    }

    public void extraSauce(){

    }
    public void extraCheese(){

    }

    public void Sauce(){
        setSauce(Sauce.TOMATO);
    }

    @Override
    public double price() {
        if (size.equals(Size.SMALL)) {
            return 14.99;
        } else if (size.equals(Size.MEDIUM)) {
            return 16.99;
        } else if (size.equals(Size.LARGE)) {
            return 18.99;
        }
        return 0;
    }
}
