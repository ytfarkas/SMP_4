package com.example.smp_4;

import java.util.ArrayList;

public abstract class Pizza {
    protected ArrayList<Topping> toppings; //Topping is a enum class
    protected Size size; //Size is a enum class
    protected Sauce sauce; //Sauce is a enum class
    protected boolean extraSauce;
    protected boolean extraCheese;
    public abstract double price(); //polymorphism

    public void setToppingsList(){
        toppings = new ArrayList<>();
    }
    public void setSize(Size pizzaSize){
        size = pizzaSize;
    }

    public void setSauce(Sauce pizzaSauce){
        sauce = pizzaSauce;
    }

    public void setExtraSauce(Boolean bool){
        extraSauce = bool;
    }
    public void setExtraCheese(Boolean bool){
        extraCheese = bool;
    }

    public void setToppings(Topping topping){
        toppings.add(topping);
    }

}