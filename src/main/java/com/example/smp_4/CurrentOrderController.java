package com.example.smp_4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class CurrentOrderController {

    @FXML
    private TextField orderNumberText;

    @FXML
    private TextField orderTotalText;

    @FXML
    private Button placeOrderButton;

    @FXML
    private Button removePizzaButton;

    @FXML
    private TextField salesTaxText;

    @FXML
    private TextField subtotalText;

    @FXML
    private ListView<Pizza> pizzaList;

    @FXML
    void RemovePizza(ActionEvent event) {
        if (!pizzaList.getItems().isEmpty() && pizzaList.getSelectionModel().getSelectedItem() != null){
            pizzaList.getItems().remove(pizzaList.getSelectionModel().getSelectedItem());
        }

    }
    public void addOrder(Pizza pizzaType){
        pizzaList.getItems().add(pizzaType);
    }

    @FXML
    void placeOrder(ActionEvent event) {

    }

}
