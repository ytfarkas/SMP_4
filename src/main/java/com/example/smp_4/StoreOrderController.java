package com.example.smp_4;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class StoreOrderController {
    private static StoreOrders storeOrders;
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

    public static void setStoreOrders(StoreOrders orders){
        storeOrders = orders;
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
        for(Order order : storeOrders.getStoreOrderList()){
            if(order.getID() == orderNum){
                storeOrders.getStoreOrderList().remove(order);
            }
        }
        PizzaStoreApplication.updatesStoreOrders(storeOrders);
        updateOrderDropdown();
    }

    @FXML
    void addOrderDropdownListener(){
        orderDropdown.setOnAction((ActionEvent) ->{
                    int orderNum = (int) orderDropdown.getValue();
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




}