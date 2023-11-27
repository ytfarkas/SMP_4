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

/**
 * MainMenuController is the main controller for all the scenes
 * This controller takes in all inputted orders as well as shows all the different scene in the program
 *
 * @Author David Rahabi, Judah Farkas
 */
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

    /**
     * addToCurrentOrder takes the inputs from the other scenes and adds the pizza to the current order
     *
     * @param pizza pizza
     */
    public void addToCurrentOrder(Pizza pizza) {
        currentOrder.addToOrder(pizza);
    }

    /**
     * addToStoreOrder adds the current order to the store order
     */
    public void addToStoreOrders() {
        storeOrders.addOrder(currentOrder);
        currentOrder = new Order(storeOrders.getCurrentOrderNumber(), new ArrayList<Pizza>());
        storeOrderController.setStoreOrders();
    }

    /**
     * getStoreOrder returns the current store orders
     *
     * @return storeOrder
     */
    public StoreOrders getStoreOrders() {
        return storeOrders;
    }

    /**
     * getCurrentOrder returns the current order
     *
     * @return currentOrder
     */
    public Order getCurrentOrder() {
        return currentOrder;
    }

    /**
     * removePizzaFromOrder removes the pizza from the current order
     *
     * @param index currentOrderIndex
     */
    public void removePizzaFromOrder(int index) {
        currentOrder.removePizza(index);
    }

    /**
     * cancelOrder cancels the order from storeOrders
     *
     * @param id currentOrderID
     */
    public void cancelOrder(int id) {
        storeOrders.cancelOrder(id);
    }

    /**
     * initialize initializes everything in the MainMenuController that needs to be initializable
     */
    @FXML
    void initialize() {
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

        } catch (IOException m) {
            // System.out.println("Stage Initialization error");
            //what should be done here
        }
    }

    /**
     * initializeSpecialtyMenu initializes the Specialty Menu
     *
     * @throws IOException exception
     */
    @FXML
    void initializeSpecialtyMenu() throws IOException {
        specialtyPizzaStage = new Stage();
        FXMLLoader SpecialtyPizzaMenu = new FXMLLoader(getClass().getResource("specialty-pizza.fxml"));
        Parent specialtyPizzaParent = SpecialtyPizzaMenu.load();
        specialtyPizzaStage.setScene(new Scene(specialtyPizzaParent));
        specialtyPizzaStage.setTitle("Specialty Pizza Menu");
        specialtyPizzaController = SpecialtyPizzaMenu.getController();
        specialtyPizzaController.setMainMenuController(this);
    }

    /**
     * initializeCurrentOrder initializes the Current order Menu
     *
     * @throws IOException exception
     */
    @FXML
    void initializeCurrentOrder() throws IOException {
        currentOrderStage = new Stage();
        FXMLLoader currentOrderMenu = new FXMLLoader(getClass().getResource("current-order.fxml"));
        Parent currentOrderParent = currentOrderMenu.load();
        currentOrderStage.setScene(new Scene(currentOrderParent));
        currentOrderStage.setTitle("Current Order");
        currentOrderController = currentOrderMenu.getController();
        currentOrderController.setMainMenuController(this);
    }

    /**
     * initializeBuildYourOwn initializes the Build Your Own Menu
     *
     * @throws IOException exception
     */
    @FXML
    void initializeBuildYourOwn() throws IOException {
        buildYourOwnStage = new Stage();
        FXMLLoader buildPizzaMenu = new FXMLLoader(getClass().getResource("build-your-own.fxml"));
        Parent root = buildPizzaMenu.load();
        buildYourOwnStage.setScene(new Scene(root));
        buildYourOwnStage.setTitle("Build Your Own Pizza");
        buildYourOwnController = buildPizzaMenu.getController();
        buildYourOwnController.setMainMenuController(this);
    }

    /**
     * initializeStoreOrders initializes the Store Order Menu
     *
     * @throws IOException exception
     */
    @FXML
    void initializeStoreOrders() throws IOException {
        storeOrdersStage = new Stage();
        FXMLLoader storeOrderMenu = new FXMLLoader(getClass().getResource("store-order.fxml"));
        Parent root = storeOrderMenu.load();
        storeOrdersStage.setScene(new Scene(root));
        storeOrdersStage.setTitle("Store Orders");
        storeOrderController = storeOrderMenu.getController();
        storeOrderController.setMainMenuController(this);
        storeOrderController.resetChoiceSelection();
    }

    /**
     * specialtyPizzaMeu shows the specialty pizza menu stage
     *
     * @param event specialtyPizzaMenu button
     * @throws IOException exception
     */
    @FXML
    void specialtyPizzaMenu(ActionEvent event) throws IOException {
        specialtyPizzaStage.show();
    }

    /**
     * buildPizza shows the build pizza menu stage
     *
     * @param event buildPizza button
     * @throws IOException exception
     */
    @FXML
    void buildPizza(ActionEvent event) throws IOException {
        buildYourOwnStage.show();
    }

    /**
     * yourOrder shows the current order menu stage
     *
     * @param event yourOrder button
     * @throws IOException exception
     */
    @FXML
    void yourOrder(ActionEvent event) throws IOException {
        currentOrderStage.show();
        currentOrderController.resetFields();
    }

    /**
     * storeOrder shows the store order menu stage
     *
     * @param event storeOrder button
     * @throws IOException exception
     */
    @FXML
    void storeOrder(ActionEvent event) throws IOException {
        storeOrdersStage.show();
        storeOrderController.setStoreOrders();
        storeOrderController.resetChoiceSelection();
    }

}
