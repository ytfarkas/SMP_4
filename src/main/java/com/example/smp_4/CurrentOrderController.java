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

    /**
     * setMainMenuController connects the MainMenuController and BuildYourOwnController
     *
     * @param controller MainMenuController
     */
    public void setMainMenuController(MainMenuController controller) {
        mainMenuController = controller;
    }

    /**
     * addToCurrentOrder adds the pizza to the current order
     *
     * @param pizza pizza
     */
    public void addToCurrentOrder(Pizza pizza) {
        currentOrder.addToOrder(pizza);
        setFields();
    }

    /**
     * resetFields resets all fields of the current order
     */
    public void resetFields() {
        setFields();
    }

    /**
     * initialize initializes the storeOrder and currentOrder
     */
    @FXML
    void initialize() {
        storeOrders = new StoreOrders();
        currentOrder = new Order(storeOrders.getCurrentOrderNumber(), new ArrayList<Pizza>());
    }

    /**
     * setFields sets the fields of the current order. this takes in the order and sets all the price fields as needed
     */
    @FXML
    void setFields() {
        currentOrder = mainMenuController.getCurrentOrder();
        storeOrders = mainMenuController.getStoreOrders();
        orderNumberText.setText(String.valueOf(currentOrder.getID()));
        subtotalText.setText(String.format("%,.2f", currentOrder.getSubtotal()));
        salesTaxText.setText(String.format("%,.2f", currentOrder.getSubtotal() * 0.06625));
        orderTotalText.setText(String.format("%,.2f", currentOrder.getTotalPrice()));
        pizzaList.getItems().clear();
        for (Pizza pizza : currentOrder.getOrderList()) {
            pizzaList.getItems().add(pizza.toString());
        }
    }

    /**
     * removePizza removes the pizza from the order
     *
     * @param event removePizzaButton
     */
    @FXML
    void removePizza(ActionEvent event) {
        if (!pizzaList.getItems().isEmpty() && pizzaList.getSelectionModel().getSelectedItem() != null) {
            mainMenuController.removePizzaFromOrder(pizzaList.getSelectionModel().getSelectedIndex());
            pizzaList.getItems().remove(pizzaList.getSelectionModel().getSelectedItem());
        }
        setFields();
    }

    /**
     * clearFields clears all the fields in the CurrentOrderScene
     */
    @FXML
    void clearFields() {
        orderNumberText.clear();
        subtotalText.clear();
        salesTaxText.clear();
        orderTotalText.clear();
        pizzaList.getItems().clear();
    }

    /**
     * placeOrder places the order and sends it to communicate with the main controller
     *
     * @param event placeOrderButton
     */
    @FXML
    void placeOrder(ActionEvent event) {
        if (currentOrder.getTotalPrice() == 0) {
            //display error message telling user to please add items to the order first
            return;
        }
        mainMenuController.addToStoreOrders();
        setFields();
        displayOrderPlacedAlert();
    }

    /**
     * displayOrderPlacedAlert displays the popup of that informs user that the order has been placed
     */
    @FXML
    void displayOrderPlacedAlert() {
        Alert added = new Alert(Alert.AlertType.INFORMATION);
        added.setContentText("Order Placed!");
        added.showAndWait();
    }

}
