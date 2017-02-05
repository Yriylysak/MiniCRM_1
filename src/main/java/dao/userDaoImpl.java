package dao;

import entity.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

import java.util.List;

/**
 * Created by Comfy on 05.02.2017.
 */
public class userDaoImpl implements userDao{
    private SessionFactory factory;
    public userDaoImpl() {
        factory = HibernateUtil.getSessionFactory();
    }

    @Override
    public Long create(User user) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            Long id = (Long) session.save(user);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }
        return null;    }

    @Override
    public User read(String password) {
        return null;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean delete(User user) {
        return false;
    }

    @Override
    public List<User> findAll() {
        return null;
    }
}
