package com.example.smp_4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PizzaStoreApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader MainMenu = new FXMLLoader(PizzaStoreApplication.class.getResource("main-menu.fxml"));
        Scene scene = new Scene(MainMenu.load(), 600, 400);
        stage.setTitle("DnY Pizza!");
        StoreOrders storeOrders = new StoreOrders();
        updatesStoreOrders(storeOrders);
        stage.setScene(scene);
        stage.show();
    }

    public static void updatesStoreOrders(StoreOrders storeOrders){
        //do you need to update storeorders in this class like in the two classes below?
        StoreOrderController.setStoreOrders(storeOrders);
        CurrentOrderController.setStoreOrders(storeOrders);
    }

    public static void main(String[] args) {
        launch();
    }
}