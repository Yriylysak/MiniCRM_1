package dao;

import entity.Employer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

import java.util.List;

/****
 * Created by JL on 05.02.2017.
 */

public class EmployerDaoImpl implements EmployerDao {
    private SessionFactory factory;

    public EmployerDaoImpl() {
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
    public Employer read(Long id) {
        List<Employer> employers = findAll();
        for(Employer empl : employers) {
            if(empl.getId() == id) {
                return empl;
            }
        }
        return null;
    }
    @Override
    public boolean update(Employer employer) {
        Session session = factory.openSession();
        try{
            session.beginTransaction();
            session.update(employer);
            session.getTransaction().commit();
            return  true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        }
        return false;    }
    @Override
    public boolean delete(Employer employer) {
        if (employer != null) {
            List<Employer> employers = findAll();
            for (Employer empl : employers) {
                if (employer.getId() == empl.getId()) {
                    Session session = factory.openSession();
                    try {
                        session.beginTransaction();
                        session.delete(employer);
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
    public List<Employer> findAll() {
        return factory.openSession().createCriteria(Employer.class).list();
    }
}
