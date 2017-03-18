package controller;

import entity.Employee;
import entity.User;
import enumTypes.Position;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import util.ServiceUtil;
import java.io.IOException;

import static controller.ManagerController.managerLogin;

public class EnterController {
    @FXML TextField loginField;
    @FXML PasswordField passwordField;
    @FXML Button enterButton;
    @FXML Button cancelButton;
    private int counter = 5;
    public static Employee currentEmployee1;
    public static User currentUser1;

    @FXML
    private void onActionLog() {
        System.out.println(loginField.getText());
    }
    @FXML
    private void onActionPass() {
        System.out.println(passwordField.getText());
    }

    @FXML
    private void onActionEnter() {
        Parent root = null;
        Stage stage = new Stage();

        //оскільки, залежно від посади будуть відкриватися різні вікна,
        //зберігаємо посаду користувача, якщо він існує, в окрему змінну
        Position position = ServiceUtil.getUserService().isUser(loginField.getText(), passwordField.getText());

        //якщо користувача з введеним логіном і паролем не існує,
        //даємо 5 спроб ввести коректні дані
        if (position == null) {
            try {
                root = FXMLLoader.load(getClass().getResource("/view/accessDenied.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage.getModality();
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/view/adminWindow.css");
            stage.setScene(scene);
            stage.setTitle("Login error");
            stage.show();
            stage.setResizable(false);
            loginField.clear();
            passwordField.clear();
            --counter;
            if (counter <= 0) {
                System.exit(0);
            }
            return;
        } else {

            currentUser1 = ServiceUtil.getUserService().getCurrentUser(loginField.getText(), passwordField.getText());
            currentEmployee1 = currentUser1.getEmployee();

            switch (position) {
                case ROOT: //ROOT - єдиний користувач з супердоступом (існує лише в одному екземплярі)
                    try {
                        root = FXMLLoader.load(getClass().getResource("/view/heisenberg.fxml"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Scene scene = new Scene(root);
                    stage.setTitle("Admin window");
                    scene.getStylesheets().add("/view/adminWindow.css");
                    stage.setScene(scene);
                    stage.show();
                    stage.setResizable(false);
                    GraphicsLoader.closeWindow(enterButton);
                    break;
                case ADMIN:
                    try {
                        root = FXMLLoader.load(getClass().getResource("/view/adminWindow.fxml"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    scene = new Scene(root);
                    stage.setTitle("Admin window");
                    scene.getStylesheets().add("/view/adminWindow.css");
                    stage.setScene(scene);
                    stage.show();
                    stage.setResizable(false);
                    GraphicsLoader.closeWindow(enterButton);
                    break;
                case MANAGER:
                    try {
                       managerLogin = loginField.getText();
                        root = FXMLLoader.load(getClass().getResource("/view/managerWindow2.fxml"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    scene = new Scene(root);
                    stage.setTitle("Manager window");
                    scene.getStylesheets().add("/view/adminWindow.css");
                    stage.setScene(scene);
                    stage.show();
                    stage.setResizable(false);
                    GraphicsLoader.closeWindow(enterButton);
                    break;
                case CASHIER:
                    try {
                        root = FXMLLoader.load(getClass().getResource("/view/cashierWindow.fxml"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    scene = new Scene(root);
                    stage.setTitle("Cashier window");
                    scene.getStylesheets().add("/view/sellerWindow.css");
                    stage.setScene(scene);
                    stage.show();
                    stage.setResizable(false);
                    GraphicsLoader.closeWindow(enterButton);
                    break;
                case STOREKEEPER:
                    try {
                        root = FXMLLoader.load(getClass().getResource("/view/storekeeperWindow.fxml"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    scene = new Scene(root);
                    stage.setTitle("Storekeeper window");
                    scene.getStylesheets().add("/view/sellerWindow.css");
                    stage.setScene(scene);
                    stage.show();
                    stage.setResizable(false);
                    GraphicsLoader.closeWindow(enterButton);
                    break;
            }
        }
    }
    @FXML
    private void onActionCancel() {
        System.exit(0);
    }
    @FXML
    private void onKeyEntered() {
        onActionEnter();
    }
}
