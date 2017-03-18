package controller;

import entity.Employee;
import entity.User;
import enumTypes.Gender;
import enumTypes.Position;
import util.ServiceUtil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminController {
    @FXML public ListView baseInfoList;
    @FXML private TextField nameField;
    @FXML private TextField surnameField;
    @FXML private TextField ageField;
    @FXML private ComboBox<Position> positionBox;
    @FXML private ComboBox<Gender> sexBox;

    @FXML private Button btnAdminLogOut;
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

    @FXML
    public void initialize() {
        baseInfoList.setItems(hideWW());
        btnEmpl.setSelected(true);
        sexBox.setPromptText("Выбрать");
        sexBox.setItems(FXCollections.observableArrayList(Gender.values()));
        positionBox.setPromptText("Выбрать");
        positionBox.setItems(FXCollections.observableArrayList(Position.values()));
    }
    /* method creates Employee */
    @FXML
    private void onActionCreate() {
        try {
            Integer.parseInt(ageField.getText());
        } catch (NumberFormatException e) {
            ageField.clear();
            return;
        }
        if (nameField.getText() != ""
                && surnameField.getText() != ""
                && ageField.getText() != ""
                && sexBox.getValue() != null
                && positionBox.getValue() != null
                && positionBox.getValue() != Position.ROOT) {

            ServiceUtil.getEmployeeService()
                    .add(new Employee(nameField.getText(), surnameField.getText(),
                    (Integer.parseInt(ageField.getText())),
                    sexBox.getValue(), positionBox.getValue()));
        }

        baseInfoList.setItems(hideWW());
        nameField.clear();
        surnameField.clear();
        sexBox.setPromptText("Выбрать");
        ageField.clear();
        positionBox.setPromptText("Выбрать");

    }

    /*method changes current Employee */
    @FXML
    private void onActionChen() {
        try {
            Integer.parseInt(ageField.getText());
        } catch (NumberFormatException e) {
            ageField.clear();
            return;
        }
        if (nameField.getText() != ""
                && surnameField.getText() != ""
                && ageField.getText() != ""
                && sexBox.getValue() != null
                && positionBox.getValue() != null
                && positionBox.getValue() != Position.ROOT) {

            currentEmployee.setName(nameField.getText());
            currentEmployee.setSurname(surnameField.getText());
            currentEmployee.setGender(sexBox.getValue());
            currentEmployee.setAge(Integer.parseInt(ageField.getText()));
            currentEmployee.setPosition(positionBox.getValue());
            ServiceUtil.getEmployeeService().changeEmployee(currentEmployee);
            baseInfoList.setItems(hideWW());
        }
    }

    /*method deletes current Employee */
    @FXML
    private void onActionDel() {
        if (baseInfoList.getSelectionModel().getSelectedItem() != null) {
            currentEmployee = (Employee) baseInfoList.getSelectionModel().getSelectedItem();
            ServiceUtil.getUserService().delete(ServiceUtil.getUserService().findUser(currentEmployee));
            ServiceUtil.getEmployeeService().delete(currentEmployee.getId());
            baseInfoList.setItems(hideWW());
            nameField.clear();
            surnameField.clear();
            sexBox.setPromptText("Выбрать");
            positionBox.setPromptText("Выбрать");
            ageField.clear();
            initialize();
        }
    }

    /*method creates User for current Employee*/
    @FXML
    private void onActionGen() {
        if (baseInfoList.getSelectionModel().getSelectedItem() != null) {
            currentEmployee = (Employee) baseInfoList.getSelectionModel().getSelectedItem();
            if (currentEmployee.getUser() != null) {
                currentUser = currentEmployee.getUser();
                currentUser.setPassword(ServiceUtil.getUserService().createPassword());
                ServiceUtil.getUserService().update(currentUser);
            } else {
                currentUser = ServiceUtil.getUserService().createUser(currentEmployee);
            }

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
    }
    /*method shows info of a current Employee, when mouse was pressed*/
    public void showListView() {
        if(baseInfoList.getSelectionModel().getSelectedItem() != null) {
            if (btnUsers.isSelected()) {
                showListViewUsers();
            } else {
                currentEmployee = (Employee) baseInfoList.getSelectionModel().getSelectedItem();
                nameField.setText(currentEmployee.getName());
                surnameField.setText(currentEmployee.getSurname());
                ageField.setText("" + currentEmployee.getAge());
                sexBox.setValue(currentEmployee.getGender());
                positionBox.setValue(currentEmployee.getPosition());
                registryField.setText("" + currentEmployee.getDate());
                accountStatus.setSelected(ServiceUtil.getUserService().findUser(currentEmployee) != null);

                if (ServiceUtil.getUserService().findUser(currentEmployee) != null) {
                    GenButton.setText("Новый пароль");
                } else {
                    GenButton.setText("Сгенерировать");
                }
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
    /*method shows info of a current User, when mouse was pressed*/
    public void showListViewUsers() {
        if (baseInfoList.getSelectionModel().getSelectedItem() != null) {
            currentUser = (User) baseInfoList.getSelectionModel().getSelectedItem();
            nameField.setText(currentUser.getEmployee().getName());
            surnameField.setText(currentUser.getEmployee().getSurname());
            ageField.setText("" + currentUser.getEmployee().getAge());
            sexBox.setValue(currentUser.getEmployee().getGender());
            positionBox.setValue(currentUser.getEmployee().getPosition());
            registryField.setText("" + currentUser.getEmployee().getDate());
            accountStatus.setSelected(ServiceUtil.getUserService().findUser(currentEmployee) != null);
            GenButton.setDisable(ServiceUtil.getUserService().findUser(currentEmployee) != null);
        }
    }
    /*When method shows info of a current Employee
      * this method unblocks Employees control-buttons*/
    @FXML
    private void onActionShowEmpl() {
        if(btnEmpl.isSelected()) {
            btnUsers.setSelected(false);
            CreateButton.setDisable(false);
            ChenButton.setDisable(false);
            DelButton.setDisable(false);
            GenButton.setDisable(false);
            baseInfoList.setItems(hideWW());
        }
    }
    /*When method showListViewUsers() shows info of a current User
     * this method blocks Employees control-buttons*/
    @FXML
    private void onActionShowUsers() {
        btnEmpl.setSelected(false);
        CreateButton.setDisable(true);
        ChenButton.setDisable(true);
        DelButton.setDisable(true);
        GenButton.setDisable(true);
        baseInfoList.setItems(hideHeisenberg());
    }
    @FXML
    private void onActionAdminLogOut() {
        GraphicsLoader.closeWindow(btnAdminLogOut);
        Parent root = null;
        Stage primaryStage = new Stage();
        try {
            root = FXMLLoader.load(getClass().getResource("/view/enterWindow.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        primaryStage.setTitle("Авторизация");
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/view/enterWindow.css");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    //Heisenberg - суперкористувач, тому робимо його невидимим для інших
    private ObservableList<Employee> hideWW () {
        employeeObservableList = FXCollections.observableArrayList(ServiceUtil.getEmployeeService().findAll());
        for (Employee employee : employeeObservableList) {
            if (employee.getName().equals("Walter") && employee.getSurname().equals("White")
                    && employee.getUser().getLogin().equals("Heisenberg")) {
                employeeObservableList.remove(employee);
                break;
            }
        }
        return employeeObservableList;
    }
    private ObservableList<User> hideHeisenberg () {
        userObservableList = FXCollections.observableArrayList(ServiceUtil.getUserService().findAll());
        for (User user : userObservableList) {
            if (user.getLogin().equals("Heisenberg")) {
                userObservableList.remove(user);
                break;
            }
        }
        return userObservableList;
    }
}
