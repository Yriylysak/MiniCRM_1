package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * Created by dmitry on 11.02.17.
 */
public class OkController {
    @FXML
    Label addNameField;
    @FXML
    Label addLoginField;
    @FXML
    Label addPasswordField;
    @FXML
    Button btnOK;

    @FXML
    private void onActionOK(){
        GraphicsLoader.closeWindow(btnOK);
    }
}
