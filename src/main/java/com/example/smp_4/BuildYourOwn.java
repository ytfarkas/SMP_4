package com.example.smp_4;

import java.util.ArrayList;

public class BuildYourOwn extends Pizza{

    public BuildYourOwn(){
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
            if(i > 2) {
                price += 1.49; // first 3 toppings free, add 1.49 for every extra topping
            }
        }
        return price;
    }

    @Override
    public String toString(){

        String tpngs ="";
        for(Topping t : toppings){
            if(t.name().contains("_")){
                tpngs = tpngs + t.name().replace("_", " ") + " ";
            }
            else {
                tpngs = tpngs + t.name() + " ";
            }
        }

        String str = "[BuildYourOwn] " + tpngs +
                size.name() + " " + sauce.name() + " ";

        if(extraSauce){
            str = str + "extra Sauce ";
        }

        if(extraCheese){
            str = str + "extra cheese ";
        }

        str = str + "$" + (String.format("%,.2f", this.price()));

        return str;
    }
}
