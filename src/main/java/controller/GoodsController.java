package controller;

import entity.Goods;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by dmitry on 15.02.17.
 */
public class GoodsController {
    @FXML
    ListView goodsList;
    @FXML
    Button btnAddGoods;
    @FXML
    Button btnClose;
    @FXML
    TextField fldGoodsName;
    @FXML
    TextField fldGoodsPrice;
    @FXML
    CheckBox statusCheckY;
    @FXML
    CheckBox statusCheckN;


    @FXML
    private void onActionAddGoods(){
       /* Goods goods = new Goods(fldGoodsName.getText(), fldGoodsPrice.getText());
        ListView<Goods> goodsListView = */

    }
    @FXML
    private void onActionClose(){
        GraphicsLoader.closeWindow(btnClose);
    }

    @FXML
    private void onActionEnterGoods() {

    }
    @FXML
    private void onActionY() {
        if (statusCheckY.isSelected()){
            statusCheckN.setSelected(false);
        }
    }
    @FXML
    private void onActionN() {
        if (statusCheckN.isSelected()){
            statusCheckY.setSelected(false);
        }
    }
}
