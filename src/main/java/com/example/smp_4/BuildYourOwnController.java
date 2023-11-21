package com.example.smp_4;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class BuildYourOwnController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}