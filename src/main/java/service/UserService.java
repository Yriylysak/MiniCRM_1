package service;

import entity.Employee;
import entity.User;
import enumTypes.Position;

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
    Position isUser(String login, String password);
    User createUser(Employee employee);
    String createLogin(String name, String surname);
    String createPassword();
    Long findUser(Employee employee);
    User getCurrentUser(String login, String password);
}
