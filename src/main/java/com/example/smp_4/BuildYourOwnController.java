package com.example.smp_4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class BuildYourOwnController {

    private Order currentOrder;

    @FXML
    private ToggleGroup Size;

    @FXML
    private Button addButton;

    @FXML
    private ListView<String> addedToppings;

    @FXML
    private CheckBox extraCheeseButton;

    @FXML
    private CheckBox extraSauceButton;

    @FXML
    private RadioButton largePizza;

    @FXML
    private RadioButton mediumPizza;

    @FXML
    private Button removeButton;

    @FXML
    private ComboBox<String> sauceBox;

    @FXML
    private RadioButton smallPizza;

    @FXML
    private ListView<String> toppingsList;

    @FXML
    private Button addToOrderButton;


    public void updateOrder(Order order){
        this.currentOrder = order;
    }

    @FXML
    private void initialize(){
        toppingsList.getItems().addAll("Sausage", "Pepperoni", "Ham", "Beef", "Beyond Beef",
                "Green Peppers", "Onion", "Black Olive", "Mushroom", "Artichoke",
                "Shrimp", "Squid", "Crab Meat");
        sauceBox.getItems().addAll("Tomato", "Alfredo");
        sauceBox.setValue("Tomato");

    }

    @FXML
    void AddOnPizza(ActionEvent event) {
        if (!toppingsList.getItems().isEmpty() && toppingsList.getSelectionModel().getSelectedItem() != null) {
            addedToppings.getItems().add(toppingsList.getSelectionModel().getSelectedItem());
            toppingsList.getItems().remove(toppingsList.getSelectionModel().getSelectedItem());
        }
    }

    @FXML
    void RemoveFromPizza(ActionEvent event) {
        if (!addedToppings.getItems().isEmpty() && addedToppings.getSelectionModel().getSelectedItem() != null) {
            toppingsList.getItems().add(addedToppings.getSelectionModel().getSelectedItem());
            addedToppings.getItems().remove(addedToppings.getSelectionModel().getSelectedItem());
        }
    }
    @FXML
    void addToOrder(ActionEvent event){


    }

}
