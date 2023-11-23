package com.example.smp_4;

public class Meatzza extends Pizza{
    public Meatzza(){

        this.sauce = Sauce.TOMATO;
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
    @Override
    public String toString(){

        String str = "[Meatzza] Pepperoni Beef Ham Sausage " +
                size.name() + " " + sauce.name() + " ";

        if(extraSauce){
            str = str + "extra Sauce ";
        }

        if(extraCheese){
            str = str + "extra cheese ";
        }

        str = str + "$" + this.price();

        return str;
    }
}
