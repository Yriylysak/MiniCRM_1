package controller;

import entity.Ordering;
import enumTypes.OrderStatus;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import util.DaoUtil;
import java.io.IOException;

/**
 * Created by dmitry on 16.02.17.
 */
public class CashierController {

    // commit window1

    @FXML private TextField cashnumberFld;
    @FXML private TextField cashmanagerFld;
    @FXML private TextField cashdateFld;
    @FXML private TextField cashgoodNumFld;
    @FXML private TextField cashpriceFld;
    @FXML private DatePicker cahstermFld;
    @FXML private TextField cashclientField;
    @FXML private CheckBox paidCheck;
    @FXML private CheckBox canceledCheck;

    @FXML private Button btnCloseWin;

    @FXML private ListView orderingsList;


    private ObservableList<Ordering> unpaidOrdering = FXCollections.observableArrayList();

    private Ordering currentOrder;

    private ObservableList<Ordering> orderingObservableList;

    @FXML
    public void initialize() {

        ObservableList<Ordering> allOrdering = FXCollections.observableArrayList(DaoUtil.getOrderingDao().findAll());
        for (Ordering ord : allOrdering) {
            if (ord.getOrderStatus() == OrderStatus.NEW)
                unpaidOrdering.add(ord);
        }
        orderingsList.setItems(unpaidOrdering);
    }

        //orderObservableList = FXCollections.observableArrayList(ServiceUtil.getOrderService().findAll());
       /* for (Order order : orderObservableList) {
            if (order.getStatus() == OrderStatus.FORMED) {
                unpaidOrderObservableList.add(order);
            }
        }*/

       //ordersListView.setItems(unpaidOrdering);


    public void showCashList(MouseEvent mouseEvent) {
    }

    @FXML
    public void onActionClose() {
        GraphicsLoader.closeWindow(btnCloseWin);
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

    public void onActionPaid() {
        if (paidCheck.isSelected()
                && (orderingsList.getSelectionModel().getSelectedItem() != null) ) {

            canceledCheck.setSelected(false);
            currentOrder = (Ordering) orderingsList.getSelectionModel().getSelectedItem();
            currentOrder.setOrderStatus(OrderStatus.PAID_UP);
            DaoUtil.getOrderingDao().update(currentOrder);
        }
    }

    public void onActionCanceled() {
        if (canceledCheck.isSelected()
                && (orderingsList.getSelectionModel().getSelectedItem() != null)) {

            paidCheck.setSelected(false);
            currentOrder = (Ordering) orderingsList.getSelectionModel().getSelectedItem();
            currentOrder.setOrderStatus(OrderStatus.CANCELED);
            DaoUtil.getOrderingDao().update(currentOrder);
        }
    }
}
