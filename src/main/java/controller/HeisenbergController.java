package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by otecdimitry on 03.03.17.
 */
public class HeisenbergController {

    @FXML
    Button btnAdminWindow;
    @FXML
    Button btnManagerWindow;
    @FXML
    Button btnCashierWindow;
    @FXML
    Button btnStorekeeperWindow;
    @FXML
    Button btnOwnRoom;
    @FXML
    Button btnExit;

    @FXML
    private void onActionAdmin() {
        Parent root = null;
        Stage stage = new Stage();
        try {
            root = FXMLLoader.load(getClass().getResource("/view/adminWindow.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        stage.setTitle("Admin window");
        scene.getStylesheets().add("/view/adminWindow.css");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }
    @FXML
    private void onActionManager() {
        Parent root = null;
        Stage stage = new Stage();
        try {
            root = FXMLLoader.load(getClass().getResource("/view/managerWindow2.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        stage.setTitle("Manager window");
        scene.getStylesheets().add("/view/adminWindow.css");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }
    @FXML
    private void onActionCashier() {
        Parent root = null;
        Stage stage = new Stage();
        try {
            root = FXMLLoader.load(getClass().getResource("/view/sellerWindow.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        stage.setTitle("Cashier window");
        scene.getStylesheets().add("/view/sellerWindow.css");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }
    @FXML
    private void onActionStorekeeper() {
        Parent root = null;
        Stage stage = new Stage();
        try {
            root = FXMLLoader.load(getClass().getResource("/view/storekeeperWindow.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        stage.setTitle("Storekeeper window");
        scene.getStylesheets().add("/view/sellerWindow.css");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }
    @FXML
    private void onActionOwnRoom() {
        Parent root = null;
        Stage primaryStage = new Stage();
        try {
            root = FXMLLoader.load(getClass().getResource("/view/myProfileWindow.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        primaryStage.setTitle("Мой профиль");
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/view/myProfileWindow.css");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
    }
    @FXML
    private void onActionExit() {
        GraphicsLoader.closeWindow(btnExit);
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
}
