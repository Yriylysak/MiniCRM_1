package service;

import entity.Employer;
import entity.User;

import java.util.List;

/**
 * Created by Comfy on 05.02.2017.
 */
public interface userService {
    Long add(User notebook);
    List<User> findAll();
    void changePassword(String  login, String password);
    boolean delete(String login);
}
