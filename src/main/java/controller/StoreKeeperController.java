package controller;

import entity.GoodsInOrder;
import entity.Ordering;
import enumTypes.OrderStatus;
import service.OrderingServiceImpl;
import util.ApplicationContextFactory;
import util.DaoUtil;

import java.io.IOException;
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
import javafx.scene.control.TableView;
import javafx.stage.Stage;


/**
 * Created by dmitry on 21.02.17.
 */
public class StoreKeeperController {

    @FXML public TableView tblGoodsInOrder;
    @FXML ListView listOrderings;
    @FXML Button btnEscape;
    @FXML Button btnFormOrder;
    @FXML Button btnFormPart;
    @FXML Button btnDelForm;
    @FXML Button btnEditForm;
    @FXML Button btnDelStore;
    @FXML Button btnEditStore;
    @FXML Button btnAddStore;

    @FXML TableColumn<GoodsInOrder, Long> clmId;
    @FXML TableColumn<GoodsInOrder, String> clmName;
    @FXML TableColumn<GoodsInOrder, String> clmAmount;
    @FXML TableColumn<GoodsInOrder, Integer> clmEnableAmount;

    private ObservableList<Ordering> orderingObservableList;
    private ObservableList<GoodsInOrder> currentGoodsObservableList;
    private Ordering currentOrdering;
    private OrderingServiceImpl orderingService;

    @FXML
    public void initialize() {
        orderingService = ApplicationContextFactory.getApplicationContext()
                .getBean("orderingService", OrderingServiceImpl.class);

        orderingObservableList = FXCollections.observableArrayList();
        ObservableList<Ordering> allOrdering = FXCollections.observableArrayList(orderingService.findAll());
        for (Ordering ord : allOrdering) {
            if (ord.getOrderStatus() == OrderStatus.NEW)
            orderingObservableList.add(ord);
        }
        listOrderings.setItems(orderingObservableList);
    }

    // Формирование заказа(btnFormOrder)
    @FXML
    private void onActionFormOrder() {
        if (listOrderings.getSelectionModel().getSelectedItem() != null) {
            currentOrdering = (Ordering) listOrderings.getSelectionModel().getSelectedItem();
            currentOrdering.setOrderStatus(OrderStatus.FORMED);
            orderingService.update(currentOrdering);
            }
    }

    // Неполное формирование заказа(btnFormPart)
    @FXML
    private void onActionReturnOrder() {
        if (listOrderings.getSelectionModel().getSelectedItem() != null) {
            currentOrdering = (Ordering) listOrderings.getSelectionModel().getSelectedItem();
            currentOrdering.setOrderStatus(OrderStatus.RETURNED);
            orderingService.update(currentOrdering);
        }
    }

    // Метод для клика мышкой по товарам из выбранного заказа(goodsInStoreList)
    @FXML
    private void onMousePressedGoodsInOrder() {
        if (listOrderings.getSelectionModel().getSelectedItem() != null) {
            currentOrdering = (Ordering) listOrderings.getSelectionModel().getSelectedItem();
            currentGoodsObservableList = FXCollections.observableArrayList(DaoUtil.getGoodsInOrderDao().findAll());

            ObservableList<GoodsInOrder> tempGoods = FXCollections.observableArrayList();
            for (GoodsInOrder gio : currentGoodsObservableList) {
                if (gio.getOrdering().getId() == currentOrdering.getId()) {
                    tempGoods.add(gio);
                }
            }
            clmId.setCellValueFactory(new PropertyValueFactory<>("id"));
            clmName.setCellValueFactory(new PropertyValueFactory<>("name"));
            clmAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
            clmEnableAmount.setCellValueFactory(new PropertyValueFactory<>("amountEnable"));
            tblGoodsInOrder.setItems(tempGoods);
        }
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

    // Изменение товара на складе
    @FXML
    private void onActionEditStore() {}

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
    }
}
