import entity.Employer;
import entity.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

import java.io.IOException;

/**
 * Created by Yura on 04.02.2017.
 */
public class Initial extends Application{


    public static void main(String[] args) {
        Application.launch(args);

        SessionFactory factory = HibernateUtil.getSessionFactory();

        User user = new User();
        Employer employer = new Employer();

        //user.setEmployer(employer);

        Session session = factory.openSession();

        session.beginTransaction();
        session.save(employer);
        session.getTransaction().commit();

        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();

        HibernateUtil.getSessionFactory().close();

        // Commit



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

