package com.example.smp_4;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BuildYourOwnTest {

    @Test
    public void valid1() {
        Pizza pizza = new BuildYourOwn();
        ArrayList<Topping> tpings = new ArrayList<Topping>();
        pizza.size = Size.SMALL;
        tpings.add(Topping.BEEF);
        tpings.add(Topping.ARTICHOKE);
        tpings.add(Topping.SAUSAGE);
        pizza.toppings = tpings;
        pizza.extraSauce = true;
        pizza.extraCheese = true;
        boolean actualOutput = pizza.price() == 10.99;
        assertTrue(actualOutput);

    }

    @Test
    public void valid2() {
        Pizza pizza = new BuildYourOwn();
        ArrayList<Topping> tpings = new ArrayList<Topping>();
        pizza.size = Size.MEDIUM;
        tpings.add(Topping.BEEF);
        tpings.add(Topping.ARTICHOKE);
        tpings.add(Topping.SAUSAGE);
        tpings.add(Topping.CRAB_MEAT);
        tpings.add(Topping.ONION);
        pizza.toppings = tpings;
        pizza.extraSauce = false;
        pizza.extraCheese = false;
        boolean actualOutput = pizza.price() == 13.97;
        assertTrue(actualOutput);

    }

    @Test
    public void valid3() {
        Pizza pizza = new BuildYourOwn();
        ArrayList<Topping> tpings = new ArrayList<Topping>();
        pizza.size = Size.LARGE;
        tpings.add(Topping.PEPPERONI);
        tpings.add(Topping.SAUSAGE);
        tpings.add(Topping.ONION);
        tpings.add(Topping.GREEN_PEPPER);
        tpings.add(Topping.BEYOND_BEEF);
        tpings.add(Topping.ARTICHOKE);
        tpings.add(Topping.MUSHROOM);
        pizza.toppings = tpings;
        pizza.extraSauce = true;
        pizza.extraCheese = true;
        System.out.println(pizza.price());
        boolean actualOutput = pizza.price() == 20.95;
        assertTrue(actualOutput);

    }

    @Test
    public void valid4() {
        Pizza pizza = new BuildYourOwn();
        ArrayList<Topping> tpings = new ArrayList<Topping>();
        pizza.size = Size.MEDIUM;
        tpings.add(Topping.BEEF);
        tpings.add(Topping.ARTICHOKE);
        tpings.add(Topping.SAUSAGE);
        pizza.toppings = tpings;
        pizza.extraSauce = true;
        pizza.extraCheese = true;
        boolean actualOutput = pizza.price() == 12.99;
        assertTrue(actualOutput);

    }

    @Test
    public void valid5() {
        Pizza pizza = new BuildYourOwn();
        ArrayList<Topping> tpings = new ArrayList<Topping>();
        pizza.size = Size.LARGE;
        tpings.add(Topping.BEEF);
        tpings.add(Topping.ARTICHOKE);
        tpings.add(Topping.SAUSAGE);
        tpings.add(Topping.CRAB_MEAT);
        tpings.add(Topping.ONION);
        pizza.toppings = tpings;
        pizza.extraSauce = false;
        pizza.extraCheese = false;
        boolean actualOutput = pizza.price() == 15.97;
        assertTrue(actualOutput);

    }

    @Test
    public void invalid1() {
        Pizza pizza = new BuildYourOwn();
        ArrayList<Topping> tpings = new ArrayList<Topping>();
        pizza.size = Size.LARGE;
        tpings.add(Topping.BEEF);
        tpings.add(Topping.ARTICHOKE);
        tpings.add(Topping.SAUSAGE);
        pizza.toppings = tpings;
        pizza.extraSauce = false;
        pizza.extraCheese = false;
        boolean actualOutput = pizza.price() == 10.99;
        assertFalse(actualOutput);

    }

    @Test
    public void invalid2() {
        Pizza pizza = new BuildYourOwn();
        ArrayList<Topping> tpings = new ArrayList<Topping>();
        pizza.size = Size.SMALL;
        tpings.add(Topping.BEEF);
        tpings.add(Topping.ARTICHOKE);
        tpings.add(Topping.SAUSAGE);
        tpings.add(Topping.CRAB_MEAT);
        tpings.add(Topping.ONION);
        pizza.toppings = tpings;
        pizza.extraSauce = false;
        pizza.extraCheese = false;
        boolean actualOutput = pizza.price() == 13.97;
        assertFalse(actualOutput);

    }

    @Test
    public void invalid3() {
        Pizza pizza = new BuildYourOwn();
        ArrayList<Topping> tpings = new ArrayList<Topping>();
        pizza.size = Size.LARGE;
        tpings.add(Topping.PEPPERONI);
        tpings.add(Topping.SAUSAGE);
        tpings.add(Topping.ONION);
        tpings.add(Topping.GREEN_PEPPER);
        tpings.add(Topping.BEYOND_BEEF);
        tpings.add(Topping.ARTICHOKE);
        tpings.add(Topping.MUSHROOM);
        pizza.toppings = tpings;
        pizza.extraSauce = true;
        pizza.extraCheese = false;
        boolean actualOutput = pizza.price() == 20.95;
        assertFalse(actualOutput);

    }

    @Test
    public void invalid4() {
        Pizza pizza = new BuildYourOwn();
        ArrayList<Topping> tpings = new ArrayList<Topping>();
        pizza.size = Size.MEDIUM;
        tpings.add(Topping.BEEF);
        tpings.add(Topping.ARTICHOKE);
        tpings.add(Topping.SAUSAGE);
        pizza.toppings = tpings;
        pizza.extraSauce = false;
        pizza.extraCheese = true;
        boolean actualOutput = pizza.price() == 12.99;
        assertFalse(actualOutput);

    }

    @Test
    public void invalid5() {
        Pizza pizza = new BuildYourOwn();
        ArrayList<Topping> tpings = new ArrayList<Topping>();
        pizza.size = Size.SMALL;
        tpings.add(Topping.BEEF);
        tpings.add(Topping.ARTICHOKE);
        tpings.add(Topping.SAUSAGE);
        tpings.add(Topping.CRAB_MEAT);
        tpings.add(Topping.ONION);
        pizza.toppings = tpings;
        pizza.extraSauce = false;
        pizza.extraCheese = false;
        boolean actualOutput = pizza.price() == 15.97;
        assertFalse(actualOutput);

    }
}
