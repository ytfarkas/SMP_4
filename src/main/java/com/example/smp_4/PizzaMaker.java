package com.example.smp_4;

import java.util.ArrayList;

public class PizzaMaker {
    public static Pizza createPizza(String pizzaType) {
        Pizza pizza;
        if(pizzaType.equals("Meatzza")){
            pizza = new Meatzza();
        }
        else if(pizzaType.equals("Pepperoni")) {
            pizza = new Pepperoni();
        }
        else if(pizzaType.equals("Seafood")){
            pizza = new Seafood();
        }
        else if(pizzaType.equals("Supreme")){
            pizza = new Supreme();
        }
        else if(pizzaType.equals("Deluxe")){
            pizza = new Deluxe();
        }
        else{  //build your own
            pizza = new BuildYourOwn();
        }
        return pizza;
        //not sure if there needs to be a case for if the string is incorrect
    }

}


