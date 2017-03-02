package controller;

import entity.*;
import enumTypes.OrderStatus;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;
import util.DaoUtil;
import util.ServiceUtil;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by julia on 05.02.2017.
 */
public class ManagerController {
    @FXML TextField numberFld;
    @FXML TextField managerFld;
    @FXML TextField dateFld;
    @FXML TextField goodNumFld;
    @FXML TextField priceFld;
    @FXML TextField clientField;
    @FXML DatePicker termFld;
    @FXML TextField fldDiscount;
    @FXML TextField fldAmount;
    @FXML ComboBox<OrderStatus> combobox;

    @FXML TableView tabView;
    @FXML TableColumn<GoodsInOrder, Long> columnID;
    @FXML TableColumn<GoodsInOrder, String> columnName;
    @FXML TableColumn<GoodsInOrder, Integer> columnAmount;
    @FXML TableColumn<GoodsInOrder, Integer> columnAmountEnable;
    @FXML TableColumn<GoodsInOrder, Double> columnPrice;
    @FXML TableColumn<GoodsInOrder, Double> columnNDS;
    @FXML TableColumn<GoodsInOrder, Double> columnPriceNDS;

    @FXML AnchorPane anchorPane;

    @FXML Button btnNewOrder;
    @FXML Button btnEdit;
    @FXML Button btnForm;
    @FXML Button btnAddManagGood;
    @FXML Button btnNewClient;
    @FXML Button btnRef;
    @FXML Button btnMyProfile;
    @FXML Button btnLogOut;

    @FXML ListView orderList;
    @FXML ListView goodsList;
    @FXML ListView clientList;
    @FXML Tab tabOrders;
    @FXML Tab tabGoods;
    @FXML Tab tabClient;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private ObservableList<Ordering> orderingObservableList = FXCollections.observableArrayList();;
    private ObservableList<Client> clientObservableList = FXCollections.observableArrayList();;
    private ObservableList<Goods> goodsObservableList = FXCollections.observableArrayList();;
    private ObservableList<Goods> goodsTransient  = FXCollections.observableArrayList();;
    private ObservableList<GoodsInOrder> currentGoodsObservableList = FXCollections.observableArrayList();

    public static String managerLogin;
    public static GoodsInOrder currentGoodsInOrder;
    public static Goods currentGoods;
    public static Client currentClient;
    public static Ordering currentOrdering;

    private ManagerController children;  // Ссылка на контроллер поражаемой формы
    ManagerController parent;     // Ссылка на родительский контроллер (если таковой есть для данной формы)

    public ManagerController() {}
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

    public void initialize() {
        //ініціалізація списків замовлень, товарів і клієнтів у вкладках
        //відображення списку замовлень
       orderingObservableList = FXCollections.observableArrayList(DaoUtil.getOrderingDao().findAll());
        //виклик DAO замінити на Service:
        //orderingObservableList = FXCollections.observableArrayList(ServiceUtil.getOrderingService().findAll());
        orderList.setItems(orderingObservableList);

        //відображення списку клієнтів
        clientObservableList = FXCollections.observableArrayList(ServiceUtil.getClientService().findAll());
        clientList.setItems(clientObservableList);

        //відображення списку товарів
        goodsObservableList = FXCollections.observableArrayList(ServiceUtil.getGoodsService().findAll());
        goodsList.setItems(goodsObservableList);

        //ініціалізація текстових полів
        managerFld.setText(managerLogin);
        clientField.setPromptText("Выбрать");
        dateFld.setText(LocalDate.now().format(formatter));
        combobox.setPromptText("Выбрать");
        //список статусів замовлення, які є перелічуваним типом
        combobox.setItems(FXCollections.observableArrayList(OrderStatus.values()));
        combobox.setValue(OrderStatus.NEW);
        //унеможливлюємо вибір дати виконання замовлення, що передує поточній
        //тобто замовлення "на вчора" не приймаються :)
        termFld.setConverter(new StringConverter<LocalDate>() {
            //а нам точно треба обидва методи?
            @Override
            public String toString(LocalDate localDate) {
                if (localDate == null || localDate.isBefore(LocalDate.now())) return "";
                else return localDate.format(formatter);
            }
            @Override
            public LocalDate fromString(String dateString) {
                if (dateString == null || dateString.trim().isEmpty()) return null;
                else return LocalDate.parse(dateString, formatter);
            }
        });
        //гарно просимо табличку товарів із замовлення, щоб вона редагувалася
        tabView.setEditable(true);
        btnAddManagGood.setDisable(true);
    }
    //дії по кнопці " Добавить товар"
    @FXML
    private void onActionAddGoods() {
        Integer amount;
        btnAddManagGood.setDisable(true);
        fldAmount.setDisable(true);
        if (goodsList.getSelectionModel().getSelectedItem() != null) {
            currentGoods = (Goods) goodsList.getSelectionModel().getSelectedItem();
            try {
                amount = Integer.parseInt(fldAmount.getText());
            } catch (NumberFormatException e) {
                fldAmount.clear();
                return;
            }
            //тимчасовий список товарів, які будуть відображені у таблиці у вікні менеджера
            currentGoodsObservableList.add( new GoodsInOrder(currentGoods, amount, new Ordering()));
            //товари, які при формуванні замовлення ми збережемо у таблицю БД
            goodsTransient.add(currentGoods);

            //присвоєння значень стовпцям таблиці
            columnID.setCellValueFactory(new PropertyValueFactory<>("id"));
            columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
            columnAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));

