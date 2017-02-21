package controller;

import entity.Client;
import entity.Employee;
import entity.Goods;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import util.ServiceUtil;

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
    Button btnDelGoods;
    @FXML
    TextField fldGoodsName;
    @FXML
    TextField fldGoodsPrice;
    @FXML
    CheckBox statusCheckY;
    @FXML
    CheckBox statusCheckN;
    @FXML
    TextField fldNum;


    private ObservableList<Goods> goodsObservableList;
    private Goods currentGoods;


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
            fldNum.setText(currentGoods.getAmount().toString());
        } else if (goodsList.getSelectionModel().getSelectedItems() == null) {
            System.out.println("___________ELSE____________");
            fldGoodsName.clear();
            fldGoodsPrice.clear();
            ManagerController.managerController.parent.initialize();
        }
    }
    @FXML
    private void onActionAddGoods(){
        if (fldGoodsName.getText() != ""
                && fldGoodsPrice.getText() != "") {
            Goods goods = new Goods(fldGoodsName.getText(), Double.parseDouble(fldGoodsPrice.getText()),
                    Integer.parseInt(fldNum.getText()));
            ServiceUtil.getGoodsService().add(goods);
        }
        goodsObservableList = FXCollections.observableArrayList(ServiceUtil.getGoodsService().findAll());
        goodsList.setItems(goodsObservableList);
        fldGoodsName.clear();
        fldGoodsPrice.clear();
        fldNum.clear();

    }

    @FXML
    private void onActionEnterGoods() {
        Goods goods = new Goods(fldGoodsName.getText(), Double.parseDouble(fldGoodsPrice.getText()),
                (Integer.parseInt(fldNum.getText())));
        ServiceUtil.getGoodsService().changeGoods(currentGoods, goods);
        goodsObservableList = FXCollections.observableArrayList(ServiceUtil.getGoodsService().findAll());
        goodsList.refresh();
        goodsList.setItems(goodsObservableList);
        fldGoodsName.clear();
        fldGoodsPrice.clear();
        fldNum.clear();
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
    @FXML
    private void onActionDelGoods() {
        currentGoods = (Goods) goodsList.getSelectionModel().getSelectedItem();
        ServiceUtil.getGoodsService().delete(currentGoods.getId());

        goodsList.refresh();
        fldGoodsName.clear();
        fldGoodsPrice.clear();
        fldNum.clear();
        initialize();

       // managerController.initialize();
       // fxmlLoader.getController();

    }





}
