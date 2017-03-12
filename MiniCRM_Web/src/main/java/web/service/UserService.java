package web.service;


import web.entity.User;

import java.util.List;

/**
 * Created by Comfy on 12.03.2017.
 */
public interface UserService {

    Long add(User user);
    List<User> findAll();

    void delete(Long id);
    void changeClient(User oldUser, User newUser);
    Long findIdClient(User user);
    boolean isCreatedClient(User user);
    boolean auth(String login, String password);
}
