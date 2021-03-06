package service;

import entity.Client;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Олег on 13.02.2017.
 */
@Service
public interface ClientService {
    Long add(Client client);
    List<Client> findAll();

    void delete(Long id);
    void changeClient(Client oldClient, Client newClient);
    Long findIdClient(Client client);
    boolean isCreatedClient(Client client);
}
