package controller;

import entity.Client;
import entity.Goods;
import entity.GoodsInOrder;
import entity.Order;
import enumTypes.OrderStatus;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import util.ServiceUtil;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.Date;
import java.util.List;

/**
 * Created by Comfy on 05.02.2017.
 */
public class ManagerController {
    @FXML TextField numberFld;
    @FXML TextField managerFld;
    @FXML TextField dateFld;
    @FXML TextField goodNumFld;
    @FXML TextField priceFld;
    @FXML DatePicker termFld;
    @FXML TextField clientField;
    @FXML Button btnNewClient;
    @FXML Button btnNewOrder;
    @FXML Button btnRef;

    @FXML TableView tabView;
    @FXML TableColumn<Goods, Long> columnNumber;
    @FXML TableColumn<Goods, String> columnName;
    @FXML TableColumn<Goods, Integer> columnNmbr;
    @FXML TableColumn<Goods, Double> columnPrice;
    @FXML TableColumn<Goods, Double> columnSum;


    @FXML AnchorPane anchorPane;

    @FXML ListView<GoodsInOrder> listViewGoods;

    @FXML private ComboBox<OrderStatus> combobox;
    @FXML Button btnEdit;
    @FXML Button btnForm;
    @FXML Button btnGood;
    @FXML Button btnLogOut;
    @FXML ListView orderList;
    @FXML ListView goodsList;
    @FXML ListView clientList;
    @FXML Tab tabOrders;
    @FXML Tab tabGoods;
    @FXML Tab tabClient;
    public static ManagerController managerController;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private ObservableList<Order> orderObservableList = FXCollections.observableArrayList();
    private ObservableList<Client> clientObservableList;
    private ObservableList<Goods> goodsObservableList;
    private ObservableList<Goods> kvasolka = FXCollections.observableArrayList();
    private ObservableList<GoodsInOrder> currentGoodsObservableList= FXCollections.observableArrayList();

    public static String managerLogin;
    private String tmp = managerLogin.toString();

    public static GoodsInOrder currentGoodsInOrder;
    public static Goods currentGoods;
    public static Client currentClient;
    public static Order currentOrder;
    private Date currentDate;
    private Date dedlineDate;
    private Long count;



    private ManagerController children;  // Ссылка на контроллер поражаемой формы
    ManagerController parent;     // Ссылка на родительский контроллер (если таковой есть для данной формы)

    public ManagerController getChildren() {
        return children;
    }
    public ManagerController getParent() {
        return parent;
    }
    public void setChildren(ManagerController children) {
        this.children = children;
    }
    public void setParent(ManagerController parent) {
        this.parent = parent;
    }

