package com.example.smp_4;

public class Pepperoni extends Pizza{

    public Pepperoni(){
        this.sauce = Sauce.TOMATO;
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

    @Override
    public String toString(){

        String str = "[Pepperoni] Pepperoni " +
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
