package web.service;

import web.entity.Client;

import java.util.List;

/**
 * Created by Comfy on 12.03.2017.
 */
public interface ClientService {
    Long add(Client client);
    List<Client> findAll();

    void delete(Long id);
    void changeClient(Client oldClient, Client newClient);
    Long findIdClient(Client client);
    boolean isCreatedClient(Client client);
}
