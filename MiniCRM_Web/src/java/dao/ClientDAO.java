package dao;

import entity.Client;

import java.util.List;

/**
 * Created by Julia on 06.03.2017.
 */
public interface ClientDAO {
    Long create(Client client);
    Client read(Long id);
    Boolean update(Client client);
    Boolean delete(Client client);
    List<Client> findAll();
}
