package service;

import entity.Client;

import java.util.List;

/**
 * Created by Олег on 13.02.2017.
 */
public interface ClientService {
    Long add(Client client);
    List<Client> findAll();

    boolean delete(Long id);
    boolean changeClient(Client oldClient, Client newClient);
    Long findIdClient(Client client);
    boolean isCreatedClient(Client client);
}
