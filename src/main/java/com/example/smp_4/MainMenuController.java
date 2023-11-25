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
import javafx.scene.control.Alert;

import java.io.IOException;
import java.util.ArrayList;

public class MainMenuController {

    private CurrentOrderController currentOrderController;
    private SpecialtyPizzaController specialtyPizzaController;
    private BuildYourOwnController buildYourOwnController;
    private StoreOrderController storeOrderController;
    private Stage currentOrderStage;
    private Stage specialtyPizzaStage;
    private Stage buildYourOwnStage;
    private Stage storeOrdersStage;
    private Order currentOrder;
    private StoreOrders storeOrders;

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

    public void addToCurrentOrder(Pizza pizza){
        currentOrder.addToOrder(pizza);
    }
    public void addToStoreOrders(){
        System.out.println(currentOrder.getID());
        storeOrders.addOrder(currentOrder);
        currentOrder = new Order(storeOrders.getCurrentOrderNumber(), new ArrayList<Pizza>());
        System.out.println(currentOrder.getID());
        storeOrderController.setStoreOrders();
    }

    public StoreOrders getStoreOrders(){
        return storeOrders;
    }
    public Order getCurrentOrder(){
        return currentOrder;
    }
    public void removePizzaFromOrder(int index){
        currentOrder.removePizza(index);
    }
    public void cancelOrder(int index){

    }
    @FXML
    void initialize(){
        Image specialImage = new Image("file:src/main/resources/com/example/smp_4/Photos/Specialty_Pizza.jpeg");
        specialtyPizzaImage.setImage(specialImage);
        Image buildPizza = new Image("file:src/main/resources/com/example/smp_4/Photos/buildPizzaImage.jpeg");
        bYOPizzaImage.setImage(buildPizza);
        Image order = new Image("file:src/main/resources/com/example/smp_4/Photos/OrderImage.jpeg");
        orderImage.setImage(order);
        Image storeOrder = new Image("file:src/main/resources/com/example/smp_4/Photos/StoreOrderImage.jpeg");
        storeOrderImage.setImage(storeOrder);

        storeOrders = new StoreOrders();
        currentOrder = new Order(storeOrders.getCurrentOrderNumber(), new ArrayList<Pizza>());
       try {
           initializeSpecialtyMenu();
           initializeCurrentOrder();
           initializeStoreOrders();
           initializeBuildYourOwn();

       }catch (IOException m){
           System.out.println("Stage Initialization error");
           m.printStackTrace();
       }
    }
    @FXML
    void initializeSpecialtyMenu() throws IOException{
        specialtyPizzaStage = new Stage();
        FXMLLoader SpecialtyPizzaMenu = new FXMLLoader(getClass().getResource("specialty-pizza.fxml"));
        Parent specialtyPizzaParent = SpecialtyPizzaMenu.load();
        specialtyPizzaStage.setScene(new Scene(specialtyPizzaParent));
        specialtyPizzaStage.setTitle("Specialty Pizza Menu");
        specialtyPizzaController = SpecialtyPizzaMenu.getController();
        specialtyPizzaController.setMainMenuController(this);
    }

    @FXML
    void initializeCurrentOrder() throws IOException{
        currentOrderStage = new Stage();
        FXMLLoader currentOrderMenu = new FXMLLoader(getClass().getResource("current-order.fxml"));
        Parent currentOrderParent = currentOrderMenu.load();
        currentOrderStage.setScene(new Scene(currentOrderParent));
        currentOrderStage.setTitle("Current Order");
        currentOrderController = currentOrderMenu.getController();
        currentOrderController.setMainMenuController(this);
    }
    @FXML
    void initializeBuildYourOwn() throws IOException{
        buildYourOwnStage = new Stage();
        FXMLLoader buildPizzaMenu = new FXMLLoader(getClass().getResource("build-your-own.fxml"));
        Parent root = buildPizzaMenu.load();
        buildYourOwnStage.setScene(new Scene(root));
        buildYourOwnStage.setTitle("Build Your Own Pizza");
        buildYourOwnController = buildPizzaMenu.getController();
        buildYourOwnController.setMainMenuController(this);
    }
    @FXML
    void initializeStoreOrders() throws IOException{
        storeOrdersStage = new Stage();
        FXMLLoader storeOrderMenu = new FXMLLoader(getClass().getResource("store-order.fxml"));
        Parent root = storeOrderMenu.load();
        storeOrdersStage.setScene(new Scene(root));
        storeOrdersStage.setTitle("Store Orders");
        storeOrderController = storeOrderMenu.getController();
        storeOrderController.setMainMenuController(this);
    }
    @FXML
    void specialtyPizzaMenu(ActionEvent event) throws IOException {
        specialtyPizzaStage.show();
    }

    @FXML
    void buildPizza(ActionEvent event) throws IOException{
        buildYourOwnStage.show();
    }

    @FXML
    void yourOrder(ActionEvent event) throws IOException {
        currentOrderStage.show();
        currentOrderController.setFields();
    }

    @FXML
    void storeOrder(ActionEvent event) throws IOException{
        storeOrdersStage.show();
    }

    }
