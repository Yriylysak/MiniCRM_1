package controller;

import entity.Client;
import entity.Goods;
import entity.GoodsInOrder;
import entity.Order;
import enumTypes.OrderStatus;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
    @FXML TextField goodNumFld;
    @FXML TextField priceFld;
    @FXML DatePicker termFld;
    @FXML TextField clientField;
    @FXML Button btnNewClient;

    @FXML ListView<GoodsInOrder> listViewGoods;

    @FXML private ComboBox<OrderStatus> combobox;
    @FXML Button btnClean;
    @FXML Button btnForm;
    @FXML Button btnGood;
    @FXML Button btnLogOut;
    @FXML ListView orderList;
    @FXML ListView goodsList;
    @FXML ListView clientList;
    @FXML Tab tabOrders;
    @FXML Tab tabGoods;
    @FXML Tab tabClient;


    private ObservableList<Order> orderObservableList = FXCollections.observableArrayList();
    private ObservableList<Client> clientObservableList;
    private ObservableList<Goods> goodsObservableList;
    private ObservableList<GoodsInOrder> currentGoodsObservableList= FXCollections.observableArrayList();

    public static String managerLogin;
    private String tmp = managerLogin.toString();

    public static GoodsInOrder currentGoodsInOrder;
    public static Goods currentGoods;
    public static Client currentClient;
    public static Order currentOrder;
    private Date currentDate = new Date();

    public void initialize() {
        managerFld.setText(tmp);

        clientObservableList = FXCollections.observableArrayList(ServiceUtil.getClientService().findAll());
        clientList.setItems(clientObservableList);

        //orderObservableList = FXCollections.observableArrayList(ServiceUtil.getOrderService().findAll());
        orderList.setItems(clientObservableList);

        goodsObservableList = FXCollections.observableArrayList(ServiceUtil.getGoodsService().findAll());
        goodsList.setItems(goodsObservableList);

        numberFld.setText("123456"); //замінити на:
        //numberFld.setText(currentOrder.getId());

        dateFld.setText("" + currentDate.getDate() + ".0" + (currentDate.getMonth() + 1) + "." + (currentDate.getYear() + 1900));
        combobox.setPromptText("Выбрать");
        combobox.setItems(FXCollections.observableArrayList(OrderStatus.values()));
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
    private void onActionForm(){
        //Order order1 = new Order(combobox.getValue(), managerLogin);
        //ServiceUtil.getOrderService().add(order1);

        Double summ = 0.0;
        Integer amount = 0;
        for (GoodsInOrder gio : currentGoodsObservableList) {
            summ += gio.getAmount() * gio.getPrice();
            amount +=gio.getAmount();
        }
        priceFld.setText(summ.toString());
        goodNumFld.setText(amount.toString());

        /* очистка всіх полів після сформування замовлення
        numberFld.clear();
        managerFld.clear();
        dateFld.clear();
        priceFld.clear();
        clientField.clear();
        currentGoodsObservableList.clear();
        listViewGoods.setItems(null);
        */
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
        currentOrder = (Order) orderList.getSelectionModel().getSelectedItem();
        /*setText() to text fields*/
    }
    @FXML
    public void onMousePressedGoods() {
        currentGoods = (Goods) goodsList.getSelectionModel().getSelectedItem();
    }

    //дії по кліку мишки на вкладці Клієнти
    @FXML
    public void onMousePressedClients() {
        currentClient = (Client) clientList.getSelectionModel().getSelectedItem();
        clientField.setText(currentClient.getName() + " "+ currentClient.getSureName());
    }
    @FXML
    private void onActionAddGoods() {
        currentGoods = (Goods) goodsList.getSelectionModel().getSelectedItem();
        currentGoodsInOrder = new GoodsInOrder(currentGoods, 1);
        currentGoodsObservableList.add(currentGoodsInOrder);

        listViewGoods.setItems(currentGoodsObservableList);

        // columnName.setText(currentGoods.getProductName());

    }
    @FXML
    private void onActionClean(){
        numberFld.clear();
        managerFld.clear();
        dateFld.clear();
        priceFld.clear();
        clientField.clear();
        currentGoodsObservableList.clear();
        listViewGoods.setItems(null);
    }
    @FXML
    private void onActionBtnLogOut() {
        GraphicsLoader.closeWindow(btnLogOut);
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
