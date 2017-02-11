package controller;

import entity.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import service.EmployeeService;
import service.EmployeeServiceImpl;


/**
 * Created by Yura on 05.02.2017.
 */
public class AdminController implements EventHandler{
    @FXML  private ListView baseInfoList;
    @FXML  private TextField nameField;
    @FXML  private TextField surnameField;
    @FXML  private TextField ageField;
    @FXML  private TextField sexField;
    @FXML  private TextField positionField;
    @FXML  private TextField registryField;
    @FXML  private Button CreateButton;
    @FXML  private Button ChenButton;
    @FXML  private Button DelButton;
    @FXML  private Button GenButton;
    @FXML  private CheckBox accountStatus;

    private Employee currentEmployee;

    private EmployeeService employeeService = new EmployeeServiceImpl();
    private ObservableList<Employee> employeeObservableList;

    @FXML
    private void onActionCreate() {

        // employeeObservableList = FXCollections.observableArrayList(employeeService.findAll());
        //EmplViewHandler viewHandler = new EmplViewHandler(nameField, surnameField, ageField, sexField, positionField, employeeObservableList);
        Employee employee = new Employee(nameField.getText(), surnameField.getText(),
                (Integer.parseInt(ageField.getText())), sexField.getText(), positionField.getText());
        employeeService.add(employee);
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
    @FXML
    private void onActionChen() {
    }
    @FXML
    private void onActionDel() {

        currentEmployee =(Employee) baseInfoList.getSelectionModel().getSelectedItem();
        employeeService = new EmployeeServiceImpl();

        employeeService.delete(currentEmployee.getId());
        System.out.println("dell");
        initialize();

    }
    @FXML
    private void onActionGen() {
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
    public void initialize()
    {
        employeeObservableList = FXCollections.observableArrayList(employeeService.findAll());
        baseInfoList.setItems(employeeObservableList);
        System.out.println("99999999");


    }

    public void showListView() {

            currentEmployee =(Employee) baseInfoList.getSelectionModel().getSelectedItem();
            nameField.setText(currentEmployee.getName());
            surnameField.setText(currentEmployee.getSureName());
            ageField.setText(""+currentEmployee.getAge());
            sexField.setText(currentEmployee.getSex());
            positionField.setText(currentEmployee.getPosition());
            registryField.setText(""+currentEmployee.getDate());
            //11

    }
}
