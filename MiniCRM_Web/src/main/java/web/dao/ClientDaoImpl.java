package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.entity.Client;

import java.util.List;

/**
 * Created by Comfy on 12.03.2017.
 */
@Repository
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
        return factory.getCurrentSession()
                .createCriteria(Client.class).list();
    }
}