package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Created by Олег on 04.03.2017.
 */
public class LimiteWrongPassword {
    @FXML
    Button btnCancel;
    @FXML
    private void onActionClose(){
        GraphicsLoader.closeWindow(btnCancel);
        System.exit(0);
        //GraphicsLoader.closeWindow(btnCancel);

    }
    @FXML
    private void onKeyCanceled() {
        onActionClose();
    }
}
