package controller;

import dao.ClientDao;
import dao.ClientDaoImpl;
import entity.Client;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import util.ServiceUtil;


/**
 * Created by dmitry on 15.02.17.
 */
public class CreateClientController {
    @FXML
    TextField fldName;
    @FXML
    TextField fldSurname;
    @FXML
    TextField fldClientAge;
    @FXML
    TextField fldClientPhone;
    @FXML
    TextField fldClientMail;
    @FXML
    ListView clientList;
    @FXML
    Button btnAdd;
    @FXML
    Button btnCancelAdd;
    @FXML
    Button btnGetClient;
    @FXML
    Button btnDelClient;

    public static Client currentClient;

    private ObservableList<Client> clientObservableList;

    public static boolean isOpenWindowClient;


    public void initialize() {
        clientObservableList = FXCollections.observableArrayList(ServiceUtil.getClientService().findAll());
        clientList.setItems(clientObservableList);
    }

    @FXML
    private void onActionAdd() {
        Client client = new Client();
        client.setName(fldName.getText());
        client.setSureName(fldSurname.getText());
        client.setAge(fldClientAge.getText());
        client.setPhone(fldClientPhone.getText());
        client.setEmail(fldClientMail.getText());
        // clientService.add(client);
        ClientDao clientDao = new ClientDaoImpl();
        clientDao.create(client);
        initialize();
        clientList.refresh();

//        ListView<Client> clientListView = (ListView<Client>) clientService.findAll();
    }
    @FXML
    private void onActionCancelAdd(){
        GraphicsLoader.closeWindow(btnCancelAdd);
    }
    // по кнопке выбрать
    @FXML
    private void onActionGetClient(){
        //currentClient = (Client) clientList.getSelectionModel().getSelectedItem();

        /*ClientService clientService = new ClientServiceImpl();
        ListView<Client> clientListView = (ListView<Client>) clientService.findAll();
        currentClient = (Client) clientListView.getSelectionModel().getSelectedItem();*/
        // currentClient = new ClientServiceImpl();
        /*ManagerController managerController = new ManagerController();
        managerController.clientField.setText(currentClient.getName());*/
        // showClientList();

        GraphicsLoader.closeWindow(btnGetClient);
    }
   // по мышке
    @FXML
    private void showClientList() {
        //if (clientList.getSelectionModel().getSelectedItem() != null) {
        if(true) {
            //clientObservableList = FXCollections.observableArrayList (ServiceUtil.getClientService().findAll());
            currentClient = (Client) clientList.getSelectionModel().getSelectedItem();
            //clientList.setItems(clientObservableList);
            isOpenWindowClient = true;
        }
    }
    @FXML
    private void onActionDelClient() {
        ServiceUtil.getClientService().delete(currentClient.getId());
        initialize();

    }
}
