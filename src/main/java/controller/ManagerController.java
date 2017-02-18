package controller;

import entity.Client;
import entity.Goods;
import entity.Order;
import enumTypes.OrderStatus;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
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
    @FXML TableView tabView;
    @FXML TableColumn<Goods, Long> columnNumber;
    @FXML TableColumn<Goods, String> columnName;
    @FXML TableColumn <Goods, Integer>columnNmbr;
    @FXML TableColumn <Goods, Double> columnPrice;
    @FXML TableColumn <Goods, Double>columnSum;
    @FXML TableColumn <Goods, Double>columnPriceNDS;
    @FXML TableColumn <Goods, Double>columnSumNDS;
    @FXML private ComboBox<OrderStatus> combobox;
    @FXML Button btnClean;
    @FXML Button btnForm;
    @FXML Button btnGood;
    @FXML ListView orderList;
    @FXML ListView goodsList;
    @FXML ListView clientList;
    @FXML Tab tabOrders;
    @FXML Tab tabGoods;
    @FXML Tab tabClient;


    private ObservableList<Order> orderObservableList;
    private ObservableList<Client> clientObservableList;
    private ObservableList<Goods> goodsObservableList;

    public static Goods currentGoods;
    public static Client currentClient;
    private Date currentDate = new Date();

    public void initialize() {
//        Order order = new Order();
//        ServiceUtil.getOrderService().add(order);
//        clientObservableList = FXCollections.observableArrayList(ServiceUtil.getOrderService().findAll());

//        numberFld.setText(""+order.getId());

        clientObservableList = FXCollections.observableArrayList(ServiceUtil.getClientService().findAll());
        clientList.setItems(clientObservableList);
        orderObservableList = FXCollections.observableArrayList(ServiceUtil.getOrderService().findAll());
        orderList.setItems(orderObservableList);

        goodsObservableList = FXCollections.observableArrayList(ServiceUtil.getGoodsService().findAll());
        goodsList.setItems(goodsObservableList);

        dateFld.setText("" + currentDate.getDate() + ".0" + (currentDate.getMonth() + 1) + "." + (currentDate.getYear() + 1900));
        combobox.setPromptText("Выбрать");
        combobox.setItems(FXCollections.observableArrayList(OrderStatus.values()));

        CreateClientController createClientController = new CreateClientController();

        columnNumber.setCellValueFactory(new PropertyValueFactory<>("№"));
        columnName.setCellValueFactory(new PropertyValueFactory<>("Наименование"));
        columnNmbr.setCellValueFactory(new PropertyValueFactory<>("количество"));
        columnPrice.setCellValueFactory(new PropertyValueFactory<>("цена без ндс"));
        columnSum.setCellValueFactory(new PropertyValueFactory<>("сумма без ндс"));
        columnPriceNDS.setCellValueFactory(new PropertyValueFactory<>("цена с ндс"));
        columnSumNDS.setCellValueFactory(new PropertyValueFactory<>("сумма с ндс"));







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
        stage.setTitle("Создание клиента");
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
        stage.setTitle("Создание товара");
        stage.show();
        stage.setResizable(false);
    }
    @FXML
    public void onMousePressedOrders() {

    }
    @FXML
    public void onMousePressedGoods() {

        ObservableList<Goods> goodsObservableList;
        goodsObservableList = FXCollections.observableArrayList();
        tabView.setItems(goodsObservableList);
        currentGoods = (Goods) goodsList.getSelectionModel().getSelectedItem();
        tabView.setItems((ObservableList) currentGoods);
        System.out.println("88888888888888888888888888888888");


    }
    @FXML
    public void onMousePressedClients() {
        currentClient = (Client) clientList.getSelectionModel().getSelectedItem();
        clientField.setText(currentClient.getName() + " "+ currentClient.getSureName());
    }
    @FXML
    private void onActionAddGoods() {
        currentGoods = (Goods) goodsList.getSelectionModel().getSelectedItem();
        // columnName.setText(currentGoods.getProductName());









    }
}
