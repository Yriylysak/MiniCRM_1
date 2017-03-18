package dao;

import entity.Client;
import entity.Ordering;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import util.HibernateUtil;

import javax.persistence.criteria.Order;
import java.util.List;

/***
 * Created by JL on 19.02.2017.
 */
@Repository("orderingDao")
public class OrderingDaoImpl implements OrderingDao {
    @Autowired
    private SessionFactory factory;

    public OrderingDaoImpl() {
    }

    @Override
    @Transactional
    public Long create(Ordering ordering) {
        return (Long) factory.getCurrentSession().save(ordering);
    }

    @Override
    @Transactional
    public Ordering read(Long id) {
        return (Ordering) factory.getCurrentSession().get(Ordering.class, id);
    }

    @Override
    @Transactional
    public void update(Ordering ordering) {
        factory.getCurrentSession().update(ordering);
    }

    @Override
    @Transactional
    public void delete(Ordering ordering) {
        factory.getCurrentSession().delete(ordering);
    }

    @Override
    @Transactional
    public List<Ordering> findAll() {
        //return factory.openSession().createCriteria(Client.class).list();
        return factory.getCurrentSession()
                .createCriteria(Ordering.class).list();
    }
}