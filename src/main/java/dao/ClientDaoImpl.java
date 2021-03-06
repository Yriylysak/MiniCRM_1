package dao;

import entity.Client;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("clientDao")
public class ClientDaoImpl implements ClientDao {
    @Autowired
    private SessionFactory factory;

    public ClientDaoImpl() {}

    @Override
    @Transactional
    public Long create(Client client) {
        return (Long) factory.getCurrentSession().save(client);
    }

    @Override
    @Transactional
    public Client read(Long id) {
        // ??
        return (Client) factory.getCurrentSession().get("CLIENT", id);
    }

    @Override
    @Transactional
    public void update(Client client) {
        factory.getCurrentSession().update(client);
    }

    @Override
    @Transactional
    public void delete(Client client) {
        factory.getCurrentSession().delete(client);
    }

    @Override
    @Transactional
    public List<Client> findAll() {
        //return factory.openSession().createCriteria(Client.class).list();
        return factory.getCurrentSession()
                .createCriteria(Client.class).list();
    }
}
