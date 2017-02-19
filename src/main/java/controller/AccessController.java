package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * Created by dmitry on 10.02.17.
 */
public class AccessController {
    @FXML
    Button btnCancel;
    @FXML
    private void onActionClose(){
        GraphicsLoader.closeWindow(btnCancel);
    }
    @FXML
    private void onKeyCanceled() {
        onActionClose();
    }
}
