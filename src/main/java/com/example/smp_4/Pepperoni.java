package com.example.smp_4;

public class Pepperoni extends Pizza{

    public Pepperoni(Size size, boolean extraSauce, boolean extraCheese){
        this.size = size;
        this.sauce = Sauce.TOMATO;
        this.extraCheese = extraCheese;
        this.extraSauce = extraSauce;
        toppings.add(Topping.PEPPERONI);
    }
    @Override
    public double price() {
        double price = 0;

        if (size.equals(Size.SMALL)) {
            price = 10.99;
        } else if (size.equals(Size.MEDIUM)) {
            price = 12.99;
        } else if (size.equals(Size.LARGE)) {
            price = 14.99;
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
