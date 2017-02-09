package controller;

import entity.Employer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import service.EmployerService;
import service.EmployerServiceImpl;

/**
 * Created by Yura on 09.02.2017.
 */
public class createEmpoyeeController
{
    //

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
    private Button createEmplButton;

    @FXML
    private Button cancelButton;



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

    public void onActionCreateEmpl(ActionEvent actionEvent)
    {
        if(nameField.getText()!=""&&surnameField.getText()!=""&&ageField.getText()!=""&&sexField.getText()!=""&&positionField.getText()!="")
        {
            Employer employer = new Employer(nameField.getText(), surnameField.getText(), Integer.parseInt(ageField.getText()), sexField.getText(), positionField.getText());

            EmployerService employerService = new EmployerServiceImpl();

            employerService.add(employer);
        }



    }

    public void onActionCancelEmpl(ActionEvent actionEvent) {
    }
}
