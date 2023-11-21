package com.example.smp_4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import java.util.ResourceBundle;

public class SpecialtyPizzaController {

    @FXML
    private Button ConfirmPizza;

    @FXML
    private ComboBox<String> Pizza_Selection;

    @FXML
    private ToggleGroup Size;

    @FXML
    private CheckBox extraSauceBox;

    @FXML
    private CheckBox extraCheeseBox;

    @FXML
    private TextField sauceBox;

    @FXML
    private RadioButton sizeLarge;

    @FXML
    private RadioButton sizeMedium;

    @FXML
    private RadioButton sizeSmall;

    @FXML
    private ListView<String> toppingsBox;

    @FXML
    private TextField priceBox;

@FXML
private void initialize(){
    Pizza_Selection.getItems().addAll("Deluxe", "Supreme", "Meatzza", "Seafood", "Pepperoni");
    Pizza_Selection.valueProperty().addListener((observable, oldValue, newValue) -> updatePrice());
    Size.selectedToggleProperty().addListener((observable, oldValue, newValue) -> updatePrice());
    extraSauceBox.selectedProperty().addListener((observable, oldValue,newValue ) -> updatePrice());
    extraCheeseBox.selectedProperty().addListener((observable, oldValue,newValue ) -> updatePrice());

}

    @FXML
    void PizzaSize(ActionEvent event) {

    }

    @FXML
    void SelectPizza(ActionEvent event) {
    if (Pizza_Selection.getValue().equals("Deluxe")){
        toppingsBox .getItems().clear();
        toppingsBox.getItems().addAll("Sausage", "Mushroom", "Green Pepper", "Pepperoni", "Onion");
        sauceBox.setText("Tomato");

    } else if (Pizza_Selection.getValue().equals("Supreme")){
        toppingsBox.getItems().clear();
        toppingsBox.getItems().addAll("Sausage", "Pepperoni", "Ham", "Green Pepper", "Onion", "Black Olives", "Mushroom");
        sauceBox.setText("Tomato");
    } else if (Pizza_Selection.getValue().equals("Meatzza")){
        toppingsBox.getItems().clear();
        toppingsBox.getItems().addAll("Sausage", "Pepperoni", "Beef", "Lamb");
        sauceBox.setText("Tomato");

    }else if (Pizza_Selection.getValue().equals("Seafood")){
        toppingsBox.getItems().clear();
        toppingsBox.getItems().addAll("Shrimp", "Squid", "Crab Meat");
        sauceBox.setText("Alfredo");

    }else if (Pizza_Selection.getValue().equals("Pepperoni")){
        toppingsBox.getItems().clear();
        toppingsBox.getItems().addAll("Pepperoni");
        sauceBox.setText("Tomato");
    }else{
        toppingsBox.getItems().clear();
    }
    }

    void updatePrice() {
        double price = 0.00;
        if (Pizza_Selection.getValue().equals("Deluxe")) {
            price = 14.99;
        } else if (Pizza_Selection.getValue().equals("Supreme")) {
            price = 15.99;
        } else if (Pizza_Selection.getValue().equals("Meatzza")) {
            price = 16.99;
        } else if (Pizza_Selection.getValue().equals("Seafood")) {
            price = 17.99;
        } else if (Pizza_Selection.getValue().equals("Pepperoni")) {
            price = 10.99;
        }
        if (sizeMedium.isSelected()){
            price = price + 2.00;
        }else if (sizeLarge.isSelected()){
            price = price + 4.00;
        }
        if (extraCheeseBox.isSelected()){
            price = price + 1.00;
        }
        if (extraSauceBox.isSelected()){
            price = price + 1.00;
        }
        double rounded = Math.round(price * 100.0)/ 100.0;
        priceBox.setText(String.valueOf(rounded));
    }


    @FXML
    void pizzaSize(ActionEvent event) {

    }

}
