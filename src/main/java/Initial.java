import entity.Employer;
import entity.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import service.EmployerService;
import service.EmployerServiceImpl;
import service.UserService;
import service.UserServiceImpl;
import util.HibernateUtil;

import java.io.IOException;

/**
 * Created by Yura on 04.02.2017.
 */
public class Initial extends Application{


    public static void main(String[] args)
    {
        //
        EmployerService employerService = new EmployerServiceImpl();
        UserService userService = new UserServiceImpl();

        Employer employerAdmin = new Employer("NameAdmin", "SurnameAdmin", 21, "m", "admin");
        User userAdmin = new User("Admin", "1", employerAdmin);
        employerService.add(employerAdmin);
        userService.add(userAdmin);
        HibernateUtil.getSessionFactory().close();

        // Commit
        Application.launch(args);





    }

    public void start(Stage primaryStage) throws Exception {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("view/enterWindow.fxml"));


        } catch (IOException e){e.printStackTrace();}

        primaryStage.setTitle("Авторизация");
        Scene scene = new Scene(root);
        scene.getStylesheets().add(Initial.class
                .getResource("/view/enterWindow.css")
                .toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}

