package controller;

import entity.Employer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import service.EmployerService;
import service.EmployerServiceImpl;

import java.io.IOException;


/**
 * Created by Yura on 05.02.2017.
 */
public class adminController implements EventHandler{
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

    private EmployerService employerService = new EmployerServiceImpl();
    private ObservableList<Employer> employerObservableList;

    @FXML
    private void onActionCreate() {
        employerObservableList = FXCollections.observableArrayList(employerService.findAll());
        //EmplViewHandler viewHandler = new EmplViewHandler(nameField, surnameField, ageField, sexField, positionField, employerObservableList);
        Employer employer = new Employer(nameField.getText(), surnameField.getText(),
                (Integer.parseInt(ageField.getText())), sexField.getText(), positionField.getText());
        employerService.add(employer);
        baseInfoList.setItems(employerObservableList);
        nameField.clear();
        surnameField.clear();
        sexField.clear();
        ageField.clear();
        positionField.clear();
    }
    @FXML
    private void onActionChen() {
    }
    @FXML
    private void onActionDel() {
    }
    @FXML
    private void onActionGen() {
    }

    /*поки не працює*/
    @Override
    public void handle(Event event) {
        EmployerService employerService = new EmployerServiceImpl();
        ListView<Employer> employerListView = (ListView<Employer>) employerService.findAll();

        Employer employer = employerListView.getSelectionModel().getSelectedItem();
        nameField.setText(employer.getName());
        surnameField.setText(employer.getSureName());
        ageField.setText(Integer.toString(employer.getAge()));
        sexField.setText(employer.getSex());
        positionField.setText(employer.getPosition());
    }
}
