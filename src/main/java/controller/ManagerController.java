package controller;

import entity.Order;
import enumTypes.OrderStatus;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import service.ClientService;
import util.ServiceUtil;

import java.io.IOException;
import java.util.Date;

/**
 * Created by Comfy on 05.02.2017.
 */
public class ManagerController {
    @FXML TextField numberFld;
    @FXML TextField managerFld;
    @FXML TextField dateFld;
    @FXML TextField priceFld;
    @FXML DatePicker termFld;
    @FXML TextField clientField;
    @FXML Button btnNewClient;
    @FXML TableColumn columnNumber;
    @FXML TableColumn columnName;
    @FXML TableColumn columnNmbr;
    @FXML TableColumn columnPrice;
    @FXML TableColumn columnSum;
    @FXML TableColumn columnPriceNDS;
    @FXML TableColumn columnSumNDS;
    @FXML private ComboBox<OrderStatus> combobox;
    @FXML Button btnClean;
    @FXML Button btnForm;
    @FXML Button btnGood;
    @FXML ListView managerGoodsList;
    private ObservableList<Order> clientObservableList;

    private Date currentDate = new Date();
    public void initialize(){
//        Order order = new Order();
//        ServiceUtil.getOrderService().add(order);
//        clientObservableList = FXCollections.observableArrayList(ServiceUtil.getOrderService().findAll());

//        numberFld.setText(""+order.getId());
        dateFld.setText("" + currentDate.getDate() + ".0" + (currentDate.getMonth()+ 1) + "." + (currentDate.getYear()+1900));
        combobox.setPromptText("Выбрать");
        combobox.setItems(FXCollections.observableArrayList(OrderStatus.values()));
        CreateClientController createClientController = new CreateClientController();

    }
    @FXML
    private void onActionNewClient() {
        Parent root = null;
        Stage stage = new Stage();
        try {
            root = FXMLLoader.load(getClass().getResource("/view/createClient.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/view/managerWindow.css");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }
    @FXML
    private void onActionClean(){

    }
    @FXML
    private void onActionForm(){

    }
    @FXML
    private void onActionAddGood(){
        Parent root = null;
        Stage stage = new Stage();

        try {
            root = FXMLLoader.load(getClass().getResource("/view/goodsWindow.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/view/goodsWindow.css");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }
}
