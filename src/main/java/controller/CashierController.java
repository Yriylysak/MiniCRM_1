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
import javafx.stage.Stage;
import util.DaoUtil;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CashierController {
    @FXML private TextField fldId;
    @FXML private TextField fldManager;
    @FXML private TextField fldClient;
    @FXML private TextField fldDate;
    @FXML private TextField fldAmount;
    @FXML private TextField fldPrice;
    @FXML private DatePicker datePickerEnd;
    @FXML private CheckBox checkBoxPaid;
    @FXML private CheckBox checkBoxCanceled;
    @FXML private ComboBox<OrderStatus> cmbBoxStatus;

    @FXML private Button btnCloseWin;
    @FXML private ListView orderingsList;

    private ObservableList<Ordering> orderingObservableList;
    private ObservableList<Ordering> unpaidOrdering;
    private Ordering currentOrder;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @FXML
    public void initialize() {
        unpaidOrdering = FXCollections.observableArrayList();
        cmbBoxStatus.setItems(FXCollections.observableArrayList(OrderStatus.values()));
        orderingObservableList = FXCollections.observableArrayList(DaoUtil.getOrderingDao().findAll());
        for (Ordering ord : orderingObservableList) {
            if (ord.getOrderStatus() == OrderStatus.FORMED)
                unpaidOrdering.add(ord);
        }
        orderingsList.setItems(unpaidOrdering);
    }

    //onAction #onMousePressed on ListView
    @FXML
    public void showCashList() {
        if (orderingsList.getSelectionModel().getSelectedItem() != null) {
            currentOrder = (Ordering) orderingsList.getSelectionModel().getSelectedItem();
            fldId.setText(currentOrder.getId().toString());
            fldClient.setText(currentOrder.getClient());
            fldManager.setText(currentOrder.getManager());
            fldDate.setText(currentOrder.getDate().toString());
            cmbBoxStatus.setValue(currentOrder.getOrderStatus());
            datePickerEnd.setValue(LocalDate.parse(currentOrder.getDateEnd(), formatter));
            fldAmount.setText(currentOrder.getAmount().toString());
            fldPrice.setText(currentOrder.getSumm().toString());
        }
    }

    @FXML
    public void onActionChangeStatus() {
        if ((orderingsList.getSelectionModel().getSelectedItem() != null) ) {
            currentOrder = (Ordering) orderingsList.getSelectionModel().getSelectedItem();
            if (cmbBoxStatus.getValue() == OrderStatus.CANCELED
                    || cmbBoxStatus.getValue() == OrderStatus.PAID_UP) {
                System.out.println("++++++++++++++++++  " + cmbBoxStatus.getValue());
                currentOrder.setOrderStatus(OrderStatus.CANCELED);
                System.out.println("--------------------------  " + DaoUtil.getOrderingDao().update(currentOrder));
                initialize();
            }
            if ( cmbBoxStatus.getValue() == OrderStatus.PAID_UP) {
                System.out.println("++++++++++++++++++  " + cmbBoxStatus.getValue());
                currentOrder.setManager(fldManager.getText());
                currentOrder.setOrderStatus(OrderStatus.PAID_UP);
                System.out.println("--------------------------  " + DaoUtil.getOrderingDao().update(currentOrder));
                initialize();
            }
        }
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

    @FXML
    public void onActionPaidOrder() {
        if (checkBoxPaid.isSelected()
                && (orderingsList.getSelectionModel().getSelectedItem() != null) ) {

            checkBoxCanceled.setSelected(false);
            currentOrder = (Ordering) orderingsList.getSelectionModel().getSelectedItem();
            currentOrder.setOrderStatus(OrderStatus.PAID_UP);
            System.out.println("---------------------------" + DaoUtil.getOrderingDao().update(currentOrder));
            initialize();
        }
    }

    @FXML
    public void onActionCanceledOrder() {
        if (checkBoxCanceled.isSelected()
                && (orderingsList.getSelectionModel().getSelectedItem() != null)) {

            checkBoxPaid.setSelected(false);
            currentOrder = (Ordering) orderingsList.getSelectionModel().getSelectedItem();
            currentOrder.setOrderStatus(OrderStatus.CANCELED);
            DaoUtil.getOrderingDao().update(currentOrder);
            initialize();
        }
    }
}
