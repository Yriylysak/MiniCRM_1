package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

/**
 * Created by dmitry on 16.02.17.
 */
public class CashierController {
    @FXML
    TextField cashnumberFld;
    @FXML
    TextField cashmanagerFld;
    @FXML
    TextField cashdateFld;
    @FXML
    TextField cashgoodNumFld;
    @FXML
    TextField cashpriceFld;
    @FXML
    DatePicker cahstermFld;
    @FXML
    TextField cashclientField;
    @FXML
    CheckBox paidCheck;
    @FXML
    CheckBox canceledCheck;
    @FXML
    ListView cashGoodsList;
    @FXML
    Button btnCloseWin;

    public void showCashList(MouseEvent mouseEvent) {
    }


    @FXML
    public void onActionClose() {
        GraphicsLoader.closeWindow(btnCloseWin);
    }

    public void onActionPaid() {
        if (paidCheck.isSelected()){
            canceledCheck.setSelected(false);
        }
    }

    public void onActionCanceled() {
        if (canceledCheck.isSelected()){
            paidCheck.setSelected(false);
        }
    }
}
