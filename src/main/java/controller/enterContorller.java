package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.UserService;
import service.UserServiceImpl;

import java.io.IOException;

/**
 * Created by Yura on 05.02.2017.
 */
public class enterContorller {

    UserService userService = new UserServiceImpl();

    @FXML
     TextField loginField;
    @FXML
     PasswordField passwordField;
    @FXML
     Button enterButton;
    @FXML
     Button cancelButton;



    @FXML
    private void onActionLog() {

        System.out.println(loginField.getText());
    }




    @FXML
    private void onActionPass(){
        System.out.println(passwordField.getText());

    }
    //
    @FXML
    private void onActionEnter()
    {

        if(userService.isAdmin(loginField.getText(),passwordField.getText()))
        {

            Parent root = null;
            Stage stage = new Stage();
            try{
                root = FXMLLoader.load(getClass().getResource("/view/adminWindow.fxml"));

            }catch (IOException e){e.printStackTrace();}
                Scene scene = new Scene(root);
                scene.getStylesheets().add("/view/adminWindow.css");
                stage.setScene(scene);
                stage.show();


        }
        else {
            System.out.println("Windov manager");
        }


    }

    @FXML
    private void onActionCancel() {
        System.exit(0);
    }
}
