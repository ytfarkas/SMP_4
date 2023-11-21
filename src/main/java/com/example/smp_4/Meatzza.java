package com.example.smp_4;

public class Meatzza extends Pizza{
    public Meatzza(Size size, boolean extraSauce, boolean extraCheese){
        this.size = size;
        this.sauce = Sauce.TOMATO;
        this.extraCheese = extraCheese;
        this.extraSauce = extraSauce;
        toppings.add(Topping.PEPPERONI);
        toppings.add(Topping.HAM);
        toppings.add(Topping.BEEF);
        toppings.add(Topping.SAUSAGE);
    }
    @Override
    public double price() {
        double price = 0;
        if (size.equals(Size.SMALL)) {
            price = 16.99;
        } else if (size.equals(Size.MEDIUM)) {
            price = 18.99;
        } else if (size.equals(Size.LARGE)) {
            price = 20.99;
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
