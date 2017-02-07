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
    boolean delete(Long id);
    boolean changePassword(Long id, String oldPassword, String newPassword);

    boolean isAdmin(String login, String password);
    boolean isUser(String login, String password);
    User createUser(Employer employer);
    String createLogin(String name, String surname);
    String createPassword();

}
