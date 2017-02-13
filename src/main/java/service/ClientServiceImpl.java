package service;

import dao.ClientDao;
import dao.ClientDaoImpl;
import entity.Client;

import java.util.List;

/**
 * Created by Олег on 13.02.2017.
 */
public class ClientServiceImpl implements ClientService{

    private ClientDao clientDao;
    public ClientServiceImpl(){
        clientDao = new ClientDaoImpl();
    }

    /*метод додає у базу нового кліента (Client)
    * для цього у метод треба передати об"єкт типу Client
    * повертає унікальний id*/
    @Override
    public Long add(Client client) {
        if(client != null && !isCreatedClient(client)) {
            Long id = clientDao.create(client);
            return id;
        }
        return null;
    }

    /*метод без параметрів, повертає список List<> усіх кліентів*/
    @Override
    public List<Client> findAll() {
        return clientDao.findAll();
    }


    /*метод видаляє з бази кліента (Client)
    * для цього у метод треба передати унікальний id
    * повертає true якщо успішно видалили*/
    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public boolean changeClient(Long id, Client client) {
        return false;
    }

    @Override
    public boolean changeName(Long id, String name) {
        return false;
    }

    @Override
    public boolean changeSurename(Long id, String sureName) {
        return false;
    }

    @Override
    public boolean changeAge(Long id, Integer age) {
        return false;
    }

    @Override
    public boolean changePhoneI(Long id, Integer phone) {
        return false;
    }

    @Override
    public boolean changeEmail(Long id, String email) {
        return false;
    }

    @Override
    public Long findIdClient(Client client) {
        return null;
    }

    @Override
    public List<Client> findBySomeStringParam(String someParam) {
        return null;
    }

    @Override
    public List<Client> findByIntegerParam(Integer minAge, Integer maxAge) {
        return null;
    }

    @Override
    public boolean isCreatedClient(Client client) {
        return false;
    }

    /*

     */
}
