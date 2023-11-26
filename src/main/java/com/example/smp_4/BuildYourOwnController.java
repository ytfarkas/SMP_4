package com.example.smp_4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.util.ArrayList;

public class BuildYourOwnController {

    private Order currentOrder;
    private MainMenuController mainMenuController;

    @FXML
    private ToggleGroup SizeGroup;

    @FXML
    private Button addButton;

    @FXML
    private ListView<String> addedToppings;

    @FXML
    private CheckBox extraCheeseButton;

    @FXML
    private CheckBox extraSauceButton;

    @FXML
    private RadioButton largePizza;

    @FXML
    private RadioButton mediumPizza;

    @FXML
    private RadioButton smallPizza;

    @FXML
    private Button removeButton;

    @FXML
    private ComboBox<String> sauceBox;

    @FXML
    private ListView<String> toppingsList;

    @FXML
    private Button addToOrderButton;

    @FXML
    public TextField priceText;

    public void setMainMenuController(MainMenuController controller){
        mainMenuController = controller;
    }
    public void updateOrder(Order order){
        this.currentOrder = order;
    }

    @FXML
    private void initialize(){
        toppingsList.getItems().addAll("Sausage", "Pepperoni", "Ham", "Beef", "Beyond Beef",
                "Green Peppers", "Onion", "Black Olive", "Mushroom", "Artichoke",
                "Shrimp", "Squid", "Crab Meat");
        sauceBox.getItems().addAll("Tomato", "Alfredo");
        sauceBox.setValue("Tomato");
        sauceBox.selectionModelProperty().addListener((observable, oldValue,newValue ) -> updatePrice());
        SizeGroup.selectedToggleProperty().addListener((observable, oldValue,newValue ) -> updatePrice());
        extraSauceButton.selectedProperty().addListener((observable, oldValue,newValue ) -> updatePrice());
        extraCheeseButton.selectedProperty().addListener((observable, oldValue,newValue ) -> updatePrice());

    }

    @FXML
    void AddOnPizza(ActionEvent event) {
        if (!toppingsList.getItems().isEmpty() && toppingsList.getSelectionModel().getSelectedItem() != null) {
            if (addedToppings.getItems().size() < 7) {
                addedToppings.getItems().add(toppingsList.getSelectionModel().getSelectedItem());
                toppingsList.getItems().remove(toppingsList.getSelectionModel().getSelectedItem());
                updatePrice();
            }else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Too many toppings!");
                alert.setHeaderText(null);
                alert.setContentText("Maximum of 7 toppings are aloud");
                alert.showAndWait();
            }

        }
    }

    @FXML
    void RemoveFromPizza(ActionEvent event) {
        if (!addedToppings.getItems().isEmpty() && addedToppings.getSelectionModel().getSelectedItem() != null) {
            toppingsList.getItems().add(addedToppings.getSelectionModel().getSelectedItem());
            addedToppings.getItems().remove(addedToppings.getSelectionModel().getSelectedItem());
            updatePrice();
        }
    }

    void updatePrice() {
        double price = 0.00;
        if (smallPizza.isSelected()) {
            price = 8.99;
        } else if (mediumPizza.isSelected()) {
            price = 10.99;
        } else if (largePizza.isSelected()) {
            price = 12.99;
        }
        if (extraCheeseButton.isSelected()){
            price = price + 1.00;
        }
        if (extraSauceButton.isSelected()){
            price = price + 1.00;
        }
        if (addedToppings.getItems().size() > 3){
            price += (addedToppings.getItems().size() - 3)*1.49;

        }
        double rounded = Math.round(price * 100.0)/ 100.0;
        priceText.setText(String.valueOf(rounded));
    }
    @FXML
    void addToOrder(ActionEvent event){
        //check for null and incorrect values first before doing code
        if (SizeGroup.getSelectedToggle() == null){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Select size");
            alert.setHeaderText(null);
            alert.setContentText("Please Select Size");
            alert.showAndWait();
        } else if (addedToppings.getItems().size() < 3){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Add More Toppings");
            alert.setHeaderText(null);
            alert.setContentText("Minimum Amount of toppings are 3");
            alert.showAndWait();
        }
        Pizza buildPizza = PizzaMaker.createPizza("");

        ArrayList<Topping> tops = createToppingList();
        buildPizza.toppings = tops;
        buildPizza.sauce = Sauce.valueOf(sauceBox.getValue());
        buildPizza.extraSauce = extraSauceButton.isSelected();
        buildPizza.extraCheese = extraCheeseButton.isSelected();
        displayOrderPlaced();
    }

    private ArrayList<Topping> createToppingList(){
        ArrayList<Topping> tpngs = new ArrayList<Topping>();
        for(String t : addedToppings.getItems()){
            tpngs.add(Topping.valueOf(t));
        }
        return tpngs;
    }

    @FXML
    void displayOrderPlaced(){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Added to Cart");
        alert.setHeaderText(null);
        alert.setContentText("Order Added to cart");
        alert.showAndWait();
        clearField();
    }

    @FXML
    void clearField(){
        toppingsList.getItems().clear();
        sauceBox.getItems().clear();
        addedToppings.getItems().clear();
        SizeGroup.selectToggle(null);
        extraCheeseButton.setSelected(false);
        extraSauceButton.setSelected(false);
        toppingsList.getItems().addAll("Sausage", "Pepperoni", "Ham", "Beef", "Beyond Beef",
                "Green Peppers", "Onion", "Black Olive", "Mushroom", "Artichoke",
                "Shrimp", "Squid", "Crab Meat");
        sauceBox.getItems().addAll("Tomato", "Alfredo");
        sauceBox.setValue("Tomato");
    }

}
