import dao.OrderingDaoImpl;
import entity.*;
import enumTypes.Gender;
import enumTypes.OrderStatus;
import enumTypes.Position;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import util.DaoUtil;
import util.HibernateUtil;
import util.ServiceUtil;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by Yura on 04.02.2017.
 */
public class Initial extends Application {
    public static void main(String[] args) {
        Employee employerHeisenberg = new Employee("Walter", "White", 53, Gender.MALE, Position.ROOT);
        User userHeisenberg = new User("Heisenberg", "1", employerHeisenberg);
        //встановлюємо зв"язок між співробітником і новоствореним юзером
        employerHeisenberg.setId(ServiceUtil.getEmployeeService().add(employerHeisenberg));
        employerHeisenberg.setUser(DaoUtil.getUserDao().read(ServiceUtil.getUserService().add(userHeisenberg)));
        DaoUtil.getEmployeeDao().update(employerHeisenberg);

        /*Створюємо і записуємо у базу співробітників і користувачів*/
        Employee employerAdmin = new Employee("NameAdmin", "SurnameAdmin", 21, Gender.MALE, Position.ADMIN);
        User userAdmin = new User("A", "1", employerAdmin);
        employerAdmin.setId(ServiceUtil.getEmployeeService().add(employerAdmin));
        employerAdmin.setUser(DaoUtil.getUserDao().read(ServiceUtil.getUserService().add(userAdmin)));
        DaoUtil.getEmployeeDao().update(employerAdmin);
        // для легших і швидших перевірок створюємо і додаємо у базу співробітника і користувача.
        Employee employer1 = new Employee("Name", "Surname", 89, Gender.FEMALE, Position.MANAGER);
        User user1 = new User("D", "1", employer1);
        employer1.setId(ServiceUtil.getEmployeeService().add(employer1));
        employer1.setUser(DaoUtil.getUserDao().read(ServiceUtil.getUserService().add(user1)));
        DaoUtil.getEmployeeDao().update(employer1);

        Employee employeeCashier = new Employee("NameCashier", "SurnameCashier", 33, Gender.MALE, Position.CASHIER);
        User userCashier = new User("C", "1", employeeCashier);
        employeeCashier.setId(ServiceUtil.getEmployeeService().add(employeeCashier));
        employeeCashier.setUser(DaoUtil.getUserDao().read(ServiceUtil.getUserService().add(userCashier)));
        DaoUtil.getEmployeeDao().update(employeeCashier);


        Employee employeeStoreKeeper = new Employee("NameStoreKeeper", "SurnameStoreKeeper", 33, Gender.MALE, Position.STOREKEEPER);
        User userStoreKeeper = new User("S", "1", employeeStoreKeeper);
        employeeStoreKeeper.setId(ServiceUtil.getEmployeeService().add(employeeStoreKeeper));
        employeeStoreKeeper.setUser(DaoUtil.getUserDao().read(ServiceUtil.getUserService().add(userStoreKeeper)));
        DaoUtil.getEmployeeDao().update(employeeStoreKeeper);

        Client client1 = new Client("client1", "cli1", "age", "phone", "bla@bla.com");
        ServiceUtil.getClientService().add(client1);


        List<User> userList = ServiceUtil.getUserService().findAll();
        for (User us : userList) {
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

