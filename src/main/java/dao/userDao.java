package dao;

import entity.User;

import java.util.List;

/**
 * Created by Comfy on 05.02.2017.
 */
public interface userDao {
    Long create(User user);
    User read(String password);
    boolean update(User user);
    boolean delete(User user);
    List<User> findAll();
}
