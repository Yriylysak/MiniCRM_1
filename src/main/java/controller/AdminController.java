package controller;

import entity.Employee;
import entity.User;
import enumTypes.Gender;
import enumTypes.Position;
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
    @FXML public ListView baseInfoList;
    @FXML private TextField nameField;
    @FXML private TextField surnameField;
    @FXML private TextField ageField;
    @FXML private ComboBox<Position> positionBox;
    @FXML private ComboBox<Gender> sexBox;

    @FXML private TextField registryField;
    @FXML private Button CreateButton;
    @FXML private Button ChenButton;
    @FXML private Button DelButton;
    @FXML private Button GenButton;
    @FXML private CheckBox accountStatus;
    @FXML private RadioButton btnEmpl;
    @FXML private RadioButton btnUsers;

    public static Employee currentEmployee;
    public static User currentUser;

    private ObservableList<Employee> employeeObservableList;
    private ObservableList<User> userObservableList;
    private ObservableList<Position> positionsObservableList;
    private ObservableList<Gender> gendersObservableList;



    @FXML
    private void onActionCreate() {
        if (nameField.getText() != "" && surnameField.getText() != "" && ageField.getText() != ""
                && sexBox.getValue() != null && positionBox.getValue() != null) {
            // employeeObservableList = FXCollections.observableArrayList(employeeService.findAll());
            //EmplViewHandler viewHandler = new EmplViewHandler(nameField, surnameField, ageField, sexField, positionField, employeeObservableList);
            Employee employee = new Employee(nameField.getText(), surnameField.getText(),
                    (Integer.parseInt(ageField.getText())), sexBox.getValue(), positionBox.getValue());

            ServiceUtil.getEmployeeService().add(employee);
        }
        employeeObservableList = FXCollections.observableArrayList(ServiceUtil.getEmployeeService().findAll());

        baseInfoList.setItems(employeeObservableList);
        nameField.clear();
        surnameField.clear();
        sexBox.setPromptText("Выбрать");
        ageField.clear();
        positionBox.setPromptText("Выбрать");
    }

    /*method changes current Employee */
    @FXML
    private void onActionChen() {
        Employee employee = new Employee(nameField.getText(), surnameField.getText(),
                (Integer.parseInt(ageField.getText())), sexBox.getValue(), positionBox.getValue());

        ServiceUtil.getEmployeeService().changeEmployer(currentEmployee, employee);
        employeeObservableList = FXCollections.observableArrayList(ServiceUtil.getEmployeeService().findAll());
        baseInfoList.refresh();
        baseInfoList.setItems(employeeObservableList);
    }

    @FXML
    private void onActionDel() {
        currentEmployee = (Employee) baseInfoList.getSelectionModel().getSelectedItem();
        ServiceUtil.getUserService().delete(ServiceUtil.getUserService().findUser(currentEmployee));
        ServiceUtil.getEmployeeService().delete(currentEmployee.getId());
        baseInfoList.refresh();
        employeeObservableList = FXCollections.observableList(ServiceUtil.getEmployeeService().findAll());

        nameField.clear();
        surnameField.clear();
        sexBox.setPromptText("Выбрать");

        positionBox.setPromptText("Выбрать");

        ageField.clear();

        initialize();
    }

    @FXML
    private void onActionGen() {
        currentEmployee = (Employee) baseInfoList.getSelectionModel().getSelectedItem();
        currentUser = ServiceUtil.getUserService().createUser(currentEmployee);
        ServiceUtil.getUserService().add(currentUser);
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
        sexBox.setValue(employee.getSex());
        positionBox.setValue(employee.getPosition());
    }

    @FXML
    public void initialize() {
        employeeObservableList = FXCollections.observableArrayList(ServiceUtil.getEmployeeService().findAll());
        baseInfoList.setItems(employeeObservableList);
        btnEmpl.setSelected(true);
        sexBox.setPromptText("Выбрать");
        sexBox.setItems(FXCollections.observableArrayList(Gender.values()));
        positionBox.setPromptText("Выбрать");
        positionBox.setItems(FXCollections.observableArrayList(Position.values()));
    }

    public void showListView() {
        if(baseInfoList.getSelectionModel().getSelectedItem()!= null) {
            if (btnUsers.isSelected()) {
                showListViewUsers();
            } else {
                currentEmployee = (Employee) baseInfoList.getSelectionModel().getSelectedItem();
                nameField.setText(currentEmployee.getName());
                surnameField.setText(currentEmployee.getSureName());
                ageField.setText("" + currentEmployee.getAge());
                sexBox.setValue(currentEmployee.getSex());
                positionBox.setValue(currentEmployee.getPosition());
                registryField.setText("" + currentEmployee.getDate());
                accountStatus.setSelected(ServiceUtil.getUserService().findUser(currentEmployee) != null);
            }
        }
        if (baseInfoList.getSelectionModel().getSelectedItems() == null) {
            nameField.clear();
            surnameField.clear();
            sexBox.setPromptText("Выбрать");

            positionBox.setPromptText("Выбрать");
            ageField.clear();

            registryField.clear();
            accountStatus.setSelected(false);
        }
    }

    public void showListViewUsers() {
        currentUser = (User) baseInfoList.getSelectionModel().getSelectedItem();
        nameField.setText(currentUser.getEmployee().getName());
        surnameField.setText(currentUser.getEmployee().getSureName());
        ageField.setText(""+currentUser.getEmployee().getAge());
        sexBox.setValue(currentUser.getEmployee().getSex());
        positionBox.setValue(currentUser.getEmployee().getPosition());
        registryField.setText(""+currentUser.getEmployee().getDate());
        accountStatus.setSelected(ServiceUtil.getUserService().findUser(currentEmployee)!= null);
    }

    @FXML
    private void onActionShowEmpl() {
        if(btnEmpl.isSelected()) {
            btnUsers.setSelected(false);
            CreateButton.setDisable(false);
            ChenButton.setDisable(false);
            DelButton.setDisable(false);
            GenButton.setDisable(false);
            employeeObservableList = FXCollections.observableArrayList(ServiceUtil.getEmployeeService().findAll());
            baseInfoList.setItems(employeeObservableList);
        }
    }

    @FXML
    private void onActionShowUsers() {
        btnEmpl.setSelected(false);
        CreateButton.setDisable(true);
        ChenButton.setDisable(true);
        DelButton.setDisable(true);
        GenButton.setDisable(true);
        userObservableList = FXCollections.observableArrayList(ServiceUtil.getUserService().findAll());
        baseInfoList.setItems(userObservableList);
    }
}
