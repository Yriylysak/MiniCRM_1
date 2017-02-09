package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

/**
 * Created by Yura on 05.02.2017.
 */
public class enterContorller {

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
    @FXML
    private void onActionEnter() throws IOException
    {

        /*if(loginField.getText()=="Admin"&&passwordField.getText()=="1")
        {*/

            Parent root = null;
            Stage stage = new Stage();
            try{
                root = FXMLLoader.load(getClass().getResource("/view/adminWindow.fxml"));

            }catch (IOException e){e.printStackTrace();}
                Scene scene = new Scene(root);
                scene.getStylesheets().add("/view/adminWindow.css");
                stage.setScene(scene);
                stage.show();


        /*}*/


    }
    @FXML
    private void onActionCancel() {
        System.exit(0);
    }
}
