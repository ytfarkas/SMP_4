package com.example.smp_4;

public class Seafood extends Pizza{
    public Seafood(Size size, boolean extraSauce, boolean extraCheese){
        this.size = size;
        this.sauce = Sauce.ALFREDO;
        this.extraCheese = extraCheese;
        this.extraSauce = extraSauce;
        toppings.add(Topping.SHRIMP);
        toppings.add(Topping.SQUID);
        toppings.add(Topping.CRAB_MEAT);
    }
    @Override
    public double price() {
        double price = 0;
        if (size.equals(Size.SMALL)) {
            price = 17.99;
        } else if (size.equals(Size.MEDIUM)) {
            price = 19.99;
        } else if (size.equals(Size.LARGE)) {
            price = 21.99;
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
