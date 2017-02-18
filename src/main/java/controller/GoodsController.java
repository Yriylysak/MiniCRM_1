package controller;

import entity.Goods;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import util.ServiceUtil;

import java.io.IOException;

import static controller.ManagerController.managerFld;

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
    private ObservableList<Goods> goodsObservableList;

    public static Goods currentGoods;

    public GoodsController() {
    }

    public Goods getCurrentGoods() {
        return currentGoods;
    }

    @FXML
    public void initialize() {
        goodsObservableList = FXCollections.observableArrayList(ServiceUtil.getGoodsService().findAll());
        goodsList.setItems(goodsObservableList);
    }
    @FXML
    private void showGoodsList() {
        if (goodsList.getSelectionModel().getSelectedItem() != null) {
            currentGoods = (Goods) goodsList.getSelectionModel().getSelectedItem();
            fldGoodsName.setText(currentGoods.getProductName());
            fldGoodsPrice.setText(currentGoods.getPrice().toString());
        } else if (goodsList.getSelectionModel().getSelectedItems() == null) {
            fldGoodsName.clear();
            fldGoodsPrice.clear();
        }
    }
    @FXML
    private void onActionAddGoods(){
        if (fldGoodsName.getText() != ""
                && fldGoodsPrice.getText() != "") {
            Goods goods = new Goods(fldGoodsName.getText(), Double.parseDouble(fldGoodsPrice.getText()));
            ServiceUtil.getGoodsService().add(goods);
        }
        goodsObservableList = FXCollections.observableArrayList(ServiceUtil.getGoodsService().findAll());
        goodsList.setItems(goodsObservableList);
        fldGoodsName.clear();
        fldGoodsPrice.clear();
    }
    @FXML
    private void onActionClose(){
        GraphicsLoader.closeWindow(btnClose);
    }

    //if it will work...
    @FXML
    private void onActionEnterGoods() {
        currentGoods = (Goods) goodsList.getSelectionModel().getSelectedItem();

        managerFld.setText("+++");
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
