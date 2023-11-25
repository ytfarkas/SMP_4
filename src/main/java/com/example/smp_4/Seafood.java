package com.example.smp_4;

import java.util.ArrayList;

public class Seafood extends Pizza{
    public Seafood(){
        toppings = new ArrayList<Topping>();
        sauce = Sauce.ALFREDO;
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

    @Override
    public String toString(){

        String sea = "[Seafood] Shrimp Squid Crab Meats "  +
                size.name() + " " + sauce.name() + " ";;

        if(extraSauce){
            sea = sea + "extra Sauce ";
        }

        if(extraCheese){
            sea = sea + "extra cheese ";
        }

        sea = sea + (String.format("%,.2f", this.price()));

        return sea;
    }
}
