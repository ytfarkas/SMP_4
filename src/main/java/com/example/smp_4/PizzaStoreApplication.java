package com.example.smp_4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * PizzaStoreApplication is an extension of the Application class which starts and shows the MainMenu Stage
 *
 * @Author David Rahabi, Judah Farkas
 */
public class PizzaStoreApplication extends Application {
    /**
     * start initializes the MainMenu Stage and shows it
     *
     * @param stage stage
     * @throws IOException exception
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader MainMenu = new FXMLLoader(PizzaStoreApplication.class.getResource("main-menu.fxml"));
        Scene scene = new Scene(MainMenu.load(), 600, 400);
        stage.setTitle("DnY Pizza!");
        stage.setScene(scene);
        stage.show();
    }


    /**
     * main launches the program
     *
     * @param args args
     */
    public static void main(String[] args) {
        launch();
    }
}