import entity.Employer;
import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

/**
 * Created by Yura on 04.02.2017.
 */
public class Initial {

    public static void main(String[] args) {
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
    }
}

