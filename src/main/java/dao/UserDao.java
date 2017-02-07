package dao;

import entity.User;

import java.util.List;

/**
 * Created by JL on 05.02.2017.
 */
public interface UserDao {
    Long create(User user);
    User read(Long id);
    boolean update(User user);
    boolean delete(User user);
    List<User> findAll();
}
