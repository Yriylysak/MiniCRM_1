package dao;

import entity.Client;
import java.util.List;

/**
 * Created by Yura on 13.02.2017.
 */
public interface ClientDao
{
    Long create(Client client);
    Client read(Long id);
    boolean update(Client client);
    boolean delete(Client client);
    List<Client> findAll();


}
