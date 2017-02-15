package controller;

import entity.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import util.ServiceUtil;

/**
 * Created by Yura on 09.02.2017.
 */
public class CreateEmpoyeeController {
    @FXML private TextField nameField;
    @FXML private TextField surnameField;
    @FXML private TextField ageField;
    @FXML private TextField sexField;
    @FXML private TextField positionField;
    @FXML private Button createEmplButton;
    @FXML private Button cancelButton;

    public void onActionName(ActionEvent actionEvent) {
    }
    public void onActionSurname(ActionEvent actionEvent) {
    }
    public void onActionAge(ActionEvent actionEvent) {
    }
    public void onActionSex(ActionEvent actionEvent) {
    }
    public void onActionPosition(ActionEvent actionEvent) {
    }
    public void onActionCreateEmpl(ActionEvent actionEvent) {
        if (nameField.getText() != ""
                && surnameField.getText() != ""
                && ageField.getText() != ""
                && sexField.getText() != ""
                && positionField.getText() != "") {
            Employee employee = new Employee(nameField.getText(), surnameField.getText(),
                    Integer.parseInt(ageField.getText()), sexField.getText(),
                    positionField.getText());
            ServiceUtil.getEmployeeService().add(employee);
        }
    }
    public void onActionCancelEmpl(ActionEvent actionEvent) {
    }
}
