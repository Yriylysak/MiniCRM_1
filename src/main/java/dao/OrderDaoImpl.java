package dao;

import entity.Employee;
import entity.Order;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

import java.util.List;

/**
 * Created by Yura on 13.02.2017.
 */
public class OrderDaoImpl implements OrderDao
{
    private SessionFactory factory;

    public OrderDaoImpl() {
        factory = HibernateUtil.getSessionFactory();
    }

    // первое приближение метода create
    @Override
    public Long create(Order order) {
        if(order!=null)
        {
            Session session = factory.openSession();
            try
            {
                Long id = (Long) session.save(order);
                session.getTransaction().commit();
                return id;

            } catch (HibernateException e) {session.getTransaction().rollback();}
            session.close();
        }
        return null;
    }

    @Override
    public Order read(Long id) {
        List<Order> orders = findAll();
        for (Order order : orders) {
            if(order.getId()== id)
            {
                return order;
            }
        }
        return null;
    }

    @Override
    public boolean update(Order order)
    {
        if(order!=null)
        {
            List<Order> orders = findAll();
            for (Order order1 : orders) {
                if(order.getId() == order1.getId())
                {
                    Session session = factory.openSession();
                    try
                    {
                        session.beginTransaction();
                        session.update(order);
                        session.getTransaction().commit();
                        return true;

                    } catch (HibernateException e) {session.getTransaction().rollback();}
                    session.close();
                }

            }
        }
        return false;
    }

    @Override
    public boolean delete(Order order)
    {
        if(order!=null)
        {
            List<Order> orders = findAll();
            for (Order order1 : orders) {

                if(order.getId() == order1.getId())
                {
                    Session session = factory.openSession();
                    try
                    {
                        session.beginTransaction();
                        session.delete(order);
                        session.getTransaction().commit();
                        return true;
                    } catch (HibernateException e) {session.getTransaction().rollback();}
                    session.close();
                }

            }
        }
        return false;
    }

    @Override
    public List<Order> findAll()
    { return factory.openSession().createCriteria(Order.class).list();}
}
