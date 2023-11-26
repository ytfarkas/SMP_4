package com.example.smp_4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;

import java.util.ArrayList;

public class CurrentOrderController {
    private StoreOrders storeOrders;
    private Order currentOrder;
    private MainMenuController mainMenuController;

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
    private ListView<String> pizzaList;

    public void setMainMenuController(MainMenuController controller){
        mainMenuController = controller;
    }

    public void addToCurrentOrder(Pizza pizza){
        currentOrder.addToOrder(pizza);
        setFields();
    }

    @FXML
    void initialize(){
        storeOrders = new StoreOrders();
        currentOrder = new Order(storeOrders.getCurrentOrderNumber(), new ArrayList<Pizza>());
    }

    @FXML
    void setFields(){
        currentOrder = mainMenuController.getCurrentOrder();
        storeOrders = mainMenuController.getStoreOrders();
        orderNumberText.setText(String.valueOf(currentOrder.getID()));
        subtotalText.setText(String.format("%,.2f", currentOrder.getSubtotal()));
        salesTaxText.setText(String.format("%,.2f", currentOrder.getSubtotal() * 0.06625));
        orderTotalText.setText(String.format("%,.2f", currentOrder.getTotalPrice()));
        pizzaList.getItems().clear();
        for(Pizza pizza : currentOrder.getOrderList()){
            pizzaList.getItems().add(pizza.toString());
        }
    }
    @FXML
    void removePizza(ActionEvent event) {
        if (!pizzaList.getItems().isEmpty() && pizzaList.getSelectionModel().getSelectedItem() != null){
            mainMenuController.removePizzaFromOrder(pizzaList.getSelectionModel().getSelectedIndex());
            pizzaList.getItems().remove(pizzaList.getSelectionModel().getSelectedItem());
        }
        setFields();
    }
    @FXML
    void clearFields(){
        orderNumberText.clear();
        subtotalText.clear();
        salesTaxText.clear();
        orderTotalText.clear();
        pizzaList.getItems().clear();
    }

    @FXML
    void placeOrder(ActionEvent event) {
        if(currentOrder.getTotalPrice() == 0){
            //display error message telling user to please add items to the order first
            return;
        }
        mainMenuController.addToStoreOrders();
        setFields();
        displayOrderPlacedAlert();
    }

    @FXML
    void displayOrderPlacedAlert(){
        Alert added = new Alert(Alert.AlertType.INFORMATION);
        added.setContentText("Order Placed!");
        added.showAndWait();
    }

}
