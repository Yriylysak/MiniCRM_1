package controller;

import entity.Client;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import service.ClientServiceImpl;
import util.ApplicationContextFactory;
import util.ServiceUtil;

import static controller.ManagerController.currentGoods;

public class CreateClientController {
    @FXML TextField fldName;
    @FXML TextField fldSurname;
    @FXML TextField fldClientAge;
    @FXML TextField fldClientPhone;
    @FXML TextField fldClientMail;
    @FXML ListView clientList;
    @FXML Button btnAdd;
    @FXML Button btnCancelAdd;
    @FXML Button btnEditClient;
    @FXML Button btnDelClient;

    public static Client currentClient;
    public static boolean isOpenWindowClient;

    private ObservableList<Client> clientObservableList;
    private ClientServiceImpl clientService;

    public void initialize() {
        clientService = ApplicationContextFactory.getApplicationContext()
                .getBean("clientService", ClientServiceImpl.class);
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

        clientService.add(client);
        initialize();
        clientList.refresh();
        fldName.clear();
        fldSurname.clear();
        fldClientAge.clear();
        fldClientPhone.clear();
        fldClientMail.clear();

//        ListView<Client> clientListView = (ListView<Client>) clientService.findAll();
    }
    @FXML
    private void onActionCancelAdd(){
        GraphicsLoader.closeWindow(btnCancelAdd);
    }
   // по мышке
    @FXML
    private void showClientList() {
        if (clientList.getSelectionModel().getSelectedItem() != null) {
            currentClient = (Client) clientList.getSelectionModel().getSelectedItem();
            isOpenWindowClient = true;
            fldName.setText(currentClient.getName());
            fldSurname.setText(currentClient.getSureName());
            fldClientAge.setText(currentClient.getAge());
            fldClientPhone.setText(currentClient.getPhone());
            fldClientMail.setText(currentClient.getEmail());
        }
    }
    @FXML
    private void onActionDelClient() {
        ServiceUtil.getClientService().delete(currentClient.getId());
        initialize();
        fldName.clear();
        fldSurname.clear();
        fldClientAge.clear();
        fldClientPhone.clear();
        fldClientMail.clear();
    }
    @FXML
    private void onActionEditClient() {
        Client client = new Client(fldName.getText(), fldSurname.getText(),
        fldClientAge.getText(), fldClientPhone.getText(), fldClientMail.getText());
        ServiceUtil.getClientService().changeClient(currentClient, client);
        clientObservableList = FXCollections.observableArrayList(ServiceUtil.getClientService().findAll());
        clientList.refresh();
        clientList.setItems(clientObservableList);
        fldName.clear();
        fldSurname.clear();
        fldClientAge.clear();
        fldClientPhone.clear();
        fldClientMail.clear();
    }
}
