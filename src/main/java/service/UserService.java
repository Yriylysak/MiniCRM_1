package service;

import entity.Employer;
import entity.User;

import java.util.List;

/**
 * Created by JL on 05.02.2017.
 */
public interface UserService {
    Long add(User user);
    List<User> findAll();
    void changePassword(String  login, String password);
    boolean delete(String login);

}
