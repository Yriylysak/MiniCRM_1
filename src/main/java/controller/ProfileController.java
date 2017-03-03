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
import service.UserServiceImpl;

import java.util.Date;

import java.io.IOException;


import static controller.EnterController.currentEmployee1;
import static controller.EnterController.currentUser1;

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
    TextField fldProfileNewPass;
    @FXML
    TextField fldProfileNewPass2;
    @FXML
    TextField fldProfilePosition;
    @FXML
    TextField fldProfileCurrentPass;

    @FXML
    TextField fldProfileDate;
    @FXML
    Button btnSaveEdit;
    @FXML
    Button btnEscProfile;
    @FXML
    ImageView image;
    private int countWrongEmail = 0;


    @FXML
    public void initialize() {
        fldProfileName.setText(currentEmployee1.getName());
        fldProfileSurname.setText(currentEmployee1.getSureName());
        fldProfilePosition.setText(currentEmployee1.getPosition().toString());
        fldProfileDate.setText(currentUser1.getDate().toString());
        fldProfileEmail.setText(currentUser1.getEmail());

        //System.out.println(currentEmployee1.getUser().getEmail());
       // fldProfileEmail.setText(currentEmployee1.getUser().getEmail());


    }


    @FXML
    private void onActionEsc() {
        GraphicsLoader.closeWindow(btnEscProfile);

    }



    @FXML
    private void onActionSave() {


        if (countWrongEmail >= 3) {

           countWrongEmail();

        }else if (fldProfileNewPass.getText().isEmpty() && fldProfileNewPass2.getText().isEmpty()) {
            System.out.println(countWrongEmail);

            if (fldProfileCurrentPass.getText().isEmpty()) {
                curentPassIsEmpty();

            } else //if(!fldProfileNewPass.getText().toString().equals(fldProfileNewPass2.getText().toString())) {
                if (fldProfileCurrentPass.getText().equals(currentUser1.getPassword())) {

                System.out.println("yra");


            }
                System.out.println("PPC");
            }



    }

    private void curentPassIsEmpty(){
        Parent root = null;
        Stage stage = new Stage();
        try {
            root = FXMLLoader.load(getClass().getResource("/view/notEnterPassword.fxml"));
            countWrongEmail++;
        } catch (IOException e) {
            e.printStackTrace();
        }

        stage.getModality();

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/view/adminWindow.css");
        stage.setScene(scene);
        stage.setTitle("Password field is empty");
        stage.show();
        stage.setResizable(false);
    }

    private void countWrongEmail() {
        Parent root = null;
        Stage stage = new Stage();
        try {
            root = FXMLLoader.load(getClass().getResource("/view/limiteWrongPassword.fxml"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        //stage.getModality();

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/view/adminWindow.css");
        stage.setScene(scene);
        stage.setTitle("Limite wrong password");
        stage.show();
        stage.setResizable(false);
    }
    @FXML
    public void onActionNewPass() {
        System.out.println(fldProfileNewPass.getText());
    }
}