    @FXML
    private void onActionAddGood(){
        Parent root = null;
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        try {
            root = FXMLLoader.load(getClass().getResource("/view/goodsWindow.fxml"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/view/goodsWindow.css");
        stage.setScene(scene);
        stage.setTitle("Создание товара");
        stage.show();
        stage.setResizable(false);
        children = loader.getController();  // Теперь текущий контроллер "знает" о существовании "потомка"
        children.setParent(this);                // А теперь и "потомок" знает своего "отца"
        System.out.println("ONE");
    }

    public void initialize() {
        managerFld.setText(tmp);

        clientObservableList = FXCollections.observableArrayList(ServiceUtil.getClientService().findAll());
        clientList.setItems(clientObservableList);

        //orderObservableList = FXCollections.observableArrayList(ServiceUtil.getOrderService().findAll());
        orderList.setItems(clientObservableList);

        goodsObservableList = FXCollections.observableArrayList(ServiceUtil.getGoodsService().findAll());
        goodsList.setItems(goodsObservableList);

        numberFld.setText("123456"); //замінити на:
        //numberFld.setText(currentOrder.getId());

        dateFld.setText(LocalDate.now().format(formatter));
        combobox.setPromptText("Выбрать");
        combobox.setItems(FXCollections.observableArrayList(OrderStatus.values()));
        termFld.setConverter(new StringConverter<LocalDate>() {
            @Override
            public String toString(LocalDate localDate) {
                if(localDate == null || localDate.isBefore(LocalDate.now())) return "";
                else return localDate.format(formatter);
            }

            @Override
            public LocalDate fromString(String dateString) {
                if(dateString == null || dateString.trim().isEmpty()) return null;
                else return LocalDate.parse(dateString, formatter);
            }
        });
    }


    @FXML
    private void onActionNewClient() {
        Parent root = null;
        Stage stage = new Stage();
        try {
            root = FXMLLoader.load(getClass().getResource("/view/createClient.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/view/managerWindow.css");
        stage.setScene(scene);
        stage.setTitle("Создание клиента");
        stage.show();
        stage.setResizable(false);
    }

    @FXML
    private void onActionForm(){
        //Order order1 = new Order(combobox.getValue(), managerLogin);
        //ServiceUtil.getOrderService().add(order1);

        Double summ = 0.0;
        Integer amount = 0;
        for (GoodsInOrder gio : currentGoodsObservableList) {
            summ += gio.getAmount() * gio.getPrice();
            amount +=gio.getAmount();
        }
        priceFld.setText(summ.toString());
        goodNumFld.setText(amount.toString());

        /* очистка всіх полів після сформування замовлення
        numberFld.clear();
        managerFld.clear();
        dateFld.clear();
        priceFld.clear();
        clientField.clear();
        currentGoodsObservableList.clear();
        listViewGoods.setItems(null);
        */
    }

    @FXML
    public void onMousePressedOrders() {
       // if(orderList.getSelectionModel().getSelectedItem() != null) {
        currentClient = (Client) clientList.getSelectionModel().getSelectedItem();
        clientField.setText(currentClient.getName() + " " + currentClient.getSureName());
        /*setText() to text fields*/
       // }
       // initialize();
    }
    @FXML
    public void onMousePressedGoods() {
        //if(goodsList.getSelectionModel().getSelectedItem() != null) {
            currentGoods = (Goods) goodsList.getSelectionModel().getSelectedItem();
       // }
       // initialize();
    }

    //дії по кліку мишки на вкладці Клієнти
    @FXML
    public void onMousePressedClients() {
        //if(clientList.getSelectionModel().getSelectedItem() != null) {
            currentClient = (Client) clientList.getSelectionModel().getSelectedItem();
            clientField.setText(currentClient.getName() + " " + currentClient.getSureName());
       // }
       // initialize();
    }
    @FXML
    private void onActionAddGoods() {

        currentGoods = (Goods) goodsList.getSelectionModel().getSelectedItem();
        // currentGoodsInOrder = new GoodsInOrder(currentGoods, 1);
        //currentGoodsObservableList.add(currentGoodsInOrder);
        kvasolka.add(currentGoods);


        //columnNumber.setCellValueFactory(p -> new ReadOnlyObjectWrapper(goodsList.getItems().indexOf(p.getValue()) + 1 + ""));
        columnNumber.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        columnNmbr.setCellValueFactory(new PropertyValueFactory<>("amount"));
        columnPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        String priceSum = ""+(currentGoods.getPrice()*1.2);
        //columnSum.setCellValueFactory(p -> new ReadOnlyObjectWrapper(currentGoods.getPrice()*1.2));
        //columnSum.setCellValueFactory(currentGoods.getPrice()*1.2));


        tabView.setItems(kvasolka);






        //listViewGoods.setItems(currentGoods.getProductName());



        // columnName.setText(currentGoods.getProductName());

    }
    @FXML
    private void onActionEdit(){
        priceFld.clear();
        clientField.clear();
        currentGoodsObservableList.clear();
        listViewGoods.setItems(null);
    }
    @FXML
    private void onActionBtnLogOut() {
        GraphicsLoader.closeWindow(btnLogOut);
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

    @FXML
    private void onActionNewOrder() {
    }
    @FXML
    private void onActionRef() {
        initialize();

    }


}
