package web.dao;

import web.entity.Client;

import java.util.List;

/**
 * Created by Comfy on 12.03.2017.
 */
public interface ClientDao {
    Long create(Client client);
    Client read(Long id);
    void update(Client client);
    void delete(Client client);
    List<Client> findAll();
}
