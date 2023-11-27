package com.example.smp_4;

import javafx.fxml.FXML;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class StoreOrderController {
    private StoreOrders storeOrders;
    private MainMenuController mainMenuController;

    @FXML
    private Button cancelOrderButton;

    @FXML
    private Button exportStoreOrdersButton;

    @FXML
    private ChoiceBox<Integer> orderDropdown;

    @FXML
    private ListView orderItems;

    @FXML
    private TextField orderTotal;

    public void setStoreOrders() {
        storeOrders = mainMenuController.getStoreOrders();
        orderDropdown.getItems().clear();
    }

    public void setMainMenuController(MainMenuController controller) {
        mainMenuController = controller;
    }

    public void resetChoiceSelection() {
        resetOrderChoice();
    }

    @FXML
    void initialize() {
        addOrderDropdownListener();
    }

    @FXML
    void resetOrderChoice() {
        orderDropdown.setValue(null);
        orderItems.getItems().clear();
        orderTotal.setText(null);
        updateOrderDropdown();
    }

    @FXML
    void updateOrderDropdown() {
        setStoreOrders();
        orderDropdown.getItems().clear();
        for (Order order : storeOrders.getStoreOrderList()) {
            orderDropdown.getItems().add(order.getID());
        }
    }

    @FXML
    void cancelOrder(ActionEvent event) {
        try {
            int id = (int) orderDropdown.getValue();
            mainMenuController.cancelOrder(id);
            setStoreOrders();
            displayOrderCancelled();
            resetOrderChoice();
        } catch (NullPointerException e) {
            displayCancelError();
        }
    }

    void displayOrderCancelled() {
        Alert added = new Alert(Alert.AlertType.INFORMATION);
        added.setContentText("Order Cancelled!");
        added.showAndWait();
    }

    @FXML
    void displayCancelError() {
        Alert added = new Alert(Alert.AlertType.ERROR);
        added.setContentText("Please select a order to cancel.");
        added.showAndWait();
    }

    @FXML
    void addOrderDropdownListener() {
        orderDropdown.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (orderDropdown.getValue() == null) {
                return;
            }
            int orderNum = orderDropdown.getValue();
            for (Order order : storeOrders.getStoreOrderList()) {
                if (order.getID() == orderNum) {
                    orderItems.getItems().clear();
                    orderTotal.setText(String.format("%,.2f", order.getTotalPrice()));
                    for (Pizza pizza : order.getOrderList()) {
                        orderItems.getItems().add(pizza.toString());
                    }
                }
            }
        });
    }

    @FXML
    void ExportStoreOrder(ActionEvent event) {
        if (storeOrders.getStoreOrderList().isEmpty()) {
            displayStoreOrdersEmpty();
        } else {
            FileChooser file = new FileChooser();
            file.setTitle("Select file for export");
            file.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
            File chosenFile = file.showOpenDialog(new Stage());
            if (chosenFile != null) {
                try (PrintWriter output = new PrintWriter(new FileWriter(chosenFile))) {
                    for (Order order : storeOrders.getStoreOrderList()) {
                        for (Pizza pizza : order.getOrderList()) {
                            output.print("Order # " + order.getID() + " ");
                            output.println(pizza.toString());
                        }
                    }
                    output.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (NullPointerException e) {
                    displayStoreOrdersEmpty();
                }
            }
        }
    }

    @FXML
    void displayStoreOrdersEmpty() {
        Alert nullStoreOrder = new Alert(Alert.AlertType.ERROR);
        nullStoreOrder.setContentText("There are no store orders to be printed!");
        nullStoreOrder.showAndWait();
    }


}
