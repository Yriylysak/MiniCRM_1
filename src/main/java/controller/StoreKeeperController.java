package controller;
import entity.Client;
import entity.Goods;
import entity.Order;
import entity.Ordering;
import enumTypes.OrderStatus;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import util.DaoUtil;
import util.ServiceUtil;
import javafx.scene.control.TableView;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.sql.Date;


import java.io.IOException;

/**
 * Created by dmitry on 21.02.17.
 */
public class StoreKeeperController {

    @FXML
    public TableView tableInOrder;
    @FXML
    public TableView tableOrdering;

    @FXML
    ListView goodsInOrderList;

    @FXML
    Button btnEscape;
    @FXML
    Button btnFormOrder;
    @FXML
    Button btnFormPart;
    @FXML
    Button btnDelForm;
    @FXML
    Button btnEditForm;
    @FXML
    Button btnDelStore;
    @FXML
    Button btnEditStore;
    @FXML
    Button btnAddStore;


     @FXML TableColumn<Client, Long> numberCLm;
     @FXML TableColumn<Client, String> nameClm;
     @FXML TableColumn<Client, String> sureNameClm;

    @FXML TableColumn<Ordering, Long> OrderNumberClm;
    @FXML TableColumn<Ordering, Date> orderDataClm;
    @FXML TableColumn<Ordering, Date> orderDataDedlineClm ;
    @FXML TableColumn<Ordering, String> orderManagerClm;


    private ObservableList<Ordering> orderingObservableList = FXCollections.observableArrayList();


    @FXML
    public void initialize() {
        ObservableList<Ordering> allOrdering = FXCollections.observableArrayList(DaoUtil.getOrderingDao().findAll());
        for (Ordering ord : allOrdering) {
            if (ord.getOrderStatus() == OrderStatus.NEW)
            orderingObservableList.add(ord);
        }

        OrderNumberClm.setCellValueFactory(new PropertyValueFactory<Ordering, Long>("id"));
        orderDataClm.setCellValueFactory(new PropertyValueFactory<Ordering, Date>("date"));
        orderDataDedlineClm.setCellValueFactory(new PropertyValueFactory<Ordering, Date>("dateEnd"));
        orderManagerClm.setCellValueFactory(new PropertyValueFactory<Ordering, String>("manager"));
        tableOrdering.setItems(orderingObservableList);

    }

    // Формирование заказа(btnFormOrder)
    @FXML
    private void onActionFormOrder() {

    /*
        if (orderList.getSelectionModel().getSelectedItem() != null) {
            currentOrdering = (Ordering) orderList.getSelectionModel().getSelectedItem();

            currentOrdering.setOrderStatus(OrderStatus.FORMED);
            DaoUtil.getOrderingDao().update(currentOrdering);
            }
            */

    }

    // Неполное формирование заказа(btnFormPart)
    @FXML
    private void onActionFormPart() {
        /*if (orderList.getSelectionModel().getSelectedItem() != null) {
            currentOrdering = (Ordering) orderList.getSelectionModel().getSelectedItem();

            currentOrdering.setOrderStatus(OrderStatus.RETURNED);
            DaoUtil.getOrderingDao().update(currentOrdering);
        }
        */
    }

    // Метод для клика мышкой по товарам из выбранного заказа(goodsInStoreList)
    @FXML
    private void onMousePressedGoodsInOrder() {



    }

    // Метод для клика мышкой по товарам из склада(goodsInStoreList)
    @FXML
    private void onMousePressedGoodsInStore() {
    //   ObservableList<Client> currentClientList = FXCollections.observableArrayList();
    //   currentClient1 = (Client) goodsInOrderList.getSelectionModel().getSelectedItem();
    //   currentClientList.add(currentClient1);

    //   numberCLm.setCellValueFactory(new PropertyValueFactory<Client, Long>("id"));
    //   nameClm.setCellValueFactory(new PropertyValueFactory<Client, String>("name"));
    //   sureNameClm.setCellValueFactory(new PropertyValueFactory<Client, String>("sureName"));

    //   tableInOrder.setItems(currentClientList);
    }

    // Метод для вызова списка заказов(orderBox)
    @FXML
    private void onMousePressedOrderList(){

    }

    // Выход к окну авторизации
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

    // Удаление товара из заказа
    @FXML
    private void onActionDelForm() {
    }

    // Изменение товара в заказе
    @FXML
    private void onActionEditForm(){
    }

    // Изменение товара на складе
    @FXML
    private void onActionEditStore() {
    }

    // Удаление товара со склада
    @FXML
    private void onActionDelStore(){
    }

    // Добавление товара в список товаров
    @FXML
    private void onActionAddStore(){
    }

    public void enterOwnCabinet(ActionEvent event) {
        Parent root = null;
        Stage stage = new Stage();

        try {

            root = FXMLLoader.load(getClass().getResource("/view/myProfileWindow.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        stage.setTitle("My profile");
        scene.getStylesheets().add("/view/adminWindow.css");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);

    }
//
    public void oderGetItems(MouseEvent mouseEvent) {
    }

    public void onActionAddGood(ActionEvent event) {
        Parent root = null;
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
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

        /* сім"я падає. від щастя?
        // Теперь текущий контроллер "знает" о существовании "потомка"
        children = loader.getController();
        // А теперь и "потомок" знает своего "отца"
        // і вони сім"я !!
        children.setParent(this);
        System.out.println("ONE"); //хто знає для чого тут цей рядок - напишіть
        */
    }
}