            //тут встановлюємо можливість редагування стовпців "назва" і "кількість"
            columnName.setCellFactory(TextFieldTableCell.forTableColumn());
            //columnAmount.setCellFactory(TextFieldTableCell.forTableColumn());
            Callback<TableColumn<GoodsInOrder, Integer>, TableCell<GoodsInOrder, Integer>> cellFactoryFor
                    = p -> new TextFieldTableCell(new StringConverter() {
                @Override
                public String toString(Object t) {
                    return t.toString();
                }

                @Override
                public Object fromString(String string) {
                    return string;
                }
            });

            columnAmount.setCellFactory(cellFactoryFor);
            columnAmountEnable.setCellValueFactory(new PropertyValueFactory<>("amountEnable"));
            columnPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
            columnNDS.setCellValueFactory(new PropertyValueFactory<>("nds"));
            columnPriceNDS.setCellValueFactory(new PropertyValueFactory<>("priceNDS"));
            tabView.setItems(currentGoodsObservableList);
        }
    }
    @FXML
    private void onActionForm() {
        //тут вираховується сума за все замовлення
        //але поки що товари у замовлення додаються по одному
        //тому для всіх з GoodsInOrder amount=1
        Double summ = 0.0;
        Integer amount = 0;

        Ordering ordering = new Ordering(managerLogin, clientField.getText(),
                new Date(), termFld.getValue().format(formatter),
                combobox.getValue(), amount, summ);

        priceFld.setText(summ.toString());
        goodNumFld.setText(amount.toString());
        //збeрігаємо у базу
        Long id = DaoUtil.getOrderingDao().create(ordering);
        numberFld.setText(id.toString());
        //numberFld.setText(DaoUtil.getOrderingDao().create(ordering).toString());

        //пізніше замінити на:
        //numberFld.setText(ServiceUtil.getOrd
        //eringService().add(ordering).toString());
        //перебираємо список товарів і зберігаємо їх у таблицю БД
        for (Goods gio : goodsTransient) {
            summ += gio.getAmount() * gio.getPrice();
            amount += gio.getAmount();
            Ordering ord = DaoUtil.getOrderingDao().read(id);
            GoodsInOrder goodsInOrder = new GoodsInOrder(gio, 1, ord);
            goodsInOrder.setOrdering(ord);

            //додаємо товари з замовлення у таблицю БД
            DaoUtil.getGoodsInOrderDao().create(goodsInOrder);
        }
        numberFld.clear();
        clientField.clear();
        //dateFld.setText(LocalDate.now().format(formatter));
        dateFld.setText(LocalDate.now().toString());
        termFld.setValue(LocalDate.now());
        currentGoodsObservableList.clear();
        combobox.setValue(null);
        goodNumFld.clear();
        priceFld.clear();
        tabView.setItems(null);
        btnAddManagGood.setDisable(true);
    }
    //дії по кнопці "редагувати замовлення"
    @FXML
    private void onActionEdit() {
        btnAddManagGood.setDisable(true);
        if (orderList.getSelectionModel().getSelectedItem() != null) {
            currentOrdering = (Ordering) orderList.getSelectionModel().getSelectedItem();

            //заміняємо параметри замовлення на нові
            currentOrdering.setDateEnd(termFld.getValue().format(formatter));
            currentOrdering.setOrderStatus(combobox.getValue());
            currentOrdering.setClient(clientField.getText());
            try {
                currentOrdering.setSumm(Double.parseDouble(priceFld.getText()));
            } catch (NumberFormatException e) {
                System.out.println("----------- Double isn't double ------------");
            }
            try {
                currentOrdering.setAmount(Integer.parseInt(goodNumFld.getText()));
            } catch (NumberFormatException e) {
                System.out.println("----------- Integer isn't int ------------");
            }
            //update замовлення у таблиці бази даних
            DaoUtil.getOrderingDao().update(currentOrdering);

            numberFld.clear();
            goodNumFld.clear();
            priceFld.clear();
            clientField.clear();
            combobox.setValue(null);
            currentGoodsObservableList.clear();
            tabView.setItems(null);
        }
    }
    @FXML
    private void onActionNewOrder() {
        btnAddManagGood.setDisable(true);
        //очищуємо поля для нового замовлення
        numberFld.clear();
        clientField.clear();
        //dateFld.setText(LocalDate.now().format(formatter));
        dateFld.setText(LocalDate.now().toString());
        termFld.setValue(LocalDate.now());
        currentGoodsObservableList.clear();

        combobox.setValue(OrderStatus.NEW);
        tabView.setItems(null);

        goodNumFld.clear();
        priceFld.clear();
    }
    //дії по кліку мишки на вкладці "Замовлення"
    @FXML
    public void onMousePressedOrders() {
        btnAddManagGood.setDisable(true);
        if (orderList.getSelectionModel().getSelectedItem() != null) {
            //поточне замовлення
            currentOrdering = (Ordering) orderList.getSelectionModel().getSelectedItem();
            //id вибраного замовлення
            numberFld.setText(currentOrdering.getId().toString());
            //ім"я менеджера, який приймає замовлення
            // береться з з вікна авторизації
            managerFld.setText(currentOrdering.getManager());
            //ім"я клієнта, який зробив замовлення
            clientField.setText(currentOrdering.getClient());
            //дата, коли було зроблено замовлення
            dateFld.setText(currentOrdering.getDate().toString());
            //дата виконання замовлення
            //думаю, дії з датами якось можна оптимізувати
            termFld.setValue(LocalDate.parse(currentOrdering.getDateEnd(), formatter));
            //ordering status
            combobox.setValue(currentOrdering.getOrderStatus());
            //сума замовлення
            priceFld.setText(currentOrdering.getSumm().toString());
            //к-сть артикулів
            goodNumFld.setText(currentOrdering.getAmount().toString());

        }
    }
    //дії по кліку мишки на вкладці "Товари"
    @FXML
    public void onMousePressedGoods() {
        if (goodsList.getSelectionModel().getSelectedItem() != null) {
            btnAddManagGood.setDisable(false);
            currentGoods = (Goods) goodsList.getSelectionModel().getSelectedItem();
        }
        // initialize();
    }
    //дії по кліку мишки на вкладці "Клієнти"
    @FXML
    public void onMousePressedClients() {
        btnAddManagGood.setDisable(true);
        if (clientList.getSelectionModel().getSelectedItem() != null) {
            currentClient = (Client) clientList.getSelectionModel().getSelectedItem();
            clientField.setText(currentClient.getName() + " " + currentClient.getSureName());
        }
        // initialize();
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
    private void onActionRef() {
        initialize();
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
    private void onActionProfile() {
        Parent root = null;
        Stage primaryStage = new Stage();
        try {
            root = FXMLLoader.load(getClass().getResource("/view/myProfileWindow.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        primaryStage.setTitle("Мой профиль");
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/view/myProfileWindow.css");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
    }
}
