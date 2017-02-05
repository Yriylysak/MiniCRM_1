package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Created by Yura on 05.02.2017.
 */
public class enterContorller {
    @FXML
    private Label loginLabel;
    @FXML
    private Label passwordLabel;
    @FXML
    private TextField loginField;
    @FXML
    private TextField passwordField;
    @FXML
    private Button enterButton;
    @FXML
    private Button cancelButton;

    @FXML
    private void onActionSignIn() {
        System.out.println(loginField.getText());
        System.out.println(passwordField.getText());
    }
    @FXML
    private void onActionCancel() {
        System.exit(0);
    }
}
