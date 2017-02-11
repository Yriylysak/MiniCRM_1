import controller.EnterContorller;
import controller.GraphicsLoader;
import entity.Employee;
import entity.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import service.EmployeeService;
import service.EmployeeServiceImpl;
import service.UserService;
import service.UserServiceImpl;
import util.HibernateUtil;

import java.io.IOException;
import java.util.List;

/**
 * Created by Yura on 04.02.2017.
 */
public class Initial extends Application
{
    public static void main(String[] args)
    {
        EmployeeService employerService = new EmployeeServiceImpl();
        UserService userService = new UserServiceImpl();

    /*Створюємо і записуємо у базу співробітників і користувачів сутність адміна*/
    Employee employerAdmin = new Employee("NameAdmin", "SurnameAdmin", 21, "m", "Admin");
     User userAdmin = new User("Admin", "1", employerAdmin);
    employerService.add(employerAdmin);
    userService.add(userAdmin);

    // для легших і швидших перевірок створюємо і додаємо у базу співробітника і користувача.
    // після закінчення роботи запис можна видалити.
    // але це директор, тому можна і залишити :)*/
    Employee employer1 = new Employee("Name", "Surname", 89, "fm", "Director");
    User user1 = new User("Director", "1", employer1);
    employerService.add(employer1);
    userService.add(user1);

    List<User> userList = userService.findAll();
    for(User us : userList) {
       System.out.println("============ " +  us );}






        Application.launch(args);
        HibernateUtil.getSessionFactory().close();
    }

    public void start(Stage primaryStage) throws Exception {

        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("view/enterWindow.fxml"));
        } catch (IOException e){
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

