package com.example.smp_4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PizzaStoreApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader MainMenu = new FXMLLoader(PizzaStoreApplication.class.getResource("main-menu.fxml"));
        Scene scene = new Scene(MainMenu.load(), 600, 400);
        stage.setTitle("DnY Pizza!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}