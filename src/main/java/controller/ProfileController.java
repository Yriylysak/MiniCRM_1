package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.PointLight;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by dmitry on 23.02.17.
 */
public class ProfileController {
    @FXML
    TextField fldProfileName;
    @FXML
    TextField fldProfileSurname;
    @FXML
    TextField fldProfileEmail;
    @FXML
    TextField fldProfilePhone;
    @FXML
    TextField fldProfilePass;
    @FXML
    Button btnSaveEdit;
    @FXML
    Button btnEscProfile;
    @FXML
    ImageView image;


    @FXML
    private void onActionEsc() {
        GraphicsLoader.closeWindow(btnEscProfile);
        Parent root = null;
        Stage primaryStage = new Stage();
        try {
            root = FXMLLoader.load(getClass().getResource("/view/enterWindow.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        primaryStage.setTitle("Авторизация");
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/view/enterWindow.css");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    @FXML
    private void onActionSave(){

    }
}
