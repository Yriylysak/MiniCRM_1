package controller;

import entity.Employee;import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import static controller.AdminController.currentEmployee;
import static controller.AdminController.currentUser;

/**
 * Created by dmitry on 11.02.17.
 */
public class OkController {
    @FXML
    Label addNameField;
    @FXML
    Label addLoginField;
    @FXML
    Label addPasswordField;
    @FXML
    Button btnOK;
//
    @FXML
    public void initialize() {


       // Employee currentEmployee =(Employee) adminController.baseInfoList.getSelectionModel().getSelectedItem();
        addNameField.setText(currentEmployee.getName());
        addLoginField.setText(currentUser.getLogin());
        addPasswordField.setText(currentUser.getPassword());
        System.out.println(currentEmployee.getName());
    }

    @FXML
    private void onActionOK(){
        GraphicsLoader.closeWindow(btnOK);
    }
}
