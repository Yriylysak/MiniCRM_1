package service;

import dao.ClientDao;
import dao.ClientDaoImpl;
import entity.Client;
import util.DaoUtil;
import util.ServiceUtil;

import java.util.List;

/**
 * Created by Олег on 13.02.2017.
 */
public class ClientServiceImpl implements ClientService{

    public ClientServiceImpl(){  }

    /*метод додає у базу нового кліента (Client)
    * для цього у метод треба передати об"єкт типу Client
    * повертає унікальний id*/
    @Override
    public Long add(Client client) {
        if(client != null && !isCreatedClient(client)) {
            Long id = DaoUtil.getClientDao().create(client);
            return id;
        }
        return null;
    }

    /*метод без параметрів, повертає список List<> усіх кліентів*/
    @Override
    public List<Client> findAll() {
        return DaoUtil.getClientDao().findAll();
    }

    /*метод видаляє з бази кліента (Client)
    * для цього у метод треба передати унікальний id
    * повертає true якщо успішно видалили*/
    @Override
    public boolean delete(Long id) {
        Client client = DaoUtil.getClientDao().read(id);
        return DaoUtil.getClientDao().delete(client);
    }

    @Override
    public boolean changeClient(Client oldClient, Client newClient) {
       if (oldClient != null && newClient != null) {
           oldClient.setName(newClient.getName());
           oldClient.setSureName(newClient.getSureName());
           oldClient.setAge(newClient.getAge());
           oldClient.setEmail(newClient.getEmail());
           oldClient.setPhone(newClient.getPhone());
           DaoUtil.getClientDao().update(oldClient);
           return true;
       }
       return false;
    }
    /*
    @Override
    public boolean changeName(Long id, String name) {
        List<Client> clients = DaoUtil.getClientDao().findAll();
        for (Client cl : clients) {
            if (cl.getId() == id) {
                cl.setName(name);
                DaoUtil.getClientDao().update(cl);
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean changeSurname(Long id, String sureName) {
        List<Client> clients = DaoUtil.getClientDao().findAll();
        for (Client cl : clients) {
            if (cl.getId() == id) {
                cl.setSureName(sureName);
                DaoUtil.getClientDao().update(cl);
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean changeAge(Long id, Integer age) {
        List<Client> clients = DaoUtil.getClientDao().findAll();
        for (Client cl : clients) {
            if (cl.getId() == id) {
                cl.setAge(age);
                DaoUtil.getClientDao().update(cl);
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean changePhoneI(Long id, Integer phone) {
        List<Client> clients = DaoUtil.getClientDao().findAll();
        for (Client cl : clients) {
            if (cl.getId() == id) {
                cl.setPhone(phone);
                DaoUtil.getClientDao().update(cl);
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean changeEmail(Long id, String email) {
        List<Client> clients = DaoUtil.getClientDao().findAll();
        for (Client cl : clients) {
            if (cl.getId() == id) {
                cl.setEmail(email);
                DaoUtil.getClientDao().update(cl);
                return true;
            }
        }
        return false;
    }
    */

    @Override
    public Long findIdClient(Client client) {
        if (client != null) {
            List<Client> clients = ServiceUtil.getClientService().findAll();
            for (Client cl : clients) {
                if (cl.equals(client)) {
                    return cl.getId();
                }
            }
        }
        return null;
    }

    @Override
    public boolean isCreatedClient(Client client) {
        List<Client> clients = ServiceUtil.getClientService().findAll();
        for (Client cl : clients) {
            if (cl.equals(client)) {
                return true;
            }
        }
        return false;
    }
}
