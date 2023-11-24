package com.example.smp_4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuController {

    @FXML
    private Button SpecialtyPizzaButton;

    @FXML
    private Button buildPizzaButton;

    @FXML
    private Button yourOrderButton;

    @FXML
    private Button storeOrderButton;

    @FXML
    private ImageView specialtyPizzaImage;

    @FXML
    private ImageView bYOPizzaImage;

    @FXML
    private ImageView orderImage;

    @FXML
    private ImageView storeOrderImage;


    @FXML
    void initialize(){

        Image specialImage = new Image("file:src/main/resources/com/example/smp_4/Specialty_Pizza.jpeg");
        specialtyPizzaImage.setImage(specialImage);
        Image buildPizza = new Image("file:src/main/resources/com/example/smp_4/buildPizzaImage.jpeg");
        bYOPizzaImage.setImage(buildPizza);
        Image order = new Image("file:src/main/resources/com/example/smp_4/OrderImage.jpeg");
        orderImage.setImage(order);
        Image storeOrder = new Image("file:src/main/resources/com/example/smp_4/StoreOrderImage.jpeg");
        storeOrderImage.setImage(storeOrder);

    }

    @FXML
    void specialtyPizzaMenu(ActionEvent event) throws IOException {
        FXMLLoader SpecialtyPizzaMenu = new FXMLLoader(getClass().getResource("specialty-pizza.fxml"));
        Parent root = SpecialtyPizzaMenu.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Specialty Pizza Menu");
        stage.show();
    }

    @FXML
    void buildPizza(ActionEvent event) throws IOException{
        FXMLLoader buildPizzaMenu = new FXMLLoader(getClass().getResource("build-your-own.fxml"));
        Parent root = buildPizzaMenu.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Build Your Own Pizza");
        stage.show();
    }

    @FXML
    void yourOrder(ActionEvent event) throws IOException {
        FXMLLoader currentOrderMenu = new FXMLLoader(getClass().getResource("current-order.fxml"));
        Parent root = currentOrderMenu.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Current Order");
        stage.show();

    }

    @FXML
    void storeOrder(ActionEvent event) throws IOException{
        FXMLLoader storeOrderMenu = new FXMLLoader(getClass().getResource("store-order.fxml"));
        Parent root = storeOrderMenu.load();

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Store Order");
        stage.show();
    }

    }
