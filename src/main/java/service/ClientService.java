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
    boolean changeClient(Long id, Client client);
    boolean changeName(Long id, String name);
    boolean changeSurename(Long id, String sureName);
    boolean changeAge(Long id, Integer age);
    boolean changePhoneI(Long id, Integer phone);
    boolean changeEmail(Long id, String email);

    Long findIdClient(Client client);
    List<Client> findBySomeStringParam(String someParam);
    List<Client> findByIntegerParam(Integer minAge, Integer maxAge);

    boolean isCreatedClient(Client client);


}
