package controller;

import entity.Client;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by dmitry on 15.02.17.
 */
public class CreateClientController {
    @FXML
    TextField fldName;
    @FXML
    TextField fldSurname;
    @FXML
    ListView clientList;
    @FXML
    Button btnAdd;
    @FXML
    Button btnCancelAdd;
    @FXML
    Button btnGetClient;




    @FXML
    private void onActionAdd(){

    }
    @FXML
    private void onActionCancelAdd(){
        GraphicsLoader.closeWindow(btnCancelAdd);
    }
    @FXML
    private void onActionGetClient(){

    }
}
