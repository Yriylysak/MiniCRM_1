package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by dmitry on 21.02.17.
 */
public class StoreKeeperController {
    @FXML
    ChoiceBox orderBox;
    @FXML
    ListView goodsInOrderList;
    @FXML
    ListView goodsInStoreList;
    @FXML
    Button btnEscape;
    @FXML
    Button btnFormOrder;
    @FXML
    Button btnFormPart;

    //Формирование заказа(btnFormOrder)
    @FXML
    private void onActionFormOrder(){
    }

    //Неполное формирование заказа(btnFormPart)
    @FXML
    private void onActionFormPart(){
    }

    //Метод для клика мышкой по товарам из выбранного заказа(goodsInStoreList)
    @FXML
    private void onMousePressedGoodsInOrder() {
    }

    //Метод для клика мышкой по товарам из склада(goodsInStoreList)
    @FXML
    private void onMousePressedGoodsInStore() {
    }

    //Метод для вызова списка заказов(orderBox)
    @FXML
    private void onMousePressedOrderList(){
    }

    //Выход к окну авторизации
    @FXML
    private void onActionEsc() {
        GraphicsLoader.closeWindow(btnEscape);
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
