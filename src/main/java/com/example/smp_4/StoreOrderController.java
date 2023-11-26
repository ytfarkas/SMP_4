package com.example.smp_4;

import javafx.fxml.FXML;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

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

    public void setStoreOrders(){
        storeOrders = mainMenuController.getStoreOrders();
        orderDropdown.getItems().clear();
        updateOrderDropdown();
    }
    public void setMainMenuController(MainMenuController controller){
        mainMenuController = controller;
    }
    @FXML
    void initialize(){
        /*storeOrders = new StoreOrders();
        storeOrders.addOrder(new Order(storeOrders.getCurrentOrderNumber(), new ArrayList<Pizza>()));*/
        addOrderDropdownListener();
    }
    @FXML
    void updateOrderDropdown(){
        for(Order order : storeOrders.getStoreOrderList()){
            orderDropdown.getItems().add(order.getID());
        }
    }
    @FXML
    void cancelOrder(ActionEvent event){
        int orderNum = (int) orderDropdown.getValue();
        mainMenuController.cancelOrder(orderNum);
        for(Order order : storeOrders.getStoreOrderList()){
            if(order.getID() == orderNum){
                storeOrders.getStoreOrderList().remove(order);
            }
        }
        updateOrderDropdown();
    }

    @FXML
    void addOrderDropdownListener(){
        orderDropdown.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                    if(orderDropdown.getValue() == null){
                        return;
                    }
                    int orderNum = orderDropdown.getValue();
                    for(Order order : storeOrders.getStoreOrderList()){
                        if(order.getID() == orderNum){
                            orderItems.getItems().clear();
                            orderTotal.setText(String.format("%,.2f", order.getTotalPrice()));
                            for(Pizza pizza : order.getOrderList()){
                                orderItems.getItems().add(pizza.toString());
                            }
                        }
                    }
                });
    }
    @FXML
    void ExportStoreOrder(ActionEvent event){
            try (PrintWriter output = new PrintWriter(new FileWriter("src/main/java/com/example/smp_4/output.txt"))) {
                for (Order order : storeOrders.getStoreOrderList()) {
                    for (Pizza pizza : order.getOrderList()) {
                        output.print("Order # " + order.getID() + " ");
                        output.println(pizza.toString());
                    }
                }
                output.flush();
            }
            catch (IOException e){
                e.printStackTrace();
            }
            catch (NullPointerException e){
                    Alert nullStoreOrder = new Alert(Alert.AlertType.ERROR);
                    nullStoreOrder.setContentText("There are no store orders to be printed!");
                    nullStoreOrder.showAndWait();
                }
        }


    }
