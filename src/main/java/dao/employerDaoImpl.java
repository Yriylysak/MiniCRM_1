package dao;

import entity.Employer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;


import java.util.List;

/**
 * Created by Comfy on 05.02.2017.
 */

public class employerDaoImpl implements employerDao {
    private SessionFactory factory;

    public employerDaoImpl () {
        factory = HibernateUtil.getSessionFactory();
    }

    @Override
    public Long create(Employer employer) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            Long id = (Long) session.save(employer);
            session.getTransaction().commit();
            return id;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }
        return null;
    }

    @Override
    public Employer read(String password) {

        return null;
    }

    @Override
    public boolean update(Employer ntb) {
        return false;
    }

    @Override
    public boolean delete(Employer ntb) {
        return false;
    }

    @Override
    public List<Employer> findAll() {
        return factory.openSession().createCriteria(Employer.class).list();
    }
}
