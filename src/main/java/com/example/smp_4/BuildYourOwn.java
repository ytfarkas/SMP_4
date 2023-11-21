package com.example.smp_4;

import java.util.ArrayList;

public class BuildYourOwn extends Pizza{

    public BuildYourOwn(Sauce sauce, Size size, boolean extraSauce, boolean extraCheese, ArrayList<Topping> toppings){
        this.sauce = sauce;
        this.toppings = toppings;
        this.size = size;
        this.sauce = Sauce.ALFREDO;
        this.extraCheese = extraCheese;
        this.extraSauce = extraSauce;

    }
    @Override
    public double price() {
        double price = 0;
        if (size.equals(Size.SMALL)) {
            price = 8.99;
        } else if (size.equals(Size.MEDIUM)) {
            price = 10.99;
        } else if (size.equals(Size.LARGE)) {
            price = 12.99;
        }
        if(extraCheese){
            price += 1.0;
        }
        if(extraSauce){
            price += 1.0;
        }
        for(int i = 0; i < toppings.size(); i++){
            price += 1.0;
        }

        return price;
    }
}
