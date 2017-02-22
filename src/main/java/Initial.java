import entity.Client;
import entity.Employee;
import entity.Order;
import entity.User;
import enumTypes.Gender;
import enumTypes.OrderStatus;
import enumTypes.Position;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import util.HibernateUtil;
import util.ServiceUtil;

import java.io.IOException;
import java.util.List;

/**
 * Created by Yura on 04.02.2017.
 */
public class Initial extends Application {
    public static void main(String[] args) {

    /*Створюємо і записуємо у базу співробітників і користувачів сутність адміна*/
        Employee employerAdmin = new Employee("NameAdmin", "SurnameAdmin", 21, Gender.MALE, Position.ADMIN);
        User userAdmin = new User("A", "1", employerAdmin);
        ServiceUtil.getEmployeeService().add(employerAdmin);
        ServiceUtil.getUserService().add(userAdmin);

        // для легших і швидших перевірок створюємо і додаємо у базу співробітника і користувача.
        // після закінчення роботи запис можна видалити.
        // але це директор, тому можна і залишити :)*/
        Employee employer1 = new Employee("Name", "Surname", 89, Gender.FEMALE, Position.MANAGER);
        User user1 = new User("D", "1", employer1);
        ServiceUtil.getEmployeeService().add(employer1);
        ServiceUtil.getUserService().add(user1);

        Employee employeeCashier = new Employee("NameCashier", "SurnameCashier", 33, Gender.MALE, Position.CASHIER);
        User userCashier = new User("C", "1", employeeCashier);
        ServiceUtil.getEmployeeService().add(employeeCashier);
        ServiceUtil.getUserService().add(userCashier);

        Employee employeeStoreKeeper = new Employee("NameStoreKeeper", "SurnameStoreKeeper", 33, Gender.MALE, Position.STOREKEEPER);
        User userStoreKeeper = new User("S", "1", employeeStoreKeeper);
        ServiceUtil.getEmployeeService().add(employeeStoreKeeper);
        ServiceUtil.getUserService().add(userStoreKeeper);

       /*Client client2 = new Client("client2", "cli1", "age", "phone", "bla@bla.com");
        Client client3 = new Client("client3", "cli1", "age", "phone", "bla@bla.com");
        ServiceUtil.getClientService().add(client1);
        ServiceUtil.getClientService().add(client2);
        ServiceUtil.getClientService().add(client3);*/

        Client client1 = new Client("client1", "cli1", "age", "phone", "bla@bla.com");
        ServiceUtil.getClientService().add(client1);

        Order order1 = new Order(OrderStatus.FORMED, "Goods");
        //ServiceUtil.getOrderService().add(order1);

        /*Order order1 = new Order(OrderStatus.FORMED, employer1, client1);
        client1.getOrderList().add(order1);
        ServiceUtil.getClientService().add(client1);
        //ServiceUtil.getOrderService().add(order1);*/

/*
        Order order2 = new Order(OrderStatus.FORMED,  employer1, client2 );
        Order order3 = new Order(OrderStatus.NEW,  employer1, client3 );
        ServiceUtil.getOrderService().add(order2);
        ServiceUtil.getOrderService().add(order3);
        */


        List<User> userList = ServiceUtil.getUserService().findAll();
        for (User us : userList) {
            System.out.println("============ " + us);
        }


        Application.launch(args);
        HibernateUtil.getSessionFactory().close();
    }

    public void start(Stage primaryStage) throws Exception {

        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("view/enterWindow.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        primaryStage.setTitle("Авторизация");
        Scene scene = new Scene(root);
        scene.getStylesheets().add(Initial.class
                .getResource("/view/enterWindow.css")
                .toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
    }
}

