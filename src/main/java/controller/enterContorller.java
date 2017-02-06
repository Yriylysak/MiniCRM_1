package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

/**
 * Created by Yura on 05.02.2017.
 */
public class enterContorller {

    @FXML
     TextField loginField;
    @FXML
     TextField passwordField;
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

        if(loginField.getText()=="Admin"&&passwordField.getText()=="1")
        {




        }


    }
    @FXML
    private void onActionCancel() {
        System.exit(0);
    }
}
