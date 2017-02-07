package dao;

import entity.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

import java.util.List;

/**
 * Created by JL on 05.02.2017.
 */
public class UserDaoImpl implements UserDao{
    private SessionFactory factory;
    public UserDaoImpl() {
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
    public User read(Long id) {
        List<User> users = findAll();
        for (User us : users) {
            if (us.getId() == id) {
                return us;
            }
        }
        return null;
    }

    @Override
    public boolean update(User user) {
        Session session = factory.openSession();
        try{
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
            return  true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }
        return false;
    }

    @Override
    public boolean delete(User user) {
        if (user != null) {
            List<User> users = findAll();
            for (User us : users) {
                if (user.getId() == us.getId()) {
                    Session session = factory.openSession();
                    try {
                        session.beginTransaction();
                        session.delete(user);
                        session.getTransaction().commit();
                        return true;
                    } catch (HibernateException e) {
                        session.getTransaction().rollback();
                    }
                }
            }
        }
        return false;
    }

    @Override
    public List<User> findAll() {
        return factory.openSession().createCriteria(User.class).list();
    }
}
