package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.EmployeeService;
import service.EmployeeServiceImpl;
import service.UserService;
import service.UserServiceImpl;

import java.io.IOException;


/**
 * Created by Yura on 05.02.2017.
 */
public class EnterContorller {

    private UserService userService = new UserServiceImpl();
    private EmployeeService employeeService = new EmployeeServiceImpl();
    private int counter = 5;

    @FXML
    TextField loginField;
    @FXML
    PasswordField passwordField;
    @FXML
    Button enterButton;
    @FXML
    Button cancelButton;

    @FXML   /*Wtf ?*/
    private void onActionLog() {
        System.out.println(loginField.getText());
    }

    @FXML  /*Wtf?*/
    private void onActionPass() {
        System.out.println(passwordField.getText());
    }

    @FXML
    private void onActionEnter() {
        Parent root = null;
        Stage stage = new Stage();
        if (userService.isAdmin(loginField.getText(), passwordField.getText())) {
            try {
                root = FXMLLoader.load(getClass().getResource("/view/adminWindow.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/view/adminWindow.css");
            stage.setScene(scene);
            stage.show();
            stage.setResizable(false);
            GraphicsLoader.closeWindow(enterButton);

        } else if (userService.isUser(loginField.getText(), passwordField.getText())) {
            try {
                root = FXMLLoader.load(getClass().getResource("/view/managerWindow.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/view/adminWindow.css");
            stage.setScene(scene);
            stage.show();
            stage.setResizable(false);
        } else {
            /*loginField.clear();
            passwordField.clear();
            if (counter == 0) onActionCancel();
            /*!!!  Додати сюди Text Label, на який виводити повідомлення :
             * "Невірно введені дані! Залишилось " + counter  + " спроб!" !!!*/
            //counter--;
            //onActionEnter(); // і як сюди повернутись, щоб знову ввести дані??
            try {
                root = FXMLLoader.load(getClass().getResource("/view/accessDenied.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/view/adminWindow.css");
            stage.setScene(scene);
            stage.show();
            stage.setResizable(false);
        }

    }

    @FXML
    private void onActionCancel() {
        System.exit(0);
    }

}
