package dao;

import entity.Client;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

import java.util.List;

/**
 * Created by Yura on 13.02.2017.
 */
public class ClientDaoImpl implements ClientDao {
    private SessionFactory factory;
    public ClientDaoImpl() {factory = HibernateUtil.getSessionFactory();}

    // первое приближение метода create
    @Override
    public Long create(Client client) {
        if(client != null) {
            if (!(client.getName().isEmpty())
                    && !(client.getSureName().isEmpty())
                    && !(client.getAge().isEmpty())
                    && !(client.getPhone().isEmpty())
                    && !(client.getEmail().isEmpty())) {
                Session session = factory.openSession();
                try {
                    session.beginTransaction();
                    Long id = (Long) session.save(client);
                    session.getTransaction().commit();
                    return id;
                } catch (HibernateException e) {
                    session.getTransaction().rollback();
                } finally {
                    session.close();
                }
            }
        }
        return null;
    }

    @Override
    public Client read(Long id) {
        List<Client> clients = findAll();
        for (Client client : clients) {
            if(client.getId() == id) {
                return client;
            }
        }
        return null;
    }

    @Override
    public boolean update(Client client) {
        if (client != null) {
            Session session = factory.openSession();
            try {
                session.beginTransaction();
                session.update(client);
                session.getTransaction().commit();
                return true;

            } catch (HibernateException e) {
                session.getTransaction().rollback();
            } finally {
                session.close();
            }
        }
        return false;
    }

    @Override
    public boolean delete(Client client) {
        if(client != null) {
            Session session = factory.openSession();
            try {
                session.beginTransaction();
                session.delete(client);
                session.getTransaction().commit();
                return true;

            } catch (HibernateException e) {
                session.getTransaction().rollback();
            } finally {
                session.close();
            }
        }
        return false;
    }

    @Override
    public List<Client> findAll() {
        return factory.openSession().createCriteria(Client.class).list();
    }
}
