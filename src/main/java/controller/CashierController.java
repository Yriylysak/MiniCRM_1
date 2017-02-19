package controller;

import entity.Order;
import enumTypes.OrderStatus;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import util.ServiceUtil;

/**
 * Created by dmitry on 16.02.17.
 */
public class CashierController {
    @FXML private TextField cashnumberFld;
    @FXML private TextField cashmanagerFld;
    @FXML private TextField cashdateFld;
    @FXML private TextField cashgoodNumFld;
    @FXML private TextField cashpriceFld;
    @FXML private DatePicker cahstermFld;
    @FXML private TextField cashclientField;
    @FXML private CheckBox paidCheck;
    @FXML private CheckBox canceledCheck;
    @FXML private ListView ordersListView;
    @FXML private Button btnCloseWin;

    private ObservableList<Order> orderObservableList;
    private ObservableList<Order> unpaidOrderObservableList ;
    private Order currentOrder;

    @FXML
    public void initialize() {

        //orderObservableList = FXCollections.observableArrayList(ServiceUtil.getOrderService().findAll());
       /* for (Order order : orderObservableList) {
            if (order.getStatus() == OrderStatus.FORMED) {
                unpaidOrderObservableList.add(order);
            }
        }*/
        //ordersListView.setItems(orderObservableList);

    }

    public void showCashList(MouseEvent mouseEvent) {
    }

    @FXML
    public void onActionClose() {
        GraphicsLoader.closeWindow(btnCloseWin);
    }

    public void onActionPaid() {
        if (paidCheck.isSelected()){
            canceledCheck.setSelected(false);
            currentOrder = (Order) ordersListView.getSelectionModel().getSelectedItem();
            Order newOrder = currentOrder;
            newOrder.setOrderStatus(OrderStatus.PAID_UP);
            ServiceUtil.getOrderService().changeOrder(currentOrder, newOrder);
        }
    }

    public void onActionCanceled() {
        if (canceledCheck.isSelected()){
            paidCheck.setSelected(false);
            currentOrder = (Order) ordersListView.getSelectionModel().getSelectedItem();
            Order newOrder = currentOrder;
            newOrder.setOrderStatus(OrderStatus.CANCELED);
            ServiceUtil.getOrderService().changeOrder(currentOrder, newOrder);
        }
    }
}
