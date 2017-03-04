package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Created by Олег on 04.03.2017.
 */
public class IsOkey  {
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
