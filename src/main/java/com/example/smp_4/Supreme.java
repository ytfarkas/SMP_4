package com.example.smp_4;

public class Supreme extends Pizza{

    public Supreme(Size size, boolean extraSauce, boolean extraCheese){
        this.size = size;
        this.sauce = Sauce.TOMATO;
        this.extraCheese = extraCheese;
        this.extraSauce = extraSauce;
        toppings.add(Topping.BLACK_OLIVE);
        toppings.add(Topping.ONION);
        toppings.add(Topping.GREEN_PEPPER);
        toppings.add(Topping.PEPPERONI);
        toppings.add(Topping.HAM);
        toppings.add(Topping.SAUSAGE);
        toppings.add(Topping.MUSHROOM);
    }
    @Override
    public double price() {
        double price = 0;
        if (size.equals(Size.SMALL)) {
            price = 15.99;
        } else if (size.equals(Size.MEDIUM)) {
            price = 17.99;
        } else if (size.equals(Size.LARGE)) {
            price = 19.99;
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
