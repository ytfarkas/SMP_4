package com.example.smp_4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.ResourceBundle;

public class SpecialtyPizzaController {

    private Order currentOrder;
    private MainMenuController mainMenuController;

    @FXML
    private Button ConfirmPizza;

    @FXML
    private ComboBox<String> Pizza_Selection;

    @FXML
    private ToggleGroup SizeGroup;

    @FXML
    private CheckBox extraSauceBox;

    @FXML
    private CheckBox extraCheeseBox;

    @FXML
    private TextField sauceBox;

    @FXML
    private RadioButton sizeLarge;

    @FXML
    private RadioButton sizeMedium;

    @FXML
    private RadioButton sizeSmall;

    @FXML
    private ListView<String> toppingsBox;

    @FXML
    private TextField priceBox;

    @FXML
    private ImageView pizzaPhoto;


    public void setMainMenuController(MainMenuController controller){
        mainMenuController = controller;
    }
    public void updateOrder(Order order){
        this.currentOrder = order;
    }
    @FXML
    private void initialize(){
        Pizza_Selection.getItems().addAll("Deluxe", "Supreme", "Meatzza", "Seafood", "Pepperoni");
        Pizza_Selection.valueProperty().addListener((observable, oldValue, newValue) -> updatePrice());
        SizeGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> updatePrice());
        extraSauceBox.selectedProperty().addListener((observable, oldValue,newValue ) -> updatePrice());
        extraCheeseBox.selectedProperty().addListener((observable, oldValue,newValue ) -> updatePrice());
        Pizza_Selection.setValue("Deluxe");
        SizeGroup.selectToggle(sizeSmall);
        toppingsBox.getItems().addAll("Sausage", "Mushroom", "Green Pepper", "Pepperoni", "Onion");
        sauceBox.setText("Tomato");
        Image image = new Image("file:src/main/resources/com/example/smp_4/Photos/deluxePizza.jpeg");
        pizzaPhoto.setImage(image);


    }

   @FXML
    void confirmButton(ActionEvent event) throws IOException {
       Pizza pizza = PizzaMaker.createPizza(Pizza_Selection.getValue());
       if (sizeSmall.isSelected()) {
           pizza.size = Size.SMALL; //? does this work
       } else if (sizeMedium.isSelected()) {
           pizza.size = Size.MEDIUM; //? does this work
       } else if (sizeLarge.isSelected()) {
           pizza.size = Size.LARGE; //? does this work
       }
       pizza.extraCheese = extraCheeseBox.isSelected();
       pizza.extraSauce = extraSauceBox.isSelected();
       mainMenuController.addToCurrentOrder(pizza);
    }



    @FXML
    void SelectPizza(ActionEvent event) {
    if (Pizza_Selection.getValue().equals("Deluxe")){
        Image image = new Image("file:src/main/resources/com/example/smp_4/Photos/deluxePizza.jpeg");
        pizzaPhoto.setImage(image);
        toppingsBox .getItems().clear();
        toppingsBox.getItems().addAll("Sausage", "Mushroom", "Green Pepper", "Pepperoni", "Onion");
        sauceBox.setText("Tomato");

    } else if (Pizza_Selection.getValue().equals("Supreme")){
        Image image = new Image("file:src/main/resources/com/example/smp_4/Photos/supremePizza.jpeg");
        pizzaPhoto.setImage(image);
        toppingsBox.getItems().clear();
        toppingsBox.getItems().addAll("Sausage", "Pepperoni", "Ham", "Green Pepper", "Onion", "Black Olives", "Mushroom");
        sauceBox.setText("Tomato");
    } else if (Pizza_Selection.getValue().equals("Meatzza")){
        Image image = new Image("file:src/main/resources/com/example/smp_4/Photos/meatzza.jpeg");
        pizzaPhoto.setImage(image);
        toppingsBox.getItems().clear();
        toppingsBox.getItems().addAll("Sausage", "Pepperoni", "Beef", "Lamb");
        sauceBox.setText("Tomato");

    }else if (Pizza_Selection.getValue().equals("Seafood")){
        Image image = new Image("file:src/main/resources/com/example/smp_4/Photos/seafoodPizza.jpeg");
        pizzaPhoto.setImage(image);
        toppingsBox.getItems().clear();
        toppingsBox.getItems().addAll("Shrimp", "Squid", "Crab Meat");
        sauceBox.setText("Alfredo");

    }else if (Pizza_Selection.getValue().equals("Pepperoni")){
        Image image = new Image("file:src/main/resources/com/example/smp_4/Photos/pepperoniPizza.jpeg");
        pizzaPhoto.setImage(image);
        toppingsBox.getItems().clear();
        toppingsBox.getItems().addAll("Pepperoni");
        sauceBox.setText("Tomato");
    }else{
        toppingsBox.getItems().clear();
    }
    }

    void updatePrice() {
        double price = 0.00;
        if (Pizza_Selection.getValue().equals("Deluxe")) {
            price = 14.99;
        } else if (Pizza_Selection.getValue().equals("Supreme")) {
            price = 15.99;
        } else if (Pizza_Selection.getValue().equals("Meatzza")) {
            price = 16.99;
        } else if (Pizza_Selection.getValue().equals("Seafood")) {
            price = 17.99;
        } else if (Pizza_Selection.getValue().equals("Pepperoni")) {
            price = 10.99;
        }
        if (sizeMedium.isSelected()){
            price = price + 2.00;
        }else if (sizeLarge.isSelected()){
            price = price + 4.00;
        }
        if (extraCheeseBox.isSelected()){
            price = price + 1.00;
        }
        if (extraSauceBox.isSelected()){
            price = price + 1.00;
        }
        double rounded = Math.round(price * 100.0)/ 100.0;
        priceBox.setText(String.valueOf(rounded));
    }


}
