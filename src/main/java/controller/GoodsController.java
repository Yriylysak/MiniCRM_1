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
            fldGoodsName.clear();
            fldGoodsPrice.clear();
        }
        //тут контроллер падає, тому я закоментувала рядок нижче
        //ManagerController.managerController.parent.initialize();
    }
    //додаємо товари у базу даних
    @FXML
    private void onActionAddGoods() {
        //якщо у поле ціни чи кількості введені некоректні дані,
        // поля очищуються
        try {
            Double.parseDouble(fldGoodsPrice.getText());
        } catch (NumberFormatException e) {
            fldGoodsPrice.clear();
            return;
        }
        try {
            Integer.parseInt(fldNum.getText());
        } catch (NumberFormatException e) {
            fldNum.clear();
            return;
        }

        if (fldGoodsName.getText() != ""
                && fldGoodsPrice.getText() != ""
                && fldNum.getText() != "") {
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
    private void onActionDelGoods() {
        currentGoods = (Goods) goodsList.getSelectionModel().getSelectedItem();
        ServiceUtil.getGoodsService().delete(currentGoods.getId());

        goodsList.refresh();
        fldGoodsName.clear();
        fldGoodsPrice.clear();
        fldNum.clear();
    }
}
