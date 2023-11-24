package com.example.smp_4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class CurrentOrderController {
    private static StoreOrders storeOrders;
    private Order currentOrder;

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

    public static void setStoreOrders(StoreOrders orders){
        storeOrders = orders;
    }

    public void updateOrder(Order order){
        this.currentOrder = order;
        setFields();
    }


    //Why does this not work broooo
    @FXML
    void addOrderFromController(Order order){
        String orderNumber = String.valueOf((order.getID()));
        System.out.print(orderNumber);
        pizzaList.getItems().add(String.valueOf(order));
       // orderNumberText.setText(orderNumber);
        orderNumberText.setText("test");
       /* subtotalText.setText(String.valueOf(order.getSubtotal()));
        salesTaxText.setText(String.valueOf(order.getSubtotal() * 0.06625));
        orderTotalText.setText(String.valueOf(order.getTotalPrice()));
        pizzaList.getItems().clear();
        for(Pizza pizza : order.getOrderList()){
            pizzaList.getItems().add(pizza.toString());
        }*/



    }
    @FXML
    void setFields(){
        orderNumberText.setText(String.valueOf(storeOrders.getNextOrderNumber()));
        subtotalText.setText(String.valueOf(currentOrder.getSubtotal()));
        salesTaxText.setText(String.valueOf(currentOrder.getSubtotal() * 0.06625));
        orderTotalText.setText(String.valueOf(currentOrder.getTotalPrice()));
        pizzaList.getItems().clear();
        for(Pizza pizza : currentOrder.getOrderList()){
            pizzaList.getItems().add(pizza.toString());
        }
    }
    @FXML
    void removePizza(ActionEvent event) {
        if (!pizzaList.getItems().isEmpty() && pizzaList.getSelectionModel().getSelectedItem() != null){
            pizzaList.getItems().remove(pizzaList.getSelectionModel().getSelectedItem());
            currentOrder.removePizza(pizzaList.getSelectionModel().getSelectedIndex());
        }

    }
    @FXML
    void clearFields(){
        orderNumberText.clear();
        subtotalText.clear();
        salesTaxText.clear();
        orderTotalText.clear();
        pizzaList.getItems().clear();
    }

    /*public void addOrder(Pizza pizzaType){
        pizzaList.getItems().add(pizzaType);
    }*/

    @FXML
    void placeOrder(ActionEvent event) {
        storeOrders.addOrder(currentOrder);
        clearFields();
        PizzaStoreApplication.updatesStoreOrders(storeOrders);
    }

}
