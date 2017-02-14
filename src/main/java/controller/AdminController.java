package controller;

import entity.Employee;
import entity.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import service.EmployeeService;
import service.EmployeeServiceImpl;
import service.UserService;
import service.UserServiceImpl;
import util.ServiceUtil;

import java.io.IOException;


/**
 * Created by Yura on 05.02.2017.
 */
public class AdminController implements EventHandler {
    // Commit 1.0
    @FXML
    public ListView baseInfoList;
    @FXML
    private TextField nameField;
    @FXML
    private TextField surnameField;
    @FXML
    private TextField ageField;
    @FXML
    private TextField sexField;
    @FXML
    private TextField positionField;
    @FXML
    private TextField registryField;
    @FXML
    private Button CreateButton;
    @FXML
    private Button ChenButton;
    @FXML
    private Button DelButton;
    @FXML
    private Button GenButton;
    @FXML
    private CheckBox accountStatus;
    @FXML
    private RadioButton btnEmpl;
    @FXML
    private RadioButton btnUsers;


    public static Employee currentEmployee;
    public static User currentUser;

    private EmployeeService employeeService = new EmployeeServiceImpl();
    private ObservableList<Employee> employeeObservableList;
    private UserService userService = new UserServiceImpl();
    private ObservableList<User> userObservableList;

    @FXML
    private void onActionCreate() {
//        if (nameField.getText() != "" && surnameField.getText() != ""&&ageField.getText()!=""
//                && (Integer.parseInt(ageField.getText())) > 0
//                && sexField.getText() != ""
//                && positionField.getText() != "") {
            if (true){

            // employeeObservableList = FXCollections.observableArrayList(employeeService.findAll());
            //EmplViewHandler viewHandler = new EmplViewHandler(nameField, surnameField, ageField, sexField, positionField, employeeObservableList);
            Employee employee = new Employee(nameField.getText(), surnameField.getText(),
                    (Integer.parseInt(ageField.getText())), sexField.getText(), positionField.getText());

            employeeService.add(employee);
        }

            employeeObservableList = FXCollections.observableArrayList(employeeService.findAll());

            baseInfoList.setItems(employeeObservableList);
            nameField.clear();
            surnameField.clear();
            sexField.clear();
            ageField.clear();
            positionField.clear();


            // baseInfoList.refresh();


            // Employee employer1 = new Employee(nameField.getText(), surnameField.getText(), (Integer.parseInt(ageField.getText())), sexField.getText(), positionField.getText());
            // employeeService.add(employer1);
            // baseInfoList.setItems(employeeObservableList);


    }

    /*method changes current Employee */
    @FXML
    private void onActionChen() {
        Employee employee = new Employee(nameField.getText(), surnameField.getText(),
                (Integer.parseInt(ageField.getText())), sexField.getText(), positionField.getText());

        ServiceUtil.getEmployeeService().changeEmployer(currentEmployee, employee);

        employeeObservableList = FXCollections.observableArrayList(employeeService.findAll());
        baseInfoList.refresh();
        baseInfoList.setItems(employeeObservableList);

    }

    @FXML
    private void onActionDel() {

        currentEmployee = (Employee) baseInfoList.getSelectionModel().getSelectedItem();
        employeeService = new EmployeeServiceImpl();

        userService.delete(userService.findUser(currentEmployee));
        employeeService.delete(currentEmployee.getId());
        baseInfoList.refresh();
        employeeObservableList = FXCollections.observableList(employeeService.findAll());

        nameField.clear();
        surnameField.clear();
        sexField.clear();
        ageField.clear();
        positionField.clear();
        System.out.println("dell");
        initialize();

    }

    @FXML
    private void onActionGen() {
        currentEmployee = (Employee) baseInfoList.getSelectionModel().getSelectedItem();
        employeeService = new EmployeeServiceImpl();
        currentUser = userService.createUser(currentEmployee);
        //userService = new UserServiceImpl();
        userService.add(currentUser);

        //System.out.println(currentUser.getLogin());

        Parent root = null;
        Stage stage = new Stage();

        try {
            root = FXMLLoader.load(getClass().getResource("/view/generateWindow.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/view/adminWindow.css");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }

    /*поки не працює*/
    @Override
    public void handle(Event event) {
        EmployeeService employeeService = new EmployeeServiceImpl();
        ListView<Employee> employerListView = (ListView<Employee>) employeeService.findAll();

        Employee employee = employerListView.getSelectionModel().getSelectedItem();
        nameField.setText(employee.getName());
        surnameField.setText(employee.getSureName());
        ageField.setText(Integer.toString(employee.getAge()));
        sexField.setText(employee.getSex());
        positionField.setText(employee.getPosition());

    }

    @FXML
    public void initialize() {
        employeeObservableList = FXCollections.observableArrayList(employeeService.findAll());
        baseInfoList.setItems(employeeObservableList);
        System.out.println("99999999");
        btnEmpl.setSelected(true);
    }

    public void showListView() {
        if(baseInfoList.getSelectionModel().getSelectedItem()!= null) {
            if (btnUsers.isSelected()){
                showListViewUsers();
            }else {
                currentEmployee = (Employee) baseInfoList.getSelectionModel().getSelectedItem();
                nameField.setText(currentEmployee.getName());
                surnameField.setText(currentEmployee.getSureName());
                ageField.setText("" + currentEmployee.getAge());
                sexField.setText(currentEmployee.getSex());
                positionField.setText(currentEmployee.getPosition());
                registryField.setText("" + currentEmployee.getDate());
                accountStatus.setSelected(userService.findUser(currentEmployee) != null);
            }
        }
        if (baseInfoList.getSelectionModel().getSelectedItems()==null){
            nameField.clear();
            surnameField.clear();
            sexField.clear();
            ageField.clear();
            positionField.clear();
            registryField.clear();
            accountStatus.setSelected(false);
        }
    }

    public void showListViewUsers(){
        currentUser = (User) baseInfoList.getSelectionModel().getSelectedItem();
        nameField.setText(currentUser.getEmployee().getName());
        surnameField.setText(currentUser.getEmployee().getSureName());
        ageField.setText(""+currentUser.getEmployee().getAge());
        sexField.setText(currentUser.getEmployee().getSex());
        positionField.setText(currentUser.getEmployee().getPosition());
        registryField.setText(""+currentUser.getEmployee().getDate());
        accountStatus.setSelected(userService.findUser(currentEmployee)!= null);
    }

    @FXML
    private void onActionShowEmpl(){

        if(btnEmpl.isSelected()){
            btnUsers.setSelected(false);
            CreateButton.setDisable(false);
            ChenButton.setDisable(false);
            DelButton.setDisable(false);
            GenButton.setDisable(false);
            employeeObservableList = FXCollections.observableArrayList(employeeService.findAll());
            baseInfoList.setItems(employeeObservableList);
        }

    }

    @FXML
    private void onActionShowUsers(){
            btnEmpl.setSelected(false);
            CreateButton.setDisable(true);
            ChenButton.setDisable(true);
            DelButton.setDisable(true);
            GenButton.setDisable(true);
            userObservableList = FXCollections.observableArrayList(userService.findAll());
            baseInfoList.setItems(userObservableList);




    }
}
