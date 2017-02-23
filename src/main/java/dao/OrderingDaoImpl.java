package dao;

import entity.Ordering;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

import java.util.List;

/***
 * Created by JL on 19.02.2017.
 */
public class OrderingDaoImpl implements OrderingDao {
    private SessionFactory factory;
    public OrderingDaoImpl() {
        factory = HibernateUtil.getSessionFactory();
    }

    @Override
    public Long create(Ordering ordering) {

        Session session = factory.openSession();
        try {
            session.beginTransaction();
            Long id = (Long) session.save(ordering);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public Ordering read(Long id) {
        List<Ordering> orderings = findAll();
        for (Ordering ord : orderings) {
            if(ord.getId() == id) {
                return ord;
            }
        }
        return null;
    }

    @Override
    public boolean update(Ordering ordering) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.update(ordering);
            session.getTransaction().commit();
            return true;

        } catch (HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean delete(Ordering ordering) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.delete(ordering);
            session.getTransaction().commit();
            return true;

        } catch (HibernateException e) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public List<Ordering> findAll() {
        return factory.openSession().createCriteria(Ordering.class).list();    }
}